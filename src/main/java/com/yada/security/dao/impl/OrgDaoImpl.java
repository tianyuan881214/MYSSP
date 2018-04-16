package com.yada.security.dao.impl;

import com.yada.security.base.BaseDaoImpl;
import com.yada.security.model.Org;
import com.yada.security.model.TreeObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrgDaoImpl extends BaseDaoImpl<Org, String> {
	
	/**
	 * 获取当前登录用户机构及以下机构(省级)
	 * @param
	 * @return List<Org>
	 * @author longwu.yan
	 */
	public List<Org> findLowerPrvcOrg(String orgId){
		return getSqlSessionTemplate().selectList("Org_findLowerPrvcOrg", orgId);
	} 
	
	/**
	 * 获取商户可分配的网点机构号
	 * @param
	 * @return List<Org>
	 * @author QQ
	 */
	public List<Org> findMerBranchOrg(String merId){
		return getSqlSessionTemplate().selectList("Org_findMerBranchOrg", merId);
	}
	
	public List<Org> getNextLevOrgListByOrgId(Map<String, String> map){
		return getSqlSessionTemplate().selectList("Org_getNextLevOrgListByOrgId", map);
	}
	
	/**
	 * 根据上级机构查找直属下级所有机构,查询结果是当前登录用户机构及以下,并直接封装到TreeObject.机构树使用
	 * @author longwu.yan
	 * @param
	 * @return List<TreeObject>
	 */
	public List<TreeObject> findSubOrgsByPorgId(String pTreeId){
		return getSqlSessionTemplate().selectList("Org_findSubOrgsByPorgId", pTreeId);
	}
	
	/**
	 * 直属下级最大机构号 + 1
	 * @author longwu.yan
	 *
	 */
	public String maxSubOrgIdByPid(String orgId){
		return getSqlSessionTemplate().selectOne("Org_maxSubOrgIdByPid", orgId);
	}
	
	/**
	 * 根据机构号查询EACQ机构号
	 * TX
	 * return EacqOrgId
	 */
	public String findEacqOrgByOrgId(String orgId){
		return getSqlSessionTemplate().selectOne("Org_findEacqOrgByOrgId", orgId);
	}

	public List<Org> findZbankList(String orgId, String orgLev) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("orgId", orgId);
		map.put("orgLev", orgLev);
		return getSqlSessionTemplate().selectList("Org_findZbankList", map);
	}

	public List<Org> findByPOrgId(String orgId){
		return getSqlSessionTemplate().selectList("Org_findByPOrgId",orgId);
	}

	public List<Org> findByLikeOrgName(String orgName){
		return getSqlSessionTemplate().selectList("Org_findByLikeOrgName",orgName);
	}

	public List<Org> findBelongcOrg(){
		return getSqlSessionTemplate().selectList("Org_findBelongcOrg");
	}
}
