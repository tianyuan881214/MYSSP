package com.yada.ssp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.yada.mybatis.paging.Page;

import java.util.*;

import com.yada.ssp.dao.*;
import com.yada.ssp.model.*;
import com.yada.ssp.query.*;
import com.yada.ssp.service.*;

/**
 * @author  sg
 * @version 1.0
 * @since 1.0
 */


@Controller
public class GdRcfLsController {

	@Autowired
	private GdRcfLsManager gdRcfLsManager;

	@RequestMapping
	public String list(Model model,@ModelAttribute("query") GdRcfLsQuery query) {
		Page page = gdRcfLsManager.queryPage(query);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		return "/ssp_pages/GdRcfLs/list";
	}
	
	@RequestMapping
	public String insert() {
		return "/ssp_pages/GdRcfLs/create";
	}
	
	@RequestMapping
	public String save(@ModelAttribute("model") GdRcfLs gdRcfLs) {
		gdRcfLsManager.insert(gdRcfLs);
		return "redirect:list.do";
	}

	@RequestMapping
	public String edit(Model model, @RequestParam("id") String id) {
		model.addAttribute("model", gdRcfLsManager.getById(id));
		return "/ssp_pages/GdRcfLs/edit";
	}
	
	@RequestMapping
	public String update(@ModelAttribute("model") GdRcfLs gdRcfLs) {
		gdRcfLsManager.update(gdRcfLs);
		return "redirect:list.do";
	}

	
	@RequestMapping
	public String show(Model model, @RequestParam("id") String id) {
		model.addAttribute("model", gdRcfLsManager.getById(id));
		return "/ssp_pages/GdRcfLs/show";
	}
	
}
