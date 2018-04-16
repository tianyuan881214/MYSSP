/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.ssp.model.SysPara;
import com.yada.ssp.query.SysParaQuery;
import com.yada.ssp.service.SysParaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Controller
public class SysParaController {
    @Autowired
    private SysParaManager sysParaManager;
    /**
     * 执行搜索
     */
    @RequestMapping
    public String list(Model model, @ModelAttribute("query") SysParaQuery query) {
        Page page= sysParaManager.queryPage(query);
        model.addAttribute("page", page);
        return "/ssp_pages/SysPara/list";
    }


    /**
     * 进入更新页面
     */
    @RequestMapping
    public String edit(Model model, @RequestParam("paraId") String paraId) {
        SysPara sysPara= sysParaManager.getById(paraId);
        model.addAttribute("model", sysPara);
        return "/ssp_pages/SysPara/edit";
    }

    /**
     * 保存更新对象
     */
    @RequestMapping
    public String update(@ModelAttribute("model") SysPara sysPara) {
        sysParaManager.update(sysPara);
        return "redirect:list.do";
    }


}
