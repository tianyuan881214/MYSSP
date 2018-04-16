package com.yada.ssp.model;

import java.io.Serializable;

public class CompanyRateTable implements Serializable {

	private static final long serialVersionUID = -3098394328729995462L;

	public static final String TABLE_ALIAS = "系统参数维护";
	public static final String COMPANY_ID = "Key";
	public static final String RATE = "value";
	public static final String COMPANY_DESCRIPTION = "说明";


	private  String companyId;
	private  String rate;
	private  String companyDescription;


	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

}
