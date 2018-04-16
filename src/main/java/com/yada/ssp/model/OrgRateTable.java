package com.yada.ssp.model;

import java.io.Serializable;

public class OrgRateTable implements Serializable {

	private static final long serialVersionUID = -3098394328729995462L;

	public static final String TABLE_ALIAS = "";
	public static final String ORG_ID = "机构";
	public static final String ALIPAY_RATE = "他行支付宝分润占比";
	public static final String WECHAT_RATE = "他行微信分润占比";
	public static final String ACCOUNT_NANME = "收款账户名称";
	public static final String UNION_RATE = "他行银联分润占比";
	public static final String ACCOUNT_NO = "收款账户";
	public static final String REMARK = "备注";

    private  String orgId;
	private  String alipayRate;
	private  String wechatRate;
	private  String unionRate;
	private  String accountNo;
	private  String accountName;
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

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
