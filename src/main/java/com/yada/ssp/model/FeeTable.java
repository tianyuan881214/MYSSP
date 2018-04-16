package com.yada.ssp.model;

import java.io.Serializable;
import java.util.List;

public class FeeTable implements Serializable {

	private static final long serialVersionUID = -3098394328729995462L;

	public static final String TABLE_ALIAS = "扣率管理";

	public static final String FEE_ID = "扣率Id";
	public static final String FEE = "扣率";
	public static final String FEE_SM = "扣率说明";

	private String feeId;
	private String fee;
	private String feeSm;

	private List<MerchantBusiness> merchantBusinesses;

	public List<MerchantBusiness> getMerchantBusinesses() {
		return merchantBusinesses;
	}

	public void setMerchantBusinesses(List<MerchantBusiness> merchantBusinesses) {
		this.merchantBusinesses = merchantBusinesses;
	}

	public String getFeeSm() {
		return feeSm;
	}
	public void setFeeSm(String feeSm) {
		this.feeSm = feeSm;
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
	@Override
	public String toString() {
		return "FeeTable [feeId=" + feeId + ", fee=" + fee + ", feeSm=" + feeSm
				+ "]";
	}
	
	

}
