package com.yada.ssp.query;


import com.yada.security.base.BaseQuery;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class MerchantBaseQuery extends BaseQuery implements Serializable {
    
	private static final long serialVersionUID = 938110438937565137L;
	private String isfh;
	/** merchantId */
	private String merchantId;
	/** mcc */
	private String mcc;
	/** merchantCname */
	private String merchantCname;
	/** merchantEname */
	private String merchantEname;
	/** abbrCname */
	private String abbrCname;
	/** abbrEname */
	private String abbrEname;
	/** addressChn */
	private String addressChn;
	/** addressEng */
	private String addressEng;
	/** cityCname */
	private String cityCname;
	/** cityEname */
	private String cityEname;
	/** telephone */
	private String telephone;
	/** postCode */
	private String postCode;
	/** fax */
	private String fax;
	/** manager */
	private String manager;
	/** settleMerchId */
	private String settleMerchId;
	/** signBankId */
	private String signBankId;
	/** signHostId */
	private String signHostId;
	/** zbank */
	private String zbank;
	/** ccyType */
	private String ccyType;
	/** lockMode */
	private String lockMode;
	/** signDate */
	private String signDate;
	/** merchantStat */
	private String merchantStat;
	/** settleMode */
	private String settleMode;
	/** updateOper */
	private String updateOper;
	/** updateDate */
	private String updateDate;
	/** updateTime */
	private String updateTime;

	private  String sendStatus;
	private  String scanType;

	private String accountType;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getScanType() {
		return scanType;
	}

	public void setScanType(String scanType) {
		this.scanType = scanType;
	}

	public String getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}
	/**
	 * 机构和上级机构的查询条件
	 */
	private String orgId;
	private String pOrgId;

	private String tranDateTimeBegin;

	private String tranDateTimeEnd;

	private String accountNo;

	private String  categoryId;
	private String belongOrgId;
	private String state;

	public String getBelongOrgId() {
		return belongOrgId;
	}

	public void setBelongOrgId(String belongOrgId) {
		this.belongOrgId = belongOrgId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIsfh() {
		return isfh;
	}

	public void setIsfh(String isfh) {
		this.isfh = isfh;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo.trim();
	}

	public String getTranDateTimeBegin() {
		return tranDateTimeBegin;
	}

	public void setTranDateTimeBegin(String tranDateTimeBegin) {
		this.tranDateTimeBegin = tranDateTimeBegin;
	}

	public String getTranDateTimeEnd() {
		return tranDateTimeEnd;
	}

	public void setTranDateTimeEnd(String tranDateTimeEnd) {
		this.tranDateTimeEnd = tranDateTimeEnd;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getpOrgId() {
		return pOrgId;
	}

	public void setpOrgId(String pOrgId) {
		this.pOrgId = pOrgId;
	}

	public String getMerchantId() {
		return this.merchantId;
	}
	
	public void setMerchantId(String value) {
		this.merchantId = value;
	}
	
	public String getMcc() {
		return this.mcc;
	}
	
	public void setMcc(String value) {
		this.mcc = value;
	}
	
	public String getMerchantCname() {
		return this.merchantCname;
	}
	
	public void setMerchantCname(String value) {
		this.merchantCname = value;
	}
	
	public String getMerchantEname() {
		return this.merchantEname;
	}
	
	public void setMerchantEname(String value) {
		this.merchantEname = value;
	}
	
	public String getAbbrCname() {
		return this.abbrCname;
	}
	
	public void setAbbrCname(String value) {
		this.abbrCname = value;
	}
	
	public String getAbbrEname() {
		return this.abbrEname;
	}
	
	public void setAbbrEname(String value) {
		this.abbrEname = value;
	}
	
	public String getAddressChn() {
		return this.addressChn;
	}
	
	public void setAddressChn(String value) {
		this.addressChn = value;
	}
	
	public String getAddressEng() {
		return this.addressEng;
	}
	
	public void setAddressEng(String value) {
		this.addressEng = value;
	}
	
	public String getCityCname() {
		return this.cityCname;
	}
	
	public void setCityCname(String value) {
		this.cityCname = value;
	}
	
	public String getCityEname() {
		return this.cityEname;
	}
	
	public void setCityEname(String value) {
		this.cityEname = value;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	public void setTelephone(String value) {
		this.telephone = value;
	}
	
	public String getPostCode() {
		return this.postCode;
	}
	
	public void setPostCode(String value) {
		this.postCode = value;
	}
	
	public String getFax() {
		return this.fax;
	}
	
	public void setFax(String value) {
		this.fax = value;
	}
	
	public String getManager() {
		return this.manager;
	}
	
	public void setManager(String value) {
		this.manager = value;
	}
	
	public String getSettleMerchId() {
		return this.settleMerchId;
	}
	
	public void setSettleMerchId(String value) {
		this.settleMerchId = value;
	}
	
	public String getSignBankId() {
		return this.signBankId;
	}
	
	public void setSignBankId(String value) {
		this.signBankId = value;
	}
	
	public String getSignHostId() {
		return this.signHostId;
	}
	
	public void setSignHostId(String value) {
		this.signHostId = value;
	}
	
	public String getZbank() {
		return this.zbank;
	}
	
	public void setZbank(String value) {
		this.zbank = value;
	}
	
	public String getCcyType() {
		return this.ccyType;
	}
	
	public void setCcyType(String value) {
		this.ccyType = value;
	}
	
	public String getLockMode() {
		return this.lockMode;
	}
	
	public void setLockMode(String value) {
		this.lockMode = value;
	}
	
	public String getSignDate() {
		return this.signDate;
	}
	
	public void setSignDate(String value) {
		this.signDate = value;
	}
	
	public String getMerchantStat() {
		return this.merchantStat;
	}
	
	public void setMerchantStat(String value) {
		this.merchantStat = value;
	}
	
	public String getSettleMode() {
		return this.settleMode;
	}
	
	public void setSettleMode(String value) {
		this.settleMode = value;
	}
	
	public String getUpdateOper() {
		return this.updateOper;
	}
	
	public void setUpdateOper(String value) {
		this.updateOper = value;
	}
	
	public String getUpdateDate() {
		return this.updateDate;
	}
	
	public void setUpdateDate(String value) {
		this.updateDate = value;
	}
	
	public String getUpdateTime() {
		return this.updateTime;
	}
	
	public void setUpdateTime(String value) {
		this.updateTime = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

