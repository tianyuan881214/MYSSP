/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.security.service.OrgManager;
import com.yada.ssp.model.*;
import com.yada.ssp.query.MerchantBaseFhQuery;
import com.yada.ssp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;


/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Controller
public class MerchantBaseFhController extends BaseController {

    @Autowired
    private MerchantBaseFhManager merchantBaseFhManager;
    @Autowired
    private BusinessBaseManager businessBaseManager;
    @Autowired
    private FeeTableManager feeTableManager;
    @Autowired
    private MerchantBusinessManager merchantBusinessManager;
    @Autowired
    private MerchantBaseSonManager merchantBaseSonManager;
    @Autowired
    private EnterAiliMerchantManager enterAiliMerchantManager;
    @Autowired
    private OrgManager orgManager;
    @Autowired
    private WebchantMerchantBaseManager webchantMerchantBaseManager;
    @Autowired
    private MerchantGrpLsManager merchantGrpLsManager;



    @RequestMapping
    public String listByFh(Model model, @ModelAttribute("query") MerchantBaseFhQuery query) {
        Page page =merchantBaseFhManager.queryPage(query);
        List<MerchantBaseFh>  merchantBaseList  =page.getResult();
        for (MerchantBaseFh merchantBaseFh : merchantBaseList) {
            for (MerchantBusiness merchantBusiness : merchantBaseFh.getMerchantBusinesses()) {
                BusinessBase businessBase = businessBaseManager.getById(merchantBusiness.getBusinessBase());
                FeeTable feeTable = feeTableManager.getById(merchantBusiness.getFeeTable());
                merchantBusiness.setBusinessBases(businessBase);
                Double fee = Double.parseDouble(feeTable.getFee());
                BigDecimal a = new BigDecimal(100);
                BigDecimal b = new BigDecimal(Double.toString(fee));
                Double fee1 = a.multiply(b).doubleValue();
                feeTable.setFee(fee1.toString() + "%");
                merchantBusiness.setFeeTables(feeTable);
            }
        }

        model.addAttribute("merchantBaseList", merchantBaseList);
        model.addAttribute("query", query);
        model.addAttribute("page", page);
        return "/ssp_pages/MerchantBaseFh/list";
    }

    @RequestMapping
    public String showByFh(Model model, @RequestParam("id") String id, HttpServletRequest request) {
        List<MerchantBaseSon> lists = merchantBaseSonManager.getmerbusinessList(id);
        MerchantBaseSon merchantson = merchantBaseSonManager.getById(id);
        MerchantBaseFh merchantFh = merchantBaseFhManager.getById(id);
        MerchantGrpLs merchantGrp = merchantGrpLsManager.getById(id);
        /*String str = merchant.getBitFlag();
        this.Str_out(str, request);
		*/
        List<MerchantBusiness> merchantBusinesses = merchantBusinessManager.findByMerchantId(id);
        for (MerchantBusiness merchantBusiness : merchantBusinesses) {
            BusinessBase businessBase = businessBaseManager.getById(merchantBusiness.getBusinessBase());
            FeeTable feeTable = feeTableManager.getById(merchantBusiness.getFeeTable());
            merchantBusiness.setBusinessBases(businessBase);
            Double fee = Double.parseDouble(feeTable.getFee());
            BigDecimal b = new BigDecimal(Double.toString(fee));
            BigDecimal a = new BigDecimal(100);
            Double fee1 = a.multiply(b).doubleValue();
            feeTable.setFee(fee1.toString() + "%");
            merchantBusiness.setFeeTables(feeTable);
        }
        EnterAiliMerchant enterAiliMerchant = enterAiliMerchantManager.getById(id);
        request.getSession().setAttribute("lists", lists);
        model.addAttribute("enterAiliMerchant", enterAiliMerchant);
        model.addAttribute("FeeBusiness", merchantBusinesses);
        model.addAttribute("modelson", merchantson);
        model.addAttribute("model", merchantFh);
        model.addAttribute("merchantGrp",merchantGrp);

        return "/ssp_pages/MerchantBaseFh/show";
    }

    @RequestMapping
    public String updateReview(Model model,MerchantBaseFh merchantBaseFh,String state) {
        merchantBaseFh.setState(state);
        String merchantId= merchantBaseFh.getMerchantId();
        if ("0".equals(state)){
            merchantBaseFhManager.updates(state,merchantId);
            model.addAttribute("message","审核通过");
        }else {
            model.addAttribute("message","审核不通过");
        }
        return "/ssp_pages/MerchantBaseFh/list";

    }
}
