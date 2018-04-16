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


public class GdRcfLs {
	
	//alias
	public static final String TABLE_ALIAS = "充值流水";
	public static final String ALIAS_TRAN_TYPE = "交易类型";
	public static final String ALIAS_SYSTEM_CODE = "系统编码";
	public static final String ALIAS_FUCTION_CODE = "功能编码";
	public static final String ALIAS_TRACE_NO = "业务号";
	public static final String ALIAS_CARD_NO = "银行卡";
	public static final String ALIAS_SMART_CARD = "园区卡";
	public static final String ALIAS_AMOUNT = "金额";
	public static final String ALIAS_SYS_DATE = "系统日期";
	public static final String ALIAS_SYS_TIME = "系统时间";
	public static final String ALIAS_RESP_CODE = "响应码";
	public static final String ALIAS_RESP_MSG = "响应码中文解释";
	public static final String ALIAS_CSP_RESP_CODE = "CSP响应码";
	public static final String ALIAS_CSP_RESP_MSG = "CSP响应中文解释";
	
	//date formats
	
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

	public GdRcfLs(){
	}


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
		return new ToStringBuilder(this)
			.append("TranType",getTranType())
			.append("SystemCode",getSystemCode())
			.append("FuctionCode",getFuctionCode())
			.append("TraceNo",getTraceNo())
			.append("CardNo",getCardNo())
			.append("SmartCard",getSmartCard())
			.append("Amount",getAmount())
			.append("SysDate",getSysDate())
			.append("SysTime",getSysTime())
			.append("RespCode",getRespCode())
			.append("RespMsg",getRespMsg())
			.append("CspRespCode",getCspRespCode())
			.append("CspRespMsg",getCspRespMsg())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getTranType())
			.append(getSystemCode())
			.append(getFuctionCode())
			.append(getTraceNo())
			.append(getCardNo())
			.append(getSmartCard())
			.append(getAmount())
			.append(getSysDate())
			.append(getSysTime())
			.append(getRespCode())
			.append(getRespMsg())
			.append(getCspRespCode())
			.append(getCspRespMsg())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof GdRcfLs == false) return false;
		if(this == obj) return true;
		GdRcfLs other = (GdRcfLs)obj;
		return new EqualsBuilder()
			.append(getTranType(),other.getTranType())
			.append(getSystemCode(),other.getSystemCode())
			.append(getFuctionCode(),other.getFuctionCode())
			.append(getTraceNo(),other.getTraceNo())
			.append(getCardNo(),other.getCardNo())
			.append(getSmartCard(),other.getSmartCard())
			.append(getAmount(),other.getAmount())
			.append(getSysDate(),other.getSysDate())
			.append(getSysTime(),other.getSysTime())
			.append(getRespCode(),other.getRespCode())
			.append(getRespMsg(),other.getRespMsg())
			.append(getCspRespCode(),other.getCspRespCode())
			.append(getCspRespMsg(),other.getCspRespMsg())
			.isEquals();
	}
	
	/**
	 * @Description:文件稽核日志信息
	 * @return String,name=value
	 * @author longwu.yan
	 */
	public String toAuditLogString() {
		return new StringBuilder()
		.append(",TRAN_TYPE=" + getTranType())
		.append(",SYSTEM_CODE=" + getSystemCode())
		.append(",FUCTION_CODE=" + getFuctionCode())
		.append(",TRACE_NO=" + getTraceNo())
		.append(",CARD_NO=" + getCardNo())
		.append(",SMART_CARD=" + getSmartCard())
		.append(",AMOUNT=" + getAmount())
		.append(",SYS_DATE=" + getSysDate())
		.append(",SYS_TIME=" + getSysTime())
		.append(",RESP_CODE=" + getRespCode())
		.append(",RESP_MSG=" + getRespMsg())
		.append(",CSP_RESP_CODE=" + getCspRespCode())
		.append(",CSP_RESP_MSG=" + getCspRespMsg())
		.toString();
	}
}

