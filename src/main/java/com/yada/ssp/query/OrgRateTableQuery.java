package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

import java.io.Serializable;

public class OrgRateTableQuery extends BaseQuery implements Serializable {
	private  String orgId;
	private  String alipayRate;
	private  String wechatRate;
	private  String unionRate;
	private  String accountNo;
	private  String remark;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getAlipayRate() {
		return alipayRate;
	}

	public void setAlipayRate(String alipayRate) {
		this.alipayRate = alipayRate;
	}

	public String getWechatRate() {
		return wechatRate;
	}

	public void setWechatRate(String wechatRate) {
		this.wechatRate = wechatRate;
	}

	public String getUnionRate() {
		return unionRate;
	}

	public void setUnionRate(String unionRate) {
		this.unionRate = unionRate;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
