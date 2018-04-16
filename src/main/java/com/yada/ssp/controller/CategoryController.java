package com.yada.ssp.controller;

import com.yada.common.dict.util.DictUtil;
import com.yada.mybatis.paging.Page;
import com.yada.ssp.model.Category;
import com.yada.ssp.query.CategoryQuery;
import com.yada.ssp.service.CategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xianyong
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryManager categoryManager;

    @RequestMapping
    public String list(Model model, CategoryQuery query) {
        Page page = categoryManager.queryPage(query);
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        return "ssp_pages/Category/list";
    }

    @RequestMapping
    public String create() {
        return "ssp_pages/Category/create";
    }

    @RequestMapping
    public String save(Category category, Model model) {
        Category category1 = categoryManager.getById(category.getId());
        if (category1 != null && !"".equals(category1)) {
            model.addAttribute("message", "此类目已存在！！！");
            return "ssp_pages/Category/create";
        } else {
            categoryManager.insert(category);
            DictUtil.remove("D_CATEGORY");
            return "redirect:list.do";
        }
    }

    @RequestMapping
    public String edit(Model model, String id) {
        Category category = categoryManager.getById(id);
        model.addAttribute("model", category);
        return "ssp_pages/Category/edit";
    }

    @RequestMapping
    public String update(Category category) {
        categoryManager.update(category);
        DictUtil.remove("D_CATEGORY");
        return "redirect:list.do";
    }

    @RequestMapping
    public String delete(String id) {
        categoryManager.delete(id);
        DictUtil.remove("D_CATEGORY");
        return "redirect:list.do";
    }
}
