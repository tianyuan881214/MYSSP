package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.security.model.Org;
import com.yada.security.service.OrgManager;
import com.yada.service.util.BeanUtils;
import com.yada.ssp.model.PayTranAlipayLs;
import com.yada.ssp.model.WebCheckFile;
import com.yada.ssp.query.PayTranAilpayLsQuery;
import com.yada.ssp.reportModel.PayTranAlipayLsReportQuery;
import com.yada.ssp.reportModel.WebCheckFileReportQuery;
import com.yada.ssp.service.PayTranAlipayLsManager;
import com.yada.xmlUtils.ReportHeader;
import com.yada.xmlUtils.StringUtils;
import net.sf.json.JSONArray;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.yada.xmlUtils.ReportHeader.payTranAlipayLsHeader;

/**
 * @author xianyong
 */
@Controller
public class PayTranAlipayLsController extends BaseController {
    @Autowired
    private PayTranAlipayLsManager payTranAlipayLsManager;
    @Autowired
    private OrgManager orgManager;

    @RequestMapping
    public String list(Model model, PayTranAilpayLsQuery query){
        if(query.getOrgId() ==null||query.getOrgId().equals("")) {
            String orgId = getCurUser().getUserExt().getOrgId();
            List<Org> lowerOrgs = orgManager.findLowerPrvcOrg();
            model.addAttribute("orgs", lowerOrgs);
            query.setOrgId(orgId);
        }else
        {
            List<Org> lowerOrgs = orgManager.findOrgList(query.getOrgId());
            model.addAttribute("orgs", lowerOrgs);
        }
//        if ("1".equals(org.getOrgLev().toString())) {
//            List<Org> orgs = orgManager.findZbankList(orgId);
//            model.addAttribute("orgs", orgs);
//            String lowerOrgId = query.getpOrgId();
//            List<Org> lowerOrgs = null;
//            if (lowerOrgId != null && !lowerOrgId.equals("")) {
//                lowerOrgs = orgManager.findZbankList(query.getOrgId());
//            }
//            model.addAttribute("lowerOrgs", lowerOrgs);
//        }
//        if ("2".equals(org.getOrgLev().toString())) {
//            List<Org> orgs = orgManager.findByPOrgId(orgId);
//            model.addAttribute("orgs", orgs);
//            query.setOrgId(orgId);
//        }
//        if ("3".equals(org.getOrgLev().toString())) {
//            model.addAttribute("org", org);
//        }
        System.out.println("query:"+query.toString());
        Page page = payTranAlipayLsManager.queryPage(query);
        model.addAttribute("page",page);
        model.addAttribute("query",query);
        return "/ssp_pages/PayTranAilpayLs/list";
    }

    @RequestMapping
    public String show(Model model, String id){
        PayTranAlipayLs payTranAlipayLs = payTranAlipayLsManager.getById(id);
        model.addAttribute("model",payTranAlipayLs);
        return "/ssp_pages/PayTranAilpayLs/show";
    }

    /**
     * 下载支付宝流水
     *
     * @param query 查询条件
     * @throws IOException            下载时的IO异常
     * @throws InvalidFormatException 创建表格异常
     */
    @RequestMapping
    public ResponseEntity<byte[]> downloadPayTranAlipayLsReport(PayTranAilpayLsQuery query) throws IOException, InvalidFormatException, ParseException {
        String orgId = getCurUser().getUserExt().getOrgId();
        Org org = orgManager.getById(orgId);
        if ("2".equals(org.getOrgLev().toString())) {
            query.setOrgId(orgId);
        }
        List<PayTranAlipayLs> payTranAlipayLses = payTranAlipayLsManager.findAll(query);
        List<Map<String, String>> page = new ArrayList<>();
        for (PayTranAlipayLs payTranAlipayLs : payTranAlipayLses) {
            page.add(BeanUtils.beanToMap(payTranAlipayLs));
        }
        StringUtils date = new StringUtils();
        String reportName = "支付宝流水_" + date.getStringToDate() + "_" + getCurUser().getLoginName();
        String[] reportLine = {"storeId", "storeName","terminalId","accountNo", "outTradeNo", "tradeNo", "totalAmount", "tradeType", "tranDate", "tranTime", "name"};
        return createExcel(reportName, reportLine, ReportHeader.payTranAlipayLsHeader, page);

    }

    /**
     * Excel文件下载处理
     *
     * @param reportName 要导出报表的文件名称
     * @param fields     要导出报表字段属性名集合
     * @param header     要导出报表字段名称
     * @param page       要导出报表的数据
     */
    private ResponseEntity<byte[]> createExcel(String reportName, String[] fields, Map<String, String> header, List<Map<String, String>> page) throws IOException, InvalidFormatException {
        InputStream in = ErrorTranLsController.class.getClassLoader().getResourceAsStream("report.xls");
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Map<String, Object> beans = new HashMap<>();
        beans.put("fields", fields);
        beans.put("header", header);
        beans.put("page", page);

        XLSTransformer transformer = new XLSTransformer();
        Workbook workbook = transformer.transformXLS(in, beans);
        workbook.write(out);

        byte[] buf = out.toByteArray();
        out.close();
        in.close();

        String fileName = URLEncoder.encode(reportName, "UTF-8");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setContentDispositionFormData("attachment", fileName + ".xls");
        return new ResponseEntity<>(buf, headers, HttpStatus.OK);
    }

    @RequestMapping
    public void AJAX_findlowerOrg(String orgId, HttpServletResponse response) {
        // 用户分组JSON
        String lowerOrgsJson = "";

        // 查找
        List<Org> lowerOrgs = orgManager.findZbankList(orgId);

        // 转换为JSON
        lowerOrgsJson = JSONArray.fromObject(lowerOrgs).toString();

        // 响应JSON格式数据
        try {
            response.setContentType("text/javascript; charset=utf-8");
            response.getWriter().print(lowerOrgsJson);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
