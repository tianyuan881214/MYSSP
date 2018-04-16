package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.security.model.Org;
import com.yada.security.service.OrgManager;
import com.yada.service.util.BeanUtils;
import com.yada.ssp.model.LiquidationReport;
import com.yada.ssp.model.LiquidationReportD;
import com.yada.ssp.query.LiquidationReportQuery;
import com.yada.ssp.service.LiquidationReportManager;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LiquidationReportController extends BaseController {
    @Autowired
    private LiquidationReportManager liquidationReportManager;
    @Autowired
    private OrgManager orgManager;

    @RequestMapping
    public String list(Model model, LiquidationReportQuery query) {
        //查询它所属的机构看是否存在
          String orgId = getCurUser().getUserExt().getOrgId();
          List<Org> lowerOrgs = orgManager.findBelongcOrg();
          model.addAttribute("orgs", lowerOrgs);

//        if(query.getOrgId() ==null||query.getOrgId().equals("")) {
//            String orgId = getCurUser().getUserExt().getOrgId();
//          //  List<Org> lowerOrgs = orgManager.findLowerPrvcOrg();
//            List<Org> lowerOrgs = orgManager.findBelongcOrg();
//            model.addAttribute("orgs", lowerOrgs);
//            query.setOrgId(orgId);
//        }else
//        {
//           // List<Org> lowerOrgs = orgManager.findOrgList(query.getOrgId());
//            //model.addAttribute("orgs", lowerOrgs);
//        }
        Page page = liquidationReportManager.queryPage(query);
      /*  List<LiquidationReport>  liquidationReport = page.getResult();
        for (LiquidationReport liquidationReports : liquidationReport) {
            liquidationReports.getBusinessBase()
        }*/
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        return "/ssp_pages/LiquidationReport/list";
    }


    /**
     * 下载对账汇总报表
     *
     * @param query 查询条件
     * @throws IOException            下载时的IO异常
     * @throws InvalidFormatException 创建表格异常
     */
    @RequestMapping
    public ResponseEntity<byte[]> downloadErrorTranLsReport(LiquidationReportQuery query) throws IOException, InvalidFormatException, ParseException {
        //查询它所属的机构看是否存在
        if(query.getOrgId() ==null||query.getOrgId().equals("")) {
            String orgId = getCurUser().getUserExt().getOrgId();
            query.setOrgId(orgId);
        }
        List<LiquidationReport> liquidationReport = liquidationReportManager.findAll(query);
        List<LiquidationReportD> liquidationReportDs = new ArrayList<>();
        for (LiquidationReport liquidationReport1 : liquidationReport) {
            LiquidationReportD liquidationReportD = new LiquidationReportD();
            liquidationReportD.setBusinessBase(liquidationReport1.getBusinessBase());
            liquidationReportD.setOrgId(liquidationReport1.getOrgId());
            liquidationReportD.setName(liquidationReport1.getName());
           /* liquidationReportD.setFirstOrgId(liquidationReport1.getFirstOrgId());
            liquidationReportD.setFirstName(liquidationReport1.getFirstName());*/
//            liquidationReportD.setTotalAmount(liquidationReport1.getTotalAmount());
//            liquidationReportD.setOthRate(liquidationReport1.getOthRate());
//            liquidationReportD.setOthFee(liquidationReport1.getOthFee());
//            liquidationReportD.setGsRate(liquidationReport1.getGsRate());
//            liquidationReportD.setGsFee(liquidationReport1.getGsFee());
//            liquidationReportD.setMyFee(liquidationReport1.getMyFee());
//            liquidationReportDs.add(liquidationReportD);
            liquidationReportD.settCount(liquidationReport1.gettCount());
            liquidationReportD.setTotalAmount(liquidationReport1.getTotalAmount());
            liquidationReportD.setAmountFee(liquidationReport1.getAmountFee());
            liquidationReportD.setFee(liquidationReport1.getFee());
            liquidationReportD.setOthFee(liquidationReport1.getOthFee());
            liquidationReportD.setGsFee(liquidationReport1.getGsFee());
            liquidationReportD.setMyFee(liquidationReport1.getMyFee());
            liquidationReportDs.add(liquidationReportD);
        }
        List<Map<String, String>> page = new ArrayList<>();
        for (LiquidationReportD LiquidationReportd : liquidationReportDs) {
            if(LiquidationReportd.getBusinessBase().equals("alipay")){
                LiquidationReportd.setBusinessBase("支付宝业务");
            }
            if(LiquidationReportd.getBusinessBase().equals("union")){
                LiquidationReportd.setBusinessBase("银联业务");
            }
            if(LiquidationReportd.getBusinessBase().equals("webchant")){
                LiquidationReportd.setBusinessBase("微信业务");
            }
            page.add(BeanUtils.beanToMap(LiquidationReportd));
        }
        StringUtils date = new StringUtils();
        String reportName = "二级行清算报表_" + date.getStringToDate() + "_" + getCurUser().getLoginName();
        String[] reportLine = {"orgId", "name","tCount","totalAmount","amountFee","fee","othFee" , "gsFee", "myFee"};
        return createExcel(reportName, reportLine, ReportHeader.liquidationReportHeader, page);

    }

    /**
     * Excel文ow
     *
     * @param reportName 要导出报表的文件名称
     * @param fields     要导出报表字段属性名集合，首行列名
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
        //workbook需要的参数为：1，流文件  2.map集合，里面是拥有的
        Workbook workbook = transformer.transformXLS(in, beans);

        workbook.write(out);

        byte[] buf = out.toByteArray();
        out.close();
        in.close();

        String fileName = URLEncoder.encode(reportName, "UTF-8");

        //设置HttpHeaders,使得浏览器响应下载
        HttpHeaders headers = new HttpHeaders();
        //设置响应方式，为文件流的形式读取。它的值为：multipart/form-data
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        //设置响应文件
        headers.setContentDispositionFormData("attachment", fileName + ".xls");
        //把文件以二进制的形式写回
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
