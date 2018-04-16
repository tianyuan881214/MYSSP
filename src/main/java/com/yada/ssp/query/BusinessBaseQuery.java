package com.yada.ssp.query;

import java.io.Serializable;

import com.yada.security.base.BaseQuery;

public class BusinessBaseQuery extends BaseQuery implements Serializable {

	private static final long serialVersionUID = -1395044404014037410L;
	private String businessId;
	private String businessName;
	
	
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	
}
