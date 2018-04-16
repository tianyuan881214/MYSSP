package com.yada.ssp.query;

import java.io.Serializable;

import com.yada.security.base.BaseQuery;

public class MerchantBusinessQuery extends BaseQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5141298124066760982L;
	public String paymerchantBases;
	public String businessBase;
	public String feeTable;
	public String getPaymerchantBases() {
		return paymerchantBases;
	}
	public void setPaymerchantBases(String paymerchantBases) {
		this.paymerchantBases = paymerchantBases;
	}
	public String getBusinessBase() {
		return businessBase;
	}
	public void setBusinessBase(String businessBase) {
		this.businessBase = businessBase;
	}
	public String getFeeTable() {
		return feeTable;
	}
	public void setFeeTable(String feeTable) {
		this.feeTable = feeTable;
	}
	
}
