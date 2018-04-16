/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.yada.ssp.query;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.yada.security.base.BaseQuery;

public class GdCardPhoneBindQuery extends BaseQuery {
	
	//columns START
	private java.lang.String smartCard;
	private java.lang.String bankCard;
	private java.lang.String phoneNo;
	private java.lang.String phoneCode;
	private java.lang.String userName;
	private java.lang.String validateFlag;
	private java.lang.String statuFlag;
	private java.lang.String signDate;
	private java.lang.String signTime;
	//columns END
	public void setSmartCard(java.lang.String value) {
		this.smartCard = value;
	}
	
	public java.lang.String getSmartCard() {
		return this.smartCard;
	}
	public void setBankCard(java.lang.String value) {
		this.bankCard = value;
	}
	
	public java.lang.String getBankCard() {
		return this.bankCard;
	}
	public void setPhoneNo(java.lang.String value) {
		this.phoneNo = value;
	}
	
	public java.lang.String getPhoneNo() {
		return this.phoneNo;
	}
	public void setPhoneCode(java.lang.String value) {
		this.phoneCode = value;
	}
	
	public java.lang.String getPhoneCode() {
		return this.phoneCode;
	}
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
	
	public java.lang.String getUserName() {
		return this.userName;
	}
	public void setValidateFlag(java.lang.String value) {
		this.validateFlag = value;
	}
	
	public java.lang.String getValidateFlag() {
		return this.validateFlag;
	}
	public void setStatuFlag(java.lang.String value) {
		this.statuFlag = value;
	}
	
	public java.lang.String getStatuFlag() {
		return this.statuFlag;
	}
	public void setSignDate(java.lang.String value) {
		this.signDate = value;
	}
	
	public java.lang.String getSignDate() {
		return this.signDate;
	}
	public void setSignTime(java.lang.String value) {
		this.signTime = value;
	}
	
	public java.lang.String getSignTime() {
		return this.signTime;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
	
	
}

