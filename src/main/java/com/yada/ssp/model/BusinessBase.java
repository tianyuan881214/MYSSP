package com.yada.ssp.model;

import java.io.Serializable;
import java.util.List;

public class BusinessBase implements Serializable {

	private static final long serialVersionUID = -8954991130172063406L;

	public static final String TABLE_ALIAS="业务管理";
	
	public static final String BUSINESS_ID = "业务ID";//	VARCHAR2(15)	N			
	public static final String BUSINESS_NAME = "业务名称";//	VARCHAR2(64)	Y	{
	public static final String BUSINESS_SM = "业务说明";//	VARCHAR2(64)	Y	{
	private String businessId;
	private String businessName;
	private String businessSm;
	public boolean checked;
	private String feeid;

	private List<MerchantBusiness> merchantBusinesses;

	public List<MerchantBusiness> getMerchantBusinesses() {
		return merchantBusinesses;
	}

	public void setMerchantBusinesses(List<MerchantBusiness> merchantBusinesses) {
		this.merchantBusinesses = merchantBusinesses;
	}

	public String getBusinessSm() {
		return businessSm;
	}
	public void setBusinessSm(String businessSm) {
		this.businessSm = businessSm;
	}
	public String getFeeid() {
		return feeid;
	}
	public void setFeeid(String feeid) {
		this.feeid = feeid;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
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
	@Override
	public String toString() {
		return "BusinessBase [businessId=" + businessId + ", businessName="
				+ businessName + ", businessSm=" + businessSm + ", checked="
				+ checked + ", feeid=" + feeid + "]";
	}
	
	
}
