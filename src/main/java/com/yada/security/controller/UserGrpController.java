package com.yada.security.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yada.mybatis.paging.Page;
import com.yada.security.base.BaseController;
import com.yada.security.model.Org;
import com.yada.security.model.UserGrp;
import com.yada.security.model.UserGrpRoleIdx;
import com.yada.security.query.UserGrpQuery;
import com.yada.security.service.OrgManager;
import com.yada.security.service.RoleManager;
import com.yada.security.service.UserGrpManager;
import com.yada.security.service.UserGrpRoleIdxManager;
import com.yada.security.service.UserManager;

@Controller
public class UserGrpController extends BaseController{

	@Autowired
	private UserGrpManager userGrpManager;

	@Autowired
	private RoleManager roleManager;
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private OrgManager orgManager;

	@Autowired
	private UserGrpRoleIdxManager userGrpRoleIdxManager;

	@RequestMapping
	public String insert(Model model, @ModelAttribute("model") UserGrp userGrp) {
		
		//机构
		List<Org> lowerOrgs = orgManager.findLowerPrvcOrg();
		model.addAttribute("lowerOrgs", lowerOrgs);
		
		return "security_pages/UserGrp/create";
	}

	@RequestMapping
	public String save(UserGrp userGrp) {
		
		//保存用户分组及用户分组额外信息
		userGrpManager.saveUserGrpAndExt(userGrp);
		return "redirect:list.do";
	}

	@RequestMapping
	public String delete(String id) {
		Long userGrpId = Long.parseLong(id);
		if(userManager.getByUserGrpId(userGrpId) > 0){
			return "redirect:list.do";
		}
		userGrpManager.delete(id);
		userGrpRoleIdxManager.deleteByUserGrpId(userGrpId);
		return "redirect:list.do";
	}

	@RequestMapping
	public String edit(String id, Model model) {
		model.addAttribute("userGrp", userGrpManager.getById(id));
		return "security_pages/UserGrp/edit";
	}

	@RequestMapping
	public String update(UserGrp userGrp) {
		userGrpManager.update(userGrp);
		return "redirect:list.do";
	}

	@RequestMapping
	public String list(@ModelAttribute("query")UserGrpQuery query, Model model) {
		
		//机构
		List<Org> lowerOrgs = orgManager.findLowerPrvcOrg();
		model.addAttribute("lowerOrgs", lowerOrgs);
		
	/*	//机构过滤,本机构及以下
		if(query.getS_queryOrgId() == null || query.getS_queryOrgId().equals("")){
			String orgId = getCurUser().getUserExt().getOrgId();
			query.setOrgId(orgId);
		}*/
		
		//查询结果
		Page page = userGrpManager.queryPage(query);
		model.addAttribute("page", page);
		
		//查询条件回显
		model.addAttribute("query", query);
		
		return "security_pages/UserGrp/list";
	}

	@RequestMapping
	public String role(String id, Model model,@ModelAttribute("formBean") UserGrpRoleIdx temp) {
		Long userGrpId = Long.parseLong(id);
		UserGrp userGrp = userGrpManager.getById(id);
		String roles = "";
		for(UserGrpRoleIdx role:userGrpRoleIdxManager.selectByUserGrpId(userGrpId)){
			roles = roles+role.getRoleId()+",";
		}
		model.addAttribute("userGrp", userGrp);
		model.addAttribute("grpRoles", roles);
		model.addAttribute("roles", roleManager.findListByWhere(null));
		
		return "security_pages/UserGrp/role";
	}

	@RequestMapping
	public String grprole(String userGrpId, String[] roleId, String queryString) {
		
		//分配角色
		userGrpManager.assignRoles(userGrpId, roleId);
		
		return "redirect:list.do?" + queryString;
	}
	
	/**
	 * 用户分组名称是否重复
	 * @author longwu.yan
	 * @param name
	 */
	@RequestMapping
	public void AJAX_isUserGrpNameExist(String name, HttpServletResponse response){
		
		//验证信息
		String msg = "*";
		
		//依据名称查询.和数据库交互查询列表,需设置show=true
		UserGrpQuery query = new UserGrpQuery();
		query.setShow(true);
		query.setName(name);
		Page page = userGrpManager.queryPage(query);
		
		//查询结果
		if(page != null && page.getResult().size() > 0){
			msg = "用户分组名称已存在!";
		}
		
		//响应JSON格式数据
		try {
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().print(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
