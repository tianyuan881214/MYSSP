package com.yada.ssp.query;

import java.io.Serializable;

import com.yada.security.base.BaseQuery;

public class FeeTableQuery extends BaseQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8962881457700698253L;
	private String feeId;
	private String fee;
	private String feeSm;
	
	public String getFeeSm() {
		return feeSm;
	}
	public void setFeeSm(String feeSm) {
		this.feeSm = feeSm;
	}
	@Override
	public String toString() {
		return "FeeTableQuery [feeId=" + feeId + ", fee=" + fee + ", feeSm="
				+ feeSm + "]";
	}
	public String getFeeId() {
		return feeId;
	}
	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	


}
