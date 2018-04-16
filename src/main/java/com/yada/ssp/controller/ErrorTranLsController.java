package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.security.model.Org;
import com.yada.security.service.OrgManager;
import com.yada.service.util.BeanUtils;
import com.yada.ssp.model.ErrorTranLs;
import com.yada.ssp.query.ErrorTranLsQuery;
import com.yada.ssp.query.ErrorTranLsReportQuery;
import com.yada.ssp.service.ErrorTranLsManager;
import com.yada.xmlUtils.ReportHeader;
import com.yada.xmlUtils.StringUtils;
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xianyong
 */
@Controller
public class ErrorTranLsController extends BaseController{
    @Autowired
    private ErrorTranLsManager errorTranLsManager;
    @Autowired
    private OrgManager orgManager;

    @RequestMapping
    public String list(Model model, ErrorTranLsQuery query) {

        String orgId = getCurUser().getUserExt().getOrgId();
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
        Page page = errorTranLsManager.queryPage(query);
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        model.addAttribute("headers", ReportHeader.errorTranLsHeader);
        return "/ssp_pages/ErrorTranLs/list";
    }

    @RequestMapping
    public String show(Model model, String id) {
        ErrorTranLs errorTranLs = errorTranLsManager.getById(id);
        model.addAttribute("model", errorTranLs);
        return "/ssp_pages/ErrorTranLs/show";
    }

    /**
     * 下载差错对账报表
     *
     * @param query      查询条件
     * @param reportLine 下载的列
     * @throws IOException            下载时的IO异常
     * @throws InvalidFormatException 创建表格异常
     */
    @RequestMapping
    public ResponseEntity<byte[]> downloadErrorTranLsReport(ErrorTranLsReportQuery query, String[] reportLine) throws IOException, InvalidFormatException, ParseException {
        List<ErrorTranLs> errorTranLsList = errorTranLsManager.findAll(query);
        List<Map<String, String>> page = new ArrayList<>();
        for (ErrorTranLs errorTranLs : errorTranLsList) {
            page.add(BeanUtils.beanToMap(errorTranLs));
        }
        StringUtils date = new StringUtils();
        String reportName = "差错对账报表_" + date.getStringToDate() + "_" + getCurUser().getLoginName();
        return createExcel(reportName, reportLine, ReportHeader.errorTranLsHeader, page);

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
}
