package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.security.model.Org;
import com.yada.security.service.OrgManager;
import com.yada.service.util.BeanUtils;
import com.yada.ssp.model.TranSummer;
import com.yada.ssp.query.TranSummerQuery;
import com.yada.ssp.reportModel.TranSummerReportQuery;
import com.yada.ssp.service.FeeTableManager;
import com.yada.ssp.service.MerchantBusinessManager;
import com.yada.ssp.service.TranSummerManager;
import com.yada.xmlUtils.ReportHeader;
import com.yada.xmlUtils.StringUtils;
import net.sf.json.JSONArray;
import net.sf.jxls.transformer.XLSTransformer;
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
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xianyong
 */
@Controller
public class TranSummerController extends BaseController {

    @Autowired
    private TranSummerManager tranSummerManager;
    @Autowired
    private OrgManager orgManager;

    @RequestMapping
    public String list(Model model, TranSummerQuery query) {
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
       /* String orgId = getCurUser().getUserExt().getOrgId();
        Org org = orgManager.getById(orgId);
        model.addAttribute("orgLev", org.getOrgLev());
        if ("1".equals(org.getOrgLev().toString())) {
            List<Org> orgs = orgManager.findZbankList(orgId);
            model.addAttribute("orgs", orgs);
            String lowerOrgId = query.getpOrgId();
            List<Org> lowerOrgs = null;
            if (lowerOrgId != null && !lowerOrgId.equals("")) {
                lowerOrgs = orgManager.findZbankList(query.getOrgId());
            }
            model.addAttribute("lowerOrgs", lowerOrgs);
        }
        if ("2".equals(org.getOrgLev().toString())) {
            List<Org> orgs = orgManager.findByPOrgId(orgId);
            model.addAttribute("orgs", orgs);
            query.setOrgId(orgId);
        }
        if ("3".equals(org.getOrgLev().toString())) {
            model.addAttribute("org", org);
        }
*/
        Page page = tranSummerManager.queryPage(query);
        List<TranSummer> tranSummers = new ArrayList<TranSummer>();
        if(query.isShow()==true) {
            tranSummers = tranSummerManager.findAll(query);
        }
        //金额的汇总
        Long sumConsume = 0l;
        Double sumConsumeAmt = 0.0;
        Long sumRefund = 0l;

        Double sumRefundAmt = 0.0;
        Long sumUndo = 0l;
        Double sumUndoAmt = 0.0;

        TranSummer tranSummer1 = new TranSummer();
        for (TranSummer tranSummer : tranSummers) {
            sumConsume = sumConsume + tranSummer.getSumConsume();
            //Double精准值
            sumConsumeAmt = new BigDecimal(Double.toString(sumConsumeAmt)).add(new BigDecimal(Double.toString(tranSummer.getSumConsumeAmt()))).doubleValue();
            sumRefund = sumRefund + tranSummer.getSumRefund();
            sumRefundAmt =new BigDecimal(Double.toString(sumRefundAmt)).add(new BigDecimal(Double.toString(tranSummer.getSumRefundAmt()))).doubleValue();
            sumUndo = sumUndo + tranSummer.getSumUndo();
            sumUndoAmt =new BigDecimal(Double.toString(sumUndoAmt)).add(new BigDecimal(Double.toString(tranSummer.getSumUndoAmt()))).doubleValue();
        }
        tranSummer1.setSumConsume(sumConsume);
        tranSummer1.setSumConsumeAmt(sumConsumeAmt);
        tranSummer1.setSumRefund(sumRefund);
        tranSummer1.setSumRefundAmt(sumRefundAmt);
        tranSummer1.setSumUndo(sumUndo);
        tranSummer1.setSumUndoAmt(sumUndoAmt);

        model.addAttribute("tranSummer",tranSummer1);
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        return "/ssp_pages/TranSummer/list";
    }

    /**
     * 本地商户汇总报表
     *
     * @param query 查询条件
     * @param
     * @throws IOException                                                下载时的IO异常
     * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException 创建表格异常
     */
    @RequestMapping
    public ResponseEntity<byte[]> downloadErrorTranLsReport(TranSummerQuery query) throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException, ParseException {
        String orgId = getCurUser().getUserExt().getOrgId();
        Org org = orgManager.getById(orgId);
        if ("2".equals(org.getOrgLev().toString())) {
            query.setOrgId(orgId);
        }
        List<TranSummer> tranSummers = tranSummerManager.findAll(query);
        List<Map<String, String>> page = new ArrayList<>();
        for (TranSummer tranSummer : tranSummers) {
            page.add(BeanUtils.beanToMap(tranSummer));
        }
        StringUtils date = new StringUtils();
        String reportName = "本地汇总报表_" + date.getStringToDate() + "_" + getCurUser().getLoginName();
        String[] reportLine = {"businessName", "merchantId","merchantCname", "sumConsume", "sumConsumeAmt", "sumRefund", "sumRefundAmt", "sumUndo", "sumUndoAmt", "name", "date"};
        return createExcel(reportName, reportLine, ReportHeader.tranSummerHeader, page);
    }

    /**
     * Excel文件下载处理
     *
     * @param reportName 要导出报表的文件名称
     * @param fields     要导出报表字段属性名集合
     * @param header     要导出报表字段名称
     * @param page       要导出报表的数据
     */
    private ResponseEntity<byte[]> createExcel(String reportName, String[] fields, Map<String, String> header, List<Map<String, String>> page) throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
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
