/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.yada.ssp.query;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.yada.security.base.BaseQuery;

public class GdRcfLsQuery extends BaseQuery {
	
	//columns START
	private java.lang.String tranType;
	private java.lang.String systemCode;
	private java.lang.String fuctionCode;
	private java.lang.String traceNo;
	private java.lang.String cardNo;
	private java.lang.String smartCard;
	private java.lang.String amount;
	private java.lang.String sysDate;
	private java.lang.String sysTime;
	private java.lang.String respCode;
	private java.lang.String respMsg;
	private java.lang.String cspRespCode;
	private java.lang.String cspRespMsg;
	//columns END
	public void setTranType(java.lang.String value) {
		this.tranType = value;
	}
	
	public java.lang.String getTranType() {
		return this.tranType;
	}
	public void setSystemCode(java.lang.String value) {
		this.systemCode = value;
	}
	
	public java.lang.String getSystemCode() {
		return this.systemCode;
	}
	public void setFuctionCode(java.lang.String value) {
		this.fuctionCode = value;
	}
	
	public java.lang.String getFuctionCode() {
		return this.fuctionCode;
	}
	public void setTraceNo(java.lang.String value) {
		this.traceNo = value;
	}
	
	public java.lang.String getTraceNo() {
		return this.traceNo;
	}
	public void setCardNo(java.lang.String value) {
		this.cardNo = value;
	}
	
	public java.lang.String getCardNo() {
		return this.cardNo;
	}
	public void setSmartCard(java.lang.String value) {
		this.smartCard = value;
	}
	
	public java.lang.String getSmartCard() {
		return this.smartCard;
	}
	public void setAmount(java.lang.String value) {
		this.amount = value;
	}
	
	public java.lang.String getAmount() {
		return this.amount;
	}
	public void setSysDate(java.lang.String value) {
		this.sysDate = value;
	}
	
	public java.lang.String getSysDate() {
		return this.sysDate;
	}
	public void setSysTime(java.lang.String value) {
		this.sysTime = value;
	}
	
	public java.lang.String getSysTime() {
		return this.sysTime;
	}
	public void setRespCode(java.lang.String value) {
		this.respCode = value;
	}
	
	public java.lang.String getRespCode() {
		return this.respCode;
	}
	public void setRespMsg(java.lang.String value) {
		this.respMsg = value;
	}
	
	public java.lang.String getRespMsg() {
		return this.respMsg;
	}
	public void setCspRespCode(java.lang.String value) {
		this.cspRespCode = value;
	}
	
	public java.lang.String getCspRespCode() {
		return this.cspRespCode;
	}
	public void setCspRespMsg(java.lang.String value) {
		this.cspRespMsg = value;
	}
	
	public java.lang.String getCspRespMsg() {
		return this.cspRespMsg;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
	
	
}

