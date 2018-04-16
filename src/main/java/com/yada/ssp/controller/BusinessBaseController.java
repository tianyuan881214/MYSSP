/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.yada.common.dict.util.DictUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yada.mybatis.paging.Page;
import com.yada.ssp.model.BusinessBase;
import com.yada.ssp.query.BusinessBaseQuery;
import com.yada.ssp.service.BusinessBaseManager;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Controller
public class BusinessBaseController {
    @Autowired
    private BusinessBaseManager businessBaseManager;

    /**
     * 执行搜索
     */
    @RequestMapping
    public String list(Model model, @ModelAttribute("query") BusinessBaseQuery query) {
        Page page = businessBaseManager.queryPage(query);
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        return "/ssp_pages/BusinessBase/list";
    }

    /**
     * 查看对象
     */
    @RequestMapping
    public String show(Model model, @RequestParam("id") String id) {
        BusinessBase businessBase = businessBaseManager.getById(id);
        model.addAttribute("model", businessBase);
        return "/ssp_pages/BusinessBase/show";
    }

    /**
     * 进入新增页面
     */
    @RequestMapping
    public String create() {
        return "/ssp_pages/BusinessBase/create";
    }

    /**
     * 保存新增对象
     */
    @RequestMapping
    public String save(@ModelAttribute("model") BusinessBase businessBase) {
        String businessId = businessBaseManager.getBusinessId();
        businessBase.setBusinessId(businessId);
        businessBaseManager.insert(businessBase);
        DictUtil.remove("D_SOURCE");
        return "redirect:list.do";
    }

    /**
     * 进入更新页面
     */
    @RequestMapping
    public String edit(Model model, @RequestParam("id") String id) {

        model.addAttribute("model", businessBaseManager.getById(id));
        return "/ssp_pages/BusinessBase/edit";
    }

    /**
     * 保存更新对象
     */
    @RequestMapping
    public String update(@ModelAttribute("model") BusinessBase businessBase) {
        businessBaseManager.update(businessBase);
        DictUtil.remove("D_SOURCE");
        return "redirect:list.do";
    }


    /**
     * 删除对象
     */
    @RequestMapping
    public String delete(Model model, @RequestParam("id") String id) {
        businessBaseManager.delete(id);
        DictUtil.remove("D_SOURCE");
        return "redirect:list.do";
    }

}
