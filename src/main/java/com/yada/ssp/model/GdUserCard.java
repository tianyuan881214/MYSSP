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


public class GdUserCard {
	
	//alias
	public static final String TABLE_ALIAS = "用户信息";
	public static final String ALIAS_CARD_NO = "银行卡";
	public static final String ALIAS_PHONE_NO = "手机号";
	public static final String ALIAS_USER_NAME = "姓名";
	
	//date formats
	
	//columns START
	private java.lang.String cardNo;
	private java.lang.String phoneNo;
	private java.lang.String userName;
	//columns END

	public GdUserCard(){
	}


	public void setCardNo(java.lang.String value) {
		this.cardNo = value;
	}
	
	public java.lang.String getCardNo() {
		return this.cardNo;
	}
	public void setPhoneNo(java.lang.String value) {
		this.phoneNo = value;
	}
	
	public java.lang.String getPhoneNo() {
		return this.phoneNo;
	}
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
	
	public java.lang.String getUserName() {
		return this.userName;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("CardNo",getCardNo())
			.append("PhoneNo",getPhoneNo())
			.append("UserName",getUserName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCardNo())
			.append(getPhoneNo())
			.append(getUserName())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof GdUserCard == false) return false;
		if(this == obj) return true;
		GdUserCard other = (GdUserCard)obj;
		return new EqualsBuilder()
			.append(getCardNo(),other.getCardNo())
			.append(getPhoneNo(),other.getPhoneNo())
			.append(getUserName(),other.getUserName())
			.isEquals();
	}
	
	/**
	 * @Description:文件稽核日志信息
	 * @return String,name=value
	 * @author longwu.yan
	 */
	public String toAuditLogString() {
		return new StringBuilder()
		.append(",CARD_NO=" + getCardNo())
		.append(",PHONE_NO=" + getPhoneNo())
		.append(",USER_NAME=" + getUserName())
		.toString();
	}
}

