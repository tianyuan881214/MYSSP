/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.security.model.Org;
import com.yada.security.service.OrgManager;
import com.yada.ssp.model.OrgRateTable;
import com.yada.ssp.query.OrgRateTableQuery;
import com.yada.ssp.service.FeeTableManager;
import com.yada.ssp.service.OrgRateTableManager;
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
public class OrgRateTableController  extends BaseController {
    @Autowired
    private OrgRateTableManager orgRateTableManager;
    @Autowired
    private OrgManager orgManager;
    @Autowired
    private FeeTableManager feeTableManager;

    /**
     * 执行搜索
     */
    @RequestMapping
    public String list(Model model, @ModelAttribute("query") OrgRateTableQuery query) {
      //  String orgId = getCurUser().getUserExt().getOrgId();
        Page page = orgRateTableManager.queryPage(query);
        List<OrgRateTable> orgRateTable = page.getResult();
        List<Org> BelongcOrg = orgManager.findBelongcOrg();

     //   List<Org> lowerOrgs =  orgManager.findLowerPrvcOrg();
        //query.setOrgId(orgId);
        for (OrgRateTable orgRate : orgRateTable) {
            Double AlipayRate = Double.parseDouble(orgRate.getAlipayRate());
            BigDecimal b = new BigDecimal(Double.toString(AlipayRate));
            BigDecimal a = new BigDecimal(100);
            Double AlipayRate1 = a.multiply(b).doubleValue();
            orgRate.setAlipayRate(AlipayRate1.toString() + "%");

            Double WechatRate = Double.parseDouble(orgRate.getWechatRate());
            BigDecimal b1 = new BigDecimal(Double.toString(WechatRate));
            BigDecimal a1 = new BigDecimal(100);
            Double WechatRate1 = a1.multiply(b1).doubleValue();
            orgRate.setWechatRate(WechatRate1.toString() + "%");

            Double UnionRate = Double.parseDouble(orgRate.getUnionRate());
            BigDecimal b2 = new BigDecimal(Double.toString(UnionRate));
            BigDecimal a2 = new BigDecimal(100);
            Double UnionRate1 = a2.multiply(b2).doubleValue();
            orgRate.setUnionRate(UnionRate1.toString() + "%");
        }
        model.addAttribute("page", page);
        model.addAttribute("orgs", BelongcOrg);
        return "/ssp_pages/OrgRateTable/list";
    }
    /**
     * 查看对象
     */
    @RequestMapping
    public String show(Model model, @RequestParam("orgId") String orgId) {
        OrgRateTable orgRateTable = orgRateTableManager.getById(orgId);
        model.addAttribute("orgRateTable", orgRateTable);
        return "/ssp_pages/OrgRateTable/show";
    }

    /**
     * 进入新增页面
     */
    @RequestMapping
    public String create(Model model) {

       // List<Org> lowerOrgs =  orgManager.findLowerPrvcOrg();
        List<Org> BelongcOrg = orgManager.findBelongcOrg();

        model.addAttribute("lowerOrgs", BelongcOrg);
        return "/ssp_pages/OrgRateTable/create";
    }

    /**
     * 保存新增对象
     */
    @RequestMapping
    public String save(@ModelAttribute("model") OrgRateTable orgRateTable) {
        orgRateTableManager.insert(orgRateTable);
        return "redirect:list.do";
    }

    /**
     * 进入更新页面
     */
    @RequestMapping
    public String edit(Model model, @RequestParam("orgId") String orgId) {
        List<Org> lowerOrgs =  orgManager.findLowerPrvcOrg();
        OrgRateTable orgRateTable =orgRateTableManager.getById(orgId);
       Double alipayRate= Double.parseDouble(orgRateTable.getAlipayRate());
       /* BigDecimal b = new BigDecimal(Double.toString(alipayRate));
        BigDecimal a = new BigDecimal(100);
        Double alipayRate1 = a.multiply(b).doubleValue();*/
        orgRateTable.setAlipayRate(alipayRate.toString());

       Double wechatRate= Double.parseDouble(orgRateTable.getWechatRate());
         /* BigDecimal b1 = new BigDecimal(Double.toString(wechatRate));
        BigDecimal a1 = new BigDecimal(100);
        Double wechatRate1 = a1.multiply(b1).doubleValue();*/
        orgRateTable.setWechatRate(wechatRate.toString());

        Double unionRate= Double.parseDouble(orgRateTable.getUnionRate());
      /*   BigDecimal b2 = new BigDecimal(Double.toString(unionRate));
        BigDecimal a2 = new BigDecimal(100);
        Double unionRate1 = a2.multiply(b2).doubleValue();*/
        orgRateTable.setUnionRate(unionRate.toString());

        model.addAttribute("lowerOrgs", lowerOrgs);
        model.addAttribute("model",orgRateTable);
        return "/ssp_pages/OrgRateTable/edit";
    }

    /**
     * 保存更新对象
     */
    @RequestMapping
    public String update(@ModelAttribute("model") OrgRateTable orgRateTable) {
        orgRateTableManager.update(orgRateTable);
        return "redirect:list.do";
    }

    /**
     * 删除对象
     */
    @RequestMapping
    public String delete(Model model, @RequestParam("orgId") String orgId) {
        orgRateTableManager.delete(orgId);
        return "redirect:list.do";
    }

}
