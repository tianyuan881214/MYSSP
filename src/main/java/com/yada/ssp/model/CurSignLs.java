/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.yada.ssp.model;

import javax.validation.constraints.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


import com.yada.ssp.model.*;
import com.yada.ssp.dao.*;
import com.yada.ssp.service.*;

/**
 * 
 * @author keenlyf
 *
 */


public class CurSignLs  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "签名信息流水";
	public static final String ALIAS_LS_ID = "流水ID";
	public static final String ALIAS_CARD_NO = "卡号";
	public static final String ALIAS_TRAN_AMT = "交易金额";
	public static final String ALIAS_TERMINAL_ID = "终端号";
	public static final String ALIAS_MERCHANT_ID = "商户号";
	public static final String ALIAS_TRACE_NO = "流水号";
	public static final String ALIAS_TRAN_RRN = "参考号";
	public static final String ALIAS_BATCH_NO = "批次号";
	public static final String ALIAS_LOCAL_SYS_DATE = "交易日期";
	public static final String ALIAS_LOCAL_SYS_TIME = "交易时间";
	public static final String ALIAS_SETTLE_DATE = "清算日期";
	public static final String ALIAS_TICKET_FL_NAME = "票据信息文件名";
	public static final String ALIAS_SIGN_FL_NAME = "签名信息文件名";
	public static final String ALIAS_START_TIME = "开始时间";
	public static final String ALIAS_END_TIME = "结束时间";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * lsId       db_column: LS_ID
     *  
     */	
	//@Length(max=32)
	private java.lang.String lsId;
    /**
     * cardNo       db_column: CARD_NO
     *  
     */	
	//@Length(max=19)
	private java.lang.String cardNo;
    /**
     * tranAmt       db_column: TRAN_AMT
     *  
     */	
	//
	private java.lang.String tranAmt;
    /**
     * terminalId       db_column: TERMINAL_ID
     *  
     */	
	//@Length(max=8)
	private java.lang.String terminalId;
    /**
     * merchantId       db_column: MERCHANT_ID
     *  
     */	
	//@Length(max=15)
	private java.lang.String merchantId;
    /**
     * traceNo       db_column: TRACE_NO
     *  
     */	
	//@Length(max=6)
	private java.lang.String traceNo;
    /**
     * tranRrn       db_column: TRAN_RRN
     *  
     */	
	//@Length(max=12)
	private java.lang.String tranRrn;
    /**
     * batchNo       db_column: BATCH_NO
     *  
     */	
	//@Length(max=6)
	private java.lang.String batchNo;
    /**
     * localSysDate       db_column: LOCAL_SYS_DATE
     *  
     */	
	//@Length(max=8)
	private java.lang.String localSysDate;
    /**
     * localSysTime       db_column: LOCAL_SYS_TIME
     *  
     */	
	//@Length(max=6)
	private java.lang.String localSysTime;
    /**
     * settleDate       db_column: SETTLE_DATE
     *  
     */	
	//@Length(max=4)
	private java.lang.String settleDate;
    /**
     * ticketFlName       db_column: TICKET_FL_NAME
     *  
     */	
	//@Length(max=30)
	private java.lang.String ticketFlName;
    /**
     * signFlName       db_column: SIGN_FL_NAME
     *  
     */	
	//@Length(max=30)
	private java.lang.String signFlName;
	//columns END

	public CurSignLs(){
	}

	public CurSignLs(
		java.lang.String lsId
	){
		this.lsId = lsId;
	}

		
		public void setLsId(java.lang.String value) {
			this.lsId = value;
		}
		
		public java.lang.String getLsId() {
			return this.lsId;
		}
		
		public void setCardNo(java.lang.String value) {
			this.cardNo = value;
		}
		
		public java.lang.String getCardNo() {
			return this.cardNo;
		}
		
		public void setTranAmt(String value) {
			this.tranAmt = value;
		}
		
		public String getTranAmt() {
			return this.tranAmt;
		}
		
		public void setTerminalId(java.lang.String value) {
			this.terminalId = value;
		}
		
		public java.lang.String getTerminalId() {
			return this.terminalId;
		}
		
		public void setMerchantId(java.lang.String value) {
			this.merchantId = value;
		}
		
		public java.lang.String getMerchantId() {
			return this.merchantId;
		}
		
		public void setTraceNo(java.lang.String value) {
			this.traceNo = value;
		}
		
		public java.lang.String getTraceNo() {
			return this.traceNo;
		}
		
		public void setTranRrn(java.lang.String value) {
			this.tranRrn = value;
		}
		
		public java.lang.String getTranRrn() {
			return this.tranRrn;
		}
		
		public void setBatchNo(java.lang.String value) {
			this.batchNo = value;
		}
		
		public java.lang.String getBatchNo() {
			return this.batchNo;
		}
		
		public void setLocalSysDate(java.lang.String value) {
			this.localSysDate = value;
		}
		
		public java.lang.String getLocalSysDate() {
			return this.localSysDate;
		}
		
		public void setLocalSysTime(java.lang.String value) {
			this.localSysTime = value;
		}
		
		public java.lang.String getLocalSysTime() {
			return this.localSysTime;
		}
		
		public void setSettleDate(java.lang.String value) {
			this.settleDate = value;
		}
		
		public java.lang.String getSettleDate() {
			return this.settleDate;
		}
		
		public void setTicketFlName(java.lang.String value) {
			this.ticketFlName = value;
		}
		
		public java.lang.String getTicketFlName() {
			return this.ticketFlName;
		}
		
		public void setSignFlName(java.lang.String value) {
			this.signFlName = value;
		}
		
		public java.lang.String getSignFlName() {
			return this.signFlName;
		}
/**
 *
*/

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("LsId",getLsId())
			.append("CardNo",getCardNo())
			.append("TranAmt",getTranAmt())
			.append("TerminalId",getTerminalId())
			.append("MerchantId",getMerchantId())
			.append("TraceNo",getTraceNo())
			.append("TranRrn",getTranRrn())
			.append("BatchNo",getBatchNo())
			.append("LocalSysDate",getLocalSysDate())
			.append("LocalSysTime",getLocalSysTime())
			.append("SettleDate",getSettleDate())
			.append("TicketFlName",getTicketFlName())
			.append("SignFlName",getSignFlName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getLsId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CurSignLs == false) return false;
		if(this == obj) return true;
		CurSignLs other = (CurSignLs)obj;
		return new EqualsBuilder()
			.append(getLsId(),other.getLsId())
			.isEquals();
	}
}

