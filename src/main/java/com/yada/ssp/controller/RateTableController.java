/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.controller;

import com.yada.security.model.Org;
import com.yada.security.service.OrgManager;
import com.yada.ssp.model.BusinessBase;
import com.yada.ssp.model.FeeTable;
import com.yada.ssp.model.RateTable;
import com.yada.ssp.query.RateTableQuery;
import com.yada.ssp.service.BusinessBaseManager;
import com.yada.ssp.service.FeeTableManager;
import com.yada.ssp.service.RateTableManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Controller
public class RateTableController {
    @Autowired
    private RateTableManager rateTableManager;
    @Autowired
    private BusinessBaseManager businessBaseManager;
    @Autowired
    private FeeTableManager feeTableManager;
    @Autowired
    private OrgManager orgManager;
    /**
     * 执行搜索
     */
    @RequestMapping
    public String list(Model model, @ModelAttribute("query") RateTableQuery query) {
        List<RateTable>  rateList=rateTableManager.getRateList();
        //Page page = rateTableManager.getRateList;
        model.addAttribute("rateList", rateList);
        return "/ssp_pages/RateTable/list";
    }

    /**
     * 查看对象
     */
    @RequestMapping
    public String show(Model model, @RequestParam("id") String rateId) {

        RateTable rateTable = rateTableManager.getById(rateId);
        model.addAttribute("model", rateTable);
        return "/ssp_pages/RateTable/show";
    }

    /**
     * 进入新增页面
     */
    @RequestMapping
    public String create(Model model) {
        List<BusinessBase> BusinessList = businessBaseManager.getbusinessList();
        List<FeeTable> feeList = feeTableManager.getfeeList();
        List<Org> lowerOrgs =  orgManager.findLowerPrvcOrg();
        for (FeeTable feeTable : feeList) {
            Double fee = Double.parseDouble(feeTable.getFee());
            BigDecimal a = new BigDecimal(100);
            BigDecimal b = new BigDecimal(Double.toString(fee));
            Double fee1 = a.multiply(b).doubleValue();
            feeTable.setFee(fee1.toString() + "%");
        }
        model.addAttribute("lowerOrgs", lowerOrgs);
        model.addAttribute("feeList", feeList);
        model.addAttribute("BusinessList", BusinessList);
        return "/ssp_pages/RateTable/create";
    }

    /**
     * 保存新增对象
     */
    @RequestMapping
    public String save(@ModelAttribute("model") RateTable rateTable,String orgId,String businessId) {
        rateTable.setRateId(orgId);
        rateTable.setBusinessId(businessId);
        rateTableManager.insert(rateTable);
        return "redirect:list.do";
    }

    /**
     * 进入更新页面
     */
    @RequestMapping
    public String edit(Model model, @RequestParam("rateId") String rateId) {
        List<BusinessBase> BusinessList = businessBaseManager.getbusinessList();
        List<FeeTable> feeList = feeTableManager.getfeeList();
        List<Org> lowerOrgs =  orgManager.findLowerPrvcOrg();
        for (FeeTable feeTable : feeList) {
            Double fee = Double.parseDouble(feeTable.getFee());
            BigDecimal a = new BigDecimal(100);
            BigDecimal b = new BigDecimal(Double.toString(fee));
            Double fee1 = a.multiply(b).doubleValue();
            feeTable.setFee(fee1.toString() + "%");
        }
        model.addAttribute("lowerOrgs", lowerOrgs);
        model.addAttribute("feeList", feeList);
        model.addAttribute("BusinessList", BusinessList);
        model.addAttribute("model", rateTableManager.getById(rateId));
        return "/ssp_pages/RateTable/edit";
    }

    /**
     * 保存更新对象
     */
    @RequestMapping
    public String update(@ModelAttribute("model") RateTable rateTable) {
        rateTableManager.update(rateTable);
        return "redirect:list.do";
    }

    /**
     * 删除对象
     */
    @RequestMapping
    public String delete(Model model, @RequestParam("id") String id) {
        rateTableManager.delete(id);
        return "redirect:list.do";
    }

}
