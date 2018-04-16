package com.yada.ssp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yada.mybatis.paging.Page;
import com.yada.ssp.model.GdCardPhoneBind;
import com.yada.ssp.query.GdCardPhoneBindQuery;
import com.yada.ssp.service.GdCardPhoneBindManager;

/**
 * @author  sg
 * @version 1.0
 * @since 1.0
 */


@Controller
public class GdCardPhoneBindController {

	@Autowired
	private GdCardPhoneBindManager gdCardPhoneBindManager;

	@RequestMapping
	public String list(Model model,@ModelAttribute("query") GdCardPhoneBindQuery query) {
		Page page = gdCardPhoneBindManager.queryPage(query);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		return "/ssp_pages/GdCardPhoneBind/list";
	}
	
	@RequestMapping
	public String insert() {
		return "/ssp_pages/GdCardPhoneBind/create";
	}
	
	@RequestMapping
	public String save(@ModelAttribute("model") GdCardPhoneBind gdCardPhoneBind) {
		gdCardPhoneBindManager.insert(gdCardPhoneBind);
		return "redirect:list.do";
	}

	@RequestMapping
	public String edit(Model model, @RequestParam("id") String id) {
		model.addAttribute("model", gdCardPhoneBindManager.getById(id));
		return "/ssp_pages/GdCardPhoneBind/edit";
	}
	
	@RequestMapping
	public String update(@ModelAttribute("model") GdCardPhoneBind gdCardPhoneBind) {
		gdCardPhoneBindManager.update(gdCardPhoneBind);
		return "redirect:list.do";
	}

	
	@RequestMapping
	public String show(Model model, @RequestParam("id") String id) {
		model.addAttribute("model", gdCardPhoneBindManager.getById(id));
		return "/ssp_pages/GdCardPhoneBind/show";
	}
	
}
