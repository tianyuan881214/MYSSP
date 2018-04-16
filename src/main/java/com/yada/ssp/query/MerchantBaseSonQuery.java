package com.yada.ssp.query;


import com.yada.security.base.BaseQuery;

import java.io.Serializable;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class MerchantBaseSonQuery extends BaseQuery implements Serializable {

	private static final long serialVersionUID = 938110438937565137L;
	private String sonmerchantId;
	private String sonaccountNo;
	private String sonaccountName;
	private String sonopeningBank;
	private String sonopeningBankNo;
	private String soncardholderName;
	private String soncardholderMoveIphone;
	private String soncardholderTelePhone;
	private String sonaddressChn;
	private String sonaddressEng;
	private String sonpostCode;
	private String sonfax;
	private String merGrpid;
	private String inBusiness;
	private String tranType;
	private String subMerchantId;
	public String getSonmerchantId() {
		return sonmerchantId;
	}
	public void setSonmerchantId(String sonmerchantId) {
		this.sonmerchantId = sonmerchantId.trim();
	}
	public String getSonaccountNo() {
		return sonaccountNo;
	}
	public void setSonaccountNo(String sonaccountNo) {
		this.sonaccountNo = sonaccountNo.trim();
	}
	public String getSonaccountName() {
		return sonaccountName;
	}
	public void setSonaccountName(String sonaccountName) {
		this.sonaccountName = sonaccountName.trim();
	}
	public String getSonopeningBank() {
		return sonopeningBank;
	}
	public void setSonopeningBank(String sonopeningBank) {
		this.sonopeningBank = sonopeningBank.trim();
	}
	public String getSonopeningBankNo() {
		return sonopeningBankNo;
	}
	public void setSonopeningBankNo(String sonopeningBankNo) {
		this.sonopeningBankNo = sonopeningBankNo.trim();
	}
	public String getSoncardholderName() {
		return soncardholderName;
	}
	public void setSoncardholderName(String soncardholderName) {
		this.soncardholderName = soncardholderName.trim();
	}
	public String getSoncardholderMoveIphone() {
		return soncardholderMoveIphone;
	}
	public void setSoncardholderMoveIphone(String soncardholderMoveIphone) {
		this.soncardholderMoveIphone = soncardholderMoveIphone.trim();
	}
	public String getSoncardholderTelePhone() {
		return soncardholderTelePhone;
	}
	public void setSoncardholderTelePhone(String soncardholderTelePhone) {
		this.soncardholderTelePhone = soncardholderTelePhone.trim();
	}
	public String getSonaddressChn() {
		return sonaddressChn;
	}
	public void setSonaddressChn(String sonaddressChn) {
		this.sonaddressChn = sonaddressChn.trim();
	}
	public String getSonaddressEng() {
		return sonaddressEng;
	}
	public void setSonaddressEng(String sonaddressEng) {
		this.sonaddressEng = sonaddressEng.trim();
	}
	public String getSonpostCode() {
		return sonpostCode;
	}
	public void setSonpostCode(String sonpostCode) {
		this.sonpostCode = sonpostCode.trim();
	}
	public String getSonfax() {
		return sonfax;
	}
	public void setSonfax(String sonfax) {
		this.sonfax = sonfax.trim();
	}
	public String getMerGrpid() {
		return merGrpid;
	}
	public void setMerGrpid(String merGrpid) {
		this.merGrpid = merGrpid.trim();
	}
	public String getInBusiness() {
		return inBusiness;
	}
	public void setInBusiness(String inBusiness) {
		this.inBusiness = inBusiness.trim();
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType.trim();
	}
	public String getSubMerchantId() {
		return subMerchantId;
	}
	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId.trim();
	}
	@Override
	public String toString() {
		return "MerchantBaseSon [sonmerchantId=" + sonmerchantId
				+ ", sonaccountNo=" + sonaccountNo + ", sonaccountName="
				+ sonaccountName + ", sonopeningBank=" + sonopeningBank
				+ ", sonopeningBankNo=" + sonopeningBankNo
				+ ", soncardholderName=" + soncardholderName
				+ ", soncardholderMoveIphone=" + soncardholderMoveIphone
				+ ", soncardholderTelePhone=" + soncardholderTelePhone
				+ ", sonaddressChn=" + sonaddressChn + ", sonaddressEng="
				+ sonaddressEng + ", sonpostCode=" + sonpostCode + ", sonfax="
				+ sonfax + ", merGrpid=" + merGrpid + ", inBusiness="
				+ inBusiness + ", tranType=" + tranType + ", subMerchantId="
				+ subMerchantId + "]";
	}


}

