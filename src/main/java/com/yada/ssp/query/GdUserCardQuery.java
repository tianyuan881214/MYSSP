/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.yada.ssp.query;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.yada.security.base.BaseQuery;

public class GdUserCardQuery extends BaseQuery {
	
	//columns START
	private java.lang.String cardNo;
	private java.lang.String phoneNo;
	private java.lang.String userName;
	//columns END
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
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
	
	
}

