package com.yada.ssp.model;

import java.io.Serializable;

public class RateTable implements Serializable {

	private static final long serialVersionUID = -3098394328729995462L;

	public static final String TABLE_ALIAS = "费率管理";
	public static final String RATE_ID = "机构名称";
	public static final String RATE = "费率(银联,微信,支付宝)";
	public static final String RATE_DESCRIPTION = "费率说明";
	public static final String BUSINESS_ID = "缴费渠道";
	public static final String FEE_ID = "扣率ID";
	public static final String ACCOUNT_NO = "收款帐号";

    private  String rateId;
	private  String rate;
	private  String rateDescription;
	private  String businessId;
	private  String feeId;
	private  String accountNo;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getFeeId() {
		return feeId;
	}

	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getRateId() {
		return rateId;
	}

	public void setRateId(String rateId) {
		this.rateId = rateId;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getRateDescription() {
		return rateDescription;
	}

	public void setRateDescription(String rateDescription) {
		this.rateDescription = rateDescription;
	}

	private  String orgId;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
}
