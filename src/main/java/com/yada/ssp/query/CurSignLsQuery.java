package com.yada.ssp.query;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.*;

import com.yada.security.base.BaseQuery;
import com.yada.ssp.model.*;
import com.yada.ssp.dao.*;
import com.yada.ssp.service.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class CurSignLsQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** lsId */
	private java.lang.String lsId;
	/** cardNo */
	private java.lang.String cardNo;
	/** tranAmt */
	private java.lang.String tranAmt;
	/** terminalId */
	private java.lang.String terminalId;
	/** merchantId */
	private java.lang.String merchantId;
	/** traceNo */
	private java.lang.String traceNo;
	/** tranRrn */
	private java.lang.String tranRrn;
	/** batchNo */
	private java.lang.String batchNo;
	/** localSysDate */
	private java.lang.String localSysDate;
	/** localSysTime */
	private java.lang.String localSysTime;
	/** settleDate */
	private java.lang.String settleDate;
	/** ticketFlName */
	private java.lang.String ticketFlName;
	/** signFlName */
	private java.lang.String signFlName;
	/** 新增*/
	private java.lang.String zbank;
	private java.lang.String startDate;
	private java.lang.String endDate;

	public java.lang.String getStartDate() {
		return startDate;
	}

	public void setStartDate(java.lang.String startDate) {
		this.startDate = startDate;
	}

	public java.lang.String getEndDate() {
		return endDate;
	}

	public void setEndDate(java.lang.String endDate) {
		this.endDate = endDate;
	}

	public java.lang.String getLsId() {
		return this.lsId;
	}
	
	public void setLsId(java.lang.String value) {
		this.lsId = value;
	}
	
	public java.lang.String getCardNo() {
		return this.cardNo;
	}
	
	public void setCardNo(java.lang.String value) {
		this.cardNo = value;
	}
	
	public String getTranAmt() {
		return this.tranAmt;
	}
	
	public void setTranAmt(String value) {
		this.tranAmt = value;
	}
	
	public java.lang.String getTerminalId() {
		return this.terminalId;
	}
	
	public void setTerminalId(java.lang.String value) {
		this.terminalId = value;
	}
	
	public java.lang.String getMerchantId() {
		return this.merchantId;
	}
	
	public void setMerchantId(java.lang.String value) {
		this.merchantId = value;
	}
	
	public java.lang.String getTraceNo() {
		return this.traceNo;
	}
	
	public void setTraceNo(java.lang.String value) {
		this.traceNo = value;
	}
	
	public java.lang.String getTranRrn() {
		return this.tranRrn;
	}
	
	public void setTranRrn(java.lang.String value) {
		this.tranRrn = value;
	}
	
	public java.lang.String getBatchNo() {
		return this.batchNo;
	}
	
	public void setBatchNo(java.lang.String value) {
		this.batchNo = value;
	}
	
	public java.lang.String getLocalSysDate() {
		return this.localSysDate;
	}
	
	public void setLocalSysDate(java.lang.String value) {
		this.localSysDate = value;
	}
	
	public java.lang.String getLocalSysTime() {
		return this.localSysTime;
	}
	
	public void setLocalSysTime(java.lang.String value) {
		this.localSysTime = value;
	}
	
	public java.lang.String getSettleDate() {
		return this.settleDate;
	}
	
	public void setSettleDate(java.lang.String value) {
		this.settleDate = value;
	}
	
	public java.lang.String getTicketFlName() {
		return this.ticketFlName;
	}
	
	public void setTicketFlName(java.lang.String value) {
		this.ticketFlName = value;
	}
	
	public java.lang.String getSignFlName() {
		return this.signFlName;
	}
	
	public void setSignFlName(java.lang.String value) {
		this.signFlName = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}

	public java.lang.String getZbank() {
		return zbank;
	}

	public void setZbank(java.lang.String zbank) {
		this.zbank = zbank;
	}
	
}

