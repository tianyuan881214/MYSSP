package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

import java.io.Serializable;

public class CompanyRateTableQuery extends BaseQuery implements Serializable {
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
