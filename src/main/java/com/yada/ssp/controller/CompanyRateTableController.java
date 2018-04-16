/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.ssp.model.CompanyRateTable;
import com.yada.ssp.query.CompanyRateTableQuery;
import com.yada.ssp.service.CompanyRateTableManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Controller
public class CompanyRateTableController {
    @Autowired
    private CompanyRateTableManager companyRateTableManager;

    /**
     * 执行搜索
     */
    @RequestMapping
    public String list(Model model, @ModelAttribute("query") CompanyRateTableQuery query) {
       // List<RateTable>  rateList=rateTableManager.getRateList();
        Page page= companyRateTableManager.queryPage(query);
        model.addAttribute("page", page);
        return "/ssp_pages/CompanyRateTable/list";
    }

    /**
     * 查看对象
     */
    @RequestMapping
    public String show(Model model, @RequestParam("companyId") String companyId) {
        CompanyRateTable companyRateTable = companyRateTableManager.getById(companyId);
        model.addAttribute("model", companyRateTable);
        return "/ssp_pages/CompanyRateTable/show";
    }

    /**
     * 进入新增页面
     */
    @RequestMapping
    public String create(Model model) {

        return "/ssp_pages/CompanyRateTable/create";
    }

    /**
     * 保存新增对象
     */
    @RequestMapping
    public String save(@ModelAttribute("model") CompanyRateTable companyRateTable) {
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("MMddHHmmss");
        String companyId=format.format(date);
        companyRateTable.setCompanyId(companyId);
        companyRateTableManager.insert(companyRateTable);
        return "redirect:list.do";
    }

    /**
     * 进入更新页面
     */
    @RequestMapping
    public String edit(Model model, @RequestParam("companyId") String companyId) {
        CompanyRateTable companyRateTable=  companyRateTableManager.getById(companyId);
        model.addAttribute("model", companyRateTable);
        return "/ssp_pages/CompanyRateTable/edit";
    }

    /**
     * 保存更新对象
     */
    @RequestMapping
    public String update(@ModelAttribute("model") CompanyRateTable companyRateTable) {
        companyRateTableManager.update(companyRateTable);
        return "redirect:list.do";
    }

    /**
     * 删除对象
     */
    @RequestMapping
    public String delete(Model model, @RequestParam("companyId") String companyId) {
        companyRateTableManager.delete(companyId);
        return "redirect:list.do";
    }

}
