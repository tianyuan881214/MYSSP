/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.yada.ssp.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;

import com.yada.ssp.dao.*;
import com.yada.ssp.model.*;
import com.yada.ssp.query.*;
import com.yada.ssp.service.*;

/**
 * @author  sg
 * @version 1.0
 * @since 1.0
 */


public class GdCardPhoneBind {
	
	//alias
	public static final String TABLE_ALIAS = "用户绑定";
	public static final String ALIAS_SMART_CARD = "园区卡";
	public static final String ALIAS_BANK_CARD = "银行卡";
	public static final String ALIAS_PHONE_NO = "手机号码";
	public static final String ALIAS_PHONE_CODE = "验证码";
	public static final String ALIAS_USER_NAME = "客户姓名";
	public static final String ALIAS_VALIDATE_FLAG = "验证状态";
	public static final String ALIAS_STATU_FLAG = "有效状态";
	public static final String ALIAS_SIGN_DATE = "签约日期";
	public static final String ALIAS_SIGN_TIME = "签约时间";
	
	//date formats
	
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

	public GdCardPhoneBind(){
	}


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
		return new ToStringBuilder(this)
			.append("SmartCard",getSmartCard())
			.append("BankCard",getBankCard())
			.append("PhoneNo",getPhoneNo())
			.append("PhoneCode",getPhoneCode())
			.append("UserName",getUserName())
			.append("ValidateFlag",getValidateFlag())
			.append("StatuFlag",getStatuFlag())
			.append("SignDate",getSignDate())
			.append("SignTime",getSignTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSmartCard())
			.append(getBankCard())
			.append(getPhoneNo())
			.append(getPhoneCode())
			.append(getUserName())
			.append(getValidateFlag())
			.append(getStatuFlag())
			.append(getSignDate())
			.append(getSignTime())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof GdCardPhoneBind == false) return false;
		if(this == obj) return true;
		GdCardPhoneBind other = (GdCardPhoneBind)obj;
		return new EqualsBuilder()
			.append(getSmartCard(),other.getSmartCard())
			.append(getBankCard(),other.getBankCard())
			.append(getPhoneNo(),other.getPhoneNo())
			.append(getPhoneCode(),other.getPhoneCode())
			.append(getUserName(),other.getUserName())
			.append(getValidateFlag(),other.getValidateFlag())
			.append(getStatuFlag(),other.getStatuFlag())
			.append(getSignDate(),other.getSignDate())
			.append(getSignTime(),other.getSignTime())
			.isEquals();
	}
	
	/**
	 * @Description:文件稽核日志信息
	 * @return String,name=value
	 * @author longwu.yan
	 */
	public String toAuditLogString() {
		return new StringBuilder()
		.append(",SMART_CARD=" + getSmartCard())
		.append(",BANK_CARD=" + getBankCard())
		.append(",PHONE_NO=" + getPhoneNo())
		.append(",PHONE_CODE=" + getPhoneCode())
		.append(",USER_NAME=" + getUserName())
		.append(",VALIDATE_FLAG=" + getValidateFlag())
		.append(",STATU_FLAG=" + getStatuFlag())
		.append(",SIGN_DATE=" + getSignDate())
		.append(",SIGN_TIME=" + getSignTime())
		.toString();
	}
}

