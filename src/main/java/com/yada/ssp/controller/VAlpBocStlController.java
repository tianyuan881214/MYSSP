package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.security.model.Org;
import com.yada.security.service.OrgManager;
import com.yada.service.util.BeanUtils;
import com.yada.ssp.model.VAlpBocStl;
import com.yada.ssp.model.VAlpBocStlD;
import com.yada.ssp.query.VAlpBocStlQuery;
import com.yada.ssp.service.VAlpBocStlManager;
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
public class VAlpBocStlController extends BaseController {
    @Autowired
    private VAlpBocStlManager vAlpBocStlManager;
    @Autowired
    private OrgManager orgManager;

    @RequestMapping
    public String list(Model model, VAlpBocStlQuery query) {
        //查询它所属的机构看是否存在
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
        /*String orgId = getCurUser().getUserExt().getOrgId();
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
        }*/
        Page page = vAlpBocStlManager.queryPage(query);
        VAlpBocStl vAlpBocStl = new VAlpBocStl();
        List<VAlpBocStl> vAlpBocStls = new ArrayList<VAlpBocStl>();
        if(query.isShow()==true) {
            vAlpBocStls = vAlpBocStlManager.findAll(query);
        }
        Double merFee = 0.0;
        Double netAmount = 0.0;
        Double orderSumAmt = 0.0;
        Double serviceAmt = 0.0;
        Double settleAmt = 0.0;
        Double merServiceAmt = 0.0;
        for (VAlpBocStl vAlpBocStl1 : vAlpBocStls) {
            //merFee+    得到merFee,然后转化为double类型的数据，返回double类型的字符串表示形式    doubleValue:返回此对象的value值。
            merFee = new BigDecimal(Double.toString(merFee)).add(new BigDecimal(Double.toString(Double.parseDouble(vAlpBocStl1.getMerFee())))).doubleValue();
            netAmount = new BigDecimal(Double.toString(netAmount)).add(new BigDecimal(Double.toString(Double.parseDouble(vAlpBocStl1.getNetAmount())))).doubleValue();
            orderSumAmt = new BigDecimal(Double.toString(orderSumAmt)).add(new BigDecimal(Double.toString(Double.parseDouble(vAlpBocStl1.getOrderSumAmt())))).doubleValue();
            serviceAmt = new BigDecimal(Double.toString(serviceAmt)).add(new BigDecimal(Double.toString(Double.parseDouble(vAlpBocStl1.getServiceAmt())))).doubleValue();
            settleAmt = new BigDecimal(Double.toString(settleAmt)).add(new BigDecimal(Double.toString(Double.parseDouble(vAlpBocStl1.getSettleAmt())))).doubleValue();
            merServiceAmt =  new BigDecimal(Double.toString(merServiceAmt)).add(new BigDecimal(Double.toString(Double.parseDouble(vAlpBocStl1.getMerServiceAmt())))).doubleValue();
        }
        vAlpBocStl.setMerFee(merFee.toString());
        vAlpBocStl.setSettleAmt(settleAmt.toString());
        vAlpBocStl.setServiceAmt(serviceAmt.toString());
        vAlpBocStl.setOrderSumAmt(orderSumAmt.toString());
        vAlpBocStl.setNetAmount(netAmount.toString());
        vAlpBocStl.setMerServiceAmt(merServiceAmt.toString());
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        model.addAttribute("vAlpBocStl", vAlpBocStl);
        return "/ssp_pages/VAlpBocStl/list";
    }


    /**
     * 下载对账汇总报表
     *
     * @param query 查询条件
     * @throws IOException            下载时的IO异常
     * @throws InvalidFormatException 创建表格异常
     */
    @RequestMapping
    public ResponseEntity<byte[]> downloadErrorTranLsReport(VAlpBocStlQuery query) throws IOException, InvalidFormatException, ParseException {
        String orgId = getCurUser().getUserExt().getOrgId();
        Org org = orgManager.getById(orgId);
        if ("2".equals(org.getOrgLev().toString())) {
            query.setOrgId(orgId);
        }
        List<VAlpBocStl> vAlpBocStls = vAlpBocStlManager.findAll(query);
        List<VAlpBocStlD> vAlpBocStlDs = new ArrayList<>();

        for (VAlpBocStl vAlpBocStl : vAlpBocStls) {
            VAlpBocStlD vAlpBocStlD = new VAlpBocStlD();
            vAlpBocStlD.setBusinessBase(vAlpBocStl.getBusinessBase());
            vAlpBocStlD.setMerchantId(vAlpBocStl.getMerchantId());
            vAlpBocStlD.setMerchantCname(vAlpBocStl.getMerchantCname());
            vAlpBocStlD.setMerFee(Double.parseDouble(vAlpBocStl.getMerFee()));
            vAlpBocStlD.setNetAmount(Double.parseDouble(vAlpBocStl.getNetAmount()));
            vAlpBocStlD.setOrderSumAmt(Double.parseDouble(vAlpBocStl.getOrderSumAmt()));
            vAlpBocStlD.setServiceAmt(Double.parseDouble(vAlpBocStl.getServiceAmt()));
            vAlpBocStlD.setMerServiceAmt(Double.parseDouble(vAlpBocStl.getMerServiceAmt()));
            vAlpBocStlD.setSettleAmt(Double.parseDouble(vAlpBocStl.getSettleAmt()));
            vAlpBocStlD.setTranDate(vAlpBocStl.getTranDate());
            vAlpBocStlD.setName(vAlpBocStl.getName());
            vAlpBocStlDs.add(vAlpBocStlD);
        }
        List<Map<String, String>> page = new ArrayList<>();
        for (VAlpBocStlD vAlpBocStlD1 : vAlpBocStlDs) {
            vAlpBocStlD1.setBusinessBase(vAlpBocStlD1.getBusinessBase().equals("000000000000002")?"支付宝业务":"微信业务");
            page.add(BeanUtils.beanToMap(vAlpBocStlD1));
        }
        StringUtils date = new StringUtils();
        String reportName = "对账汇总报表_" + date.getStringToDate() + "_" + getCurUser().getLoginName();
        String[] reportLine = {"businessBase","merchantId", "merchantCname", "orderSumAmt", "serviceAmt", "netAmount", "merFee","merServiceAmt" ,"settleAmt", "tranDate", "name"};
        return createExcel(reportName, reportLine, ReportHeader.vAlpBocStlHeader, page);

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
