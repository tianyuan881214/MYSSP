package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.security.model.Org;
import com.yada.security.service.OrgManager;
import com.yada.service.util.BeanUtils;
import com.yada.ssp.model.AlipaySettleSumLs;
import com.yada.ssp.model.UnionSettleLs;
import com.yada.ssp.query.AlipaySettleSumLsQuery;
import com.yada.ssp.query.GdUserCardQuery;
import com.yada.ssp.query.UnionSettleLsQuery;
import com.yada.ssp.service.UnionSettleLsManager;
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
import org.springframework.web.bind.annotation.ModelAttribute;
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
 * Created by Administrator on 2017/9/7.
 */
@Controller
public class UnionSettleLsController extends BaseController{
    @Autowired
    private UnionSettleLsManager unionSettleLsManager;
    @Autowired
    private OrgManager orgManager;
    @RequestMapping
    public String list(Model model, UnionSettleLsQuery query) {
        //关于权限控制的问题，在orgId;
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
        Page page = unionSettleLsManager.queryPage(query);

        model.addAttribute("page", page);
        model.addAttribute("query",query);
        return "/ssp_pages/UnionSettleLs/list";
    }

    @RequestMapping
    public String show(Model model, String id,UnionSettleLsQuery query) {
        UnionSettleLs unionSettleLs = unionSettleLsManager.getById(id);

        model.addAttribute("model",unionSettleLs);
        return "/ssp_pages/UnionSettleLs/show";
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
    public ResponseEntity<byte[]> downloadWebCheckFileReport(UnionSettleLsQuery query) throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException, ParseException {
        String orgId = getCurUser().getUserExt().getOrgId();
        query.setOrgId(orgId);

       /* String orgId = getCurUser().getUserExt().getOrgId();
        Org org = orgManager.getById(orgId);
        if ("2".equals(org.getOrgLev().toString())) {
            query.setOrgId(orgId);
        }*/
        Page page1 = unionSettleLsManager.queryPage(query);
        List<UnionSettleLs> UnionSettleLs = page1.getResult();
        List<Map<String, String>> page = new ArrayList<>();
        for (UnionSettleLs s : UnionSettleLs) {
            s.setIsOthAccount(s.getIsOthAccount().equals("0")?"本行":"他行");
           /* alipaySettleSumLs.setBusinessBase(alipaySettleSumLs.getBusinessBase().equals("000000000000002")?"支付宝业务":"微信业务");*/
            page.add(BeanUtils.beanToMap(s));
        }
        StringUtils date = new StringUtils();
        String reportName = "银联清算报表_" + date.getStringToDate() + "_" + getCurUser().getLoginName();
        String[] reportLine = {"merchantId","orderId", "merchantCname", "accType", "billNo", "billType",
                "bizType","liquindationAmt","settleementAmt","merchantFee","othFee",
                "othFee","myFee","gsFee","amoutFee","isOthAccount","name","liquidationTime"};
        return createExcel(reportName, reportLine, ReportHeader.UnionSettleLsLsHeader, page);
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
