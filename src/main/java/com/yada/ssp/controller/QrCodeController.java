package com.yada.ssp.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.yada.security.base.BaseController;
import com.yada.security.model.Org;
import com.yada.security.service.OrgManager;
import com.yada.ssp.query.QrCodeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QrCodeController extends BaseController {
    @Autowired
    private OrgManager orgManager;

    @RequestMapping
    public String list(Model model, QrCodeQuery query) {
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
        model.addAttribute("query", query);
        return "/ssp_pages/QrCode/list";
    }

    @RequestMapping
    public void qrCode(Model model,HttpServletResponse res ,String merchantId) {
        System.out.println("@@@@:"+merchantId);
        try {
            OutputStream os = res.getOutputStream();
            res.reset();

            res.setHeader("Content-Disposition", "attachment; filename="+merchantId+".jpg");
            res.setContentType("application/octet-stream; charset=utf-8");
            String content = "http://www.lanxinpay.com/pay/unionWeb?merID="+merchantId+"&terminalId=88888888";

            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hints = new HashMap();
            //内容所使用编码
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix bitMatrix = multiFormatWriter.encode(
                    content, BarcodeFormat.QR_CODE, 300, 300, hints);
            MatrixToImageWriter.writeToStream(bitMatrix,"jpg",os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping
    public String placeQrOrder(HttpServletResponse resp) throws Exception {
        String content = "http://www.baidu.com";
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Map hints = new HashMap();
        //内容所使用编码
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = multiFormatWriter.encode(
                content, BarcodeFormat.QR_CODE, 100, 100, hints);
        MatrixToImageWriter.writeToStream(bitMatrix, "png", resp.getOutputStream());
        return "/ssp_pages/QrCode/list";
    }
}
