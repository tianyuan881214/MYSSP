package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.security.model.Org;
import com.yada.security.service.OrgManager;
import com.yada.ssp.model.AiliCheckFile;
import com.yada.ssp.query.VAlpMersStlLsQuery;
import com.yada.ssp.reportModel.VAlpMersStlLsReportQuery;
import com.yada.ssp.service.MerchantBaseManager;
import com.yada.ssp.service.VAlpMersStlLsManager;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author xianyong
 */
@Controller
public class VAlpMersStlLsController extends BaseController {

    @Autowired
    private VAlpMersStlLsManager vAlpMersStlLsManager;
    @Autowired
    private OrgManager orgManager;
    @Autowired
    private MerchantBaseManager merchantBaseManager;

    @RequestMapping
    public String list(Model model, VAlpMersStlLsQuery query) {
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
        Page page = vAlpMersStlLsManager.queryPage(query);
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        return "/ssp_pages/VAlpMersStlLs/list";
    }


    /*@RequestMapping
    public String downloadVAlpMersStlLsReport(VAlpMersStlLsReportQuery query, HttpServletResponse response) {
        try {
            String orgId = getCurUser().getUserExt().getOrgId();
            Org org = orgManager.getById(orgId);
            List<String> merchantIds = new ArrayList<>();
            if (query.getpOrgId() != null && !"".equals(query.getpOrgId())) {
                merchantIds = merchantBaseManager.findByZbank(query.getpOrgId());
            }else if (query.getOrgId()!=null && !"".equals(query.getOrgId())){
                merchantBaseManager.
            }

            *//*List<VAlpMersStlLs> vAlpMersStlLses = ailiCheckFileManager.findAll(query);*//*
            List<List<AiliCheckFile>> exportCheckFiles = getExportCheckFileLs(ailiCheckFiles);
            response.setContentType("application/zip");
            response.setHeader("Content-Disposition", "attachment; filename=\""
                    + URLEncoder.encode("支付宝对账文件", "UTF-8") + ".zip\"");

            ServletOutputStream ouputStream = response.getOutputStream();
            ZipOutputStream zos = new ZipOutputStream(ouputStream, Charset.forName("gbk"));

            for (List<AiliCheckFile> exportFile : exportCheckFiles) {

                WritableWorkbook wwb = Workbook.createWorkbook(zos);
                zos.putNextEntry(new ZipEntry(exportFile.get(0).getMerchantId() + "-" + exportFile.get(0).getSettleDate() + ".xls"));
                WritableSheet ws = wwb.createSheet("first sheet", 0);
                int row = 0;
                ws.addCell(new Label(0, row, "商户号"));
                ws.addCell(new Label(1, row, "商户名称"));
                ws.addCell(new Label(2, row, "终端号"));
                ws.addCell(new Label(3, row, "批次号"));
                ws.addCell(new Label(4, row, "入账账号"));
                ws.addCell(new Label(5, row, "交易卡号"));
                ws.addCell(new Label(6, row, "交易日期"));
                ws.addCell(new Label(7, row, "交易时间"));
                ws.addCell(new Label(8, row, "交易金额"));
                ws.addCell(new Label(9, row, "手续费"));
                ws.addCell(new Label(10, row, "结算金额"));
                ws.addCell(new Label(11, row, "授权码"));
                ws.addCell(new Label(12, row, "交易码"));
                ws.addCell(new Label(13, row, "分期期数"));
                ws.addCell(new Label(14, row, "卡别"));
                ws.addCell(new Label(15, row, "归属机构"));
                ws.addCell(new Label(0, row, "商户号"));
                ws.addCell(new Label(1, row, "商户名称"));
                ws.addCell(new Label(2, row, "商户订单号"));
                ws.addCell(new Label(3, row, "支付宝交易号"));
                ws.addCell(new Label(4, row, "业务类型"));
                ws.addCell(new Label(5, row, "订单金额"));
                ws.addCell(new Label(6, row, "结算金额"));
                ws.addCell(new Label(7, row, "订单日期"));
                ws.addCell(new Label(8, row, "归属机构"));
                row++;
                for (AiliCheckFile result : exportFile) {
                    Label lable1 = new Label(0, row, result.getMerchantId());
                    Label lable2 = new Label(1, row, result.getStoreName());
                    Label lable3 = new Label(2, row, result.getTerminalId());
                    Label lable4 = new Label(3, row, "");
                    Label lable5 = new Label(4, row, result.getAccountNo());
                    Label lable6 = new Label(5, row, result.getTradeNo());
                    Label lable7 = new Label(6, row, result.getSettleDate() + "");
                    Label lable8 = new Label(7, row, "");
                    Label lable9 = new Label(8, row, result.getOrderAmount() + "");
                    Label lable10 = new Label(9, row, result.getServiceCharge() + "");
                    Label lable11 = new Label(10, row, result.getMerchantPaidAmount() + "");
                    Label lable12 = new Label(11, row, "");
                    Label lable13 = new Label(12, row, "ALP");
                    Label lable14 = new Label(13, row, "");
                    Label lable15 = new Label(14, row, "ALPA");
                    Label lable16 = new Label(15, row, result.getName());








                    *//*Label lable1 = new Label(0, row, result.getMerchantId());
                    Label lable2 = new Label(1, row, result.getStoreName());
                    Label lable3 = new Label(2, row, result.getOutTradeNo());
                    Label lable4 = new Label(3, row, result.getTradeNo());
                    Label lable5 = new Label(4, row, result.getTranType());
                    Label lable6 = new Label(5, row, result.getOrderAmount() + "");
                    Label lable7 = new Label(6, row, result.getMerchantPaidAmount() + "");
                    Label lable8 = new Label(7, row, result.getSettleDate());
                    Label lable9 = new Label(8, row, result.getName());*//*
                    ws.addCell(lable1);
                    ws.addCell(lable2);
                    ws.addCell(lable3);
                    ws.addCell(lable4);
                    ws.addCell(lable5);
                    ws.addCell(lable6);
                    ws.addCell(lable7);
                    ws.addCell(lable8);
                    ws.addCell(lable9);
                    ws.addCell(lable10);
                    ws.addCell(lable11);
                    ws.addCell(lable12);
                    ws.addCell(lable13);
                    ws.addCell(lable14);
                    ws.addCell(lable15);
                    row++;
                }
                wwb.write();
                wwb.close();

            }

            zos.flush();
            zos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getExportCheckFileLs(List<AiliCheckFile> ls) {
        List<List<AiliCheckFile>> exportCheckFileLs = new ArrayList();
        Map<String, List<AiliCheckFile>> map = new HashMap<String, List<AiliCheckFile>>();

        for (AiliCheckFile row : ls) {
            if (!map.containsKey(row.getStoreId() + row.getSettleDate())) {
                map.put(row.getStoreId() + row.getSettleDate(), new ArrayList<AiliCheckFile>());
            }
            map.get(row.getStoreId() + row.getSettleDate()).add(row);
        }

        for (List<AiliCheckFile> values : map.values()) {
            exportCheckFileLs.add(values);
        }
        return exportCheckFileLs;
    }*/

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
