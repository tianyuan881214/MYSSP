package com.yada.security.query;

import com.yada.security.base.BaseQuery;

public class UserGrpQuery extends BaseQuery {

	/**
	 * 分组ID
	 */
	private java.lang.Long userGrpId;
	/**
	 * 登录名
	 */
	private java.lang.String name;

	/**
	 * 机构
	 */
	private String orgId;
	
	/**
	 * 查询条件机构ID
	 */
	private String queryOrgId;
	
	public String getS_queryOrgId() {
		return queryOrgId;
	}
	public void setS_queryOrgId(String queryOrgId) {
		this.queryOrgId = queryOrgId;
	}
	public String getS_orgId() {
		return orgId;
	}
	public void setS_orgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public java.lang.Long getUserGrpId() {
		return userGrpId;
	}
	public void setUserGrpId(java.lang.Long userGrpId) {
		this.userGrpId = userGrpId;
	}
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getS_name() {
		return name;
	}
	public void setS_name(java.lang.String name) {
		this.name = name;
	}
	
}
