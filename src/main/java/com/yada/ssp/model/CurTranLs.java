/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.yada.ssp.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class CurTranLs implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "交易流水";
	public static final String ALIAS_LS_ID = "ID";
	public static final String ALIAS_MSG_ID = "消息类型码";
	public static final String ALIAS_PROC_CODE = "处理码";
	public static final String ALIAS_CARD_NO = "卡号";
	public static final String ALIAS_EXP_DATE = "卡有效期";
	public static final String ALIAS_TRAN_TYPE = "交易名称";
	public static final String ALIAS_VOID_TRAN_TYPE = "原交易类型";
	public static final String ALIAS_VOID_OLD_TRAN_TYPE = "原原交易类型";
	public static final String ALIAS_IN_DATE = "交易接入日期";
	public static final String ALIAS_IN_TIME = "交易接入时间";
	public static final String ALIAS_OUT_DATE = "交易接出日期";
	public static final String ALIAS_OUT_TIME = "交易接出时间";
	public static final String ALIAS_LOCAL_SYS_DATE = "交易日期";
	public static final String ALIAS_LOCAL_SYS_TIME = "交易时间";
	public static final String ALIAS_HOST_LOGIC_DATE = "主机逻辑日期";
	public static final String ALIAS_TRAN_AMT = "交易金额";
	public static final String ALIAS_VOID_AMT = "原交易金额";
	public static final String ALIAS_SETTLE_AMT = "清算金额";
	public static final String ALIAS_BILLING_AMT = "营业额";
	public static final String ALIAS_ADJUST_AMT = "调整金额";
	public static final String ALIAS_SETTLE_RATE = "清算扣率";
	public static final String ALIAS_BILLING_RATE = "营业扣率";
	public static final String ALIAS_SETTLE_DATE = "清算日期";
	public static final String ALIAS_CONVERSION_RATE = "转换扣率";
	public static final String ALIAS_CCY_CODE = "货币码";
	public static final String ALIAS_BILLING_CCY_CODE = "营业货币码";
	public static final String ALIAS_TIP = "小费";
	public static final String ALIAS_FEE = "手续费";
	public static final String ALIAS_ACQ_INST_ID = "收单行机构码";
	public static final String ALIAS_FORWARD_INST_ID = "发送行机构码";
	public static final String ALIAS_TERMINAL_ID = "收单终端号";
	public static final String ALIAS_MERCHANT_ID = "收单商户号";
	public static final String ALIAS_MERCHANT_NAME = "商户名称";
	public static final String ALIAS_MCC = "MCC码";
	public static final String ALIAS_TRACE_NO = "POS流水号";
	public static final String ALIAS_VOID_TRACE_NO = "原POS流水号";
	public static final String ALIAS_TRAN_RRN = "系统参考号";
	public static final String ALIAS_VOID_TRAN_RRN = "原系统参考号";
	public static final String ALIAS_HOST_LS_NO = "主机流水号";
	public static final String ALIAS_VOID_HOST_LS_NO = "原主机流水号";
	public static final String ALIAS_INVOICE_NO = "票据号";
	public static final String ALIAS_VOID_INVOICE_NO = "原票据号";
	public static final String ALIAS_BATCH_NO = "批次号";
	public static final String ALIAS_BANK_TYPE = "银行类型";
	public static final String ALIAS_CARD_TYPE = "卡类型";
	public static final String ALIAS_CONDITION_CODE = "POS条件码";
	public static final String ALIAS_ACQ_BANK_ID = "收单行ID";
	public static final String ALIAS_ACQ_HOST_ID = "收单行主机ID";
	public static final String ALIAS_AUTH_NO = "授权码";
	public static final String ALIAS_RESP_CODE = "响应码";
	public static final String ALIAS_RESP_BANK_ID = "返回银行ID";
	public static final String ALIAS_RESP_HOST_ID = "返回主机ID";
	public static final String ALIAS_OPER_NO = "操作员号";
	public static final String ALIAS_LOCAL_SETTLE_DATE = "本地清算日期";
	public static final String ALIAS_LOCAL_SETTLE_FLAG = "本地清算标志";
	public static final String ALIAS_TRANS_ACCT_NO = "交易账户";
	public static final String ALIAS_TRANS_EXP_DATE = "交易账户有效期";
	public static final String ALIAS_TRANS_ACCT_TYPE = "账户类型";
	public static final String ALIAS_TRAN_FLAG = "交易标识";
	public static final String ALIAS_ADV_FLAG = "通知交易标识";
	public static final String ALIAS_OFFLINE_FLAG = "离线交易标识";
	public static final String ALIAS_SAF_FLAG = "冲正标识";
	public static final String ALIAS_INPUT_MODE = "输入模式";
	public static final String ALIAS_ADD_DATA = "附加信息";
	public static final String ALIAS_TRAN_ID = "SSP系统交易ID";
	public static final String ALIAS_CHANNEL_ID = "SSP系统渠道ID";
	public static final String ALIAS_KEEP_TIME = "保持时间";
	public static final String ALIAS_SEND_CNT = "冲正发送次数";
	public static final String ALIAS_CARD_NAME = "卡别";
	public static final String ALIAS_SERVICE_CODE = "卡服务代码";
	public static final String ALIAS_ARPC91 = "TAG91值";
	public static final String ALIAS_FORCEBACKINDER_DFEC = "Fall Back标识";
	public static final String ALIAS_CHIPCONDCODE_DFED = "IC 卡条件代码";
	public static final String ALIAS_TERMENTRYCAPAB_DFEE = "终端读取能力";
	public static final String ALIAS_CARD_TID = "外卡TID";
	public static final String ALIAS_FOREIGN_ID = "外卡组织编号";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * ID       db_column: LS_ID
     *  
     */	
	//@Length(max=32)
	private java.lang.String lsId;
    /**
     * 消息类型码       db_column: MSG_ID
     *  
     */	
	//@Length(max=4)
	private java.lang.String msgId;
    /**
     * 处理码       db_column: PROC_CODE
     *  
     */	
	//@Length(max=6)
	private java.lang.String procCode;
    /**
     * 卡号       db_column: CARD_NO
     *  
     */	
	//@Length(max=19)
	private java.lang.String cardNo;
    /**
     * 卡有效期       db_column: EXP_DATE
     *  
     */	
	//@Length(max=4)
	private java.lang.String expDate;
    /**
     * 交易类型       db_column: TRAN_TYPE
     *  
     */	
	//
	private java.lang.Long tranType;
    /**
     * 原交易类型       db_column: VOID_TRAN_TYPE
     *  
     */	
	//
	private java.lang.Long voidTranType;
    /**
     * 原原交易类型       db_column: VOID_OLD_TRAN_TYPE
     *  
     */	
	//
	private java.lang.Long voidOldTranType;
    /**
     * 交易接入日期       db_column: IN_DATE
     *  
     */	
	//@Length(max=8)
	private java.lang.String inDate;
    /**
     * 交易接入时间       db_column: IN_TIME
     *  
     */	
	//@Length(max=6)
	private java.lang.String inTime;
    /**
     * 交易接出日期       db_column: OUT_DATE
     *  
     */	
	//@Length(max=8)
	private java.lang.String outDate;
    /**
     * 交易接出时间       db_column: OUT_TIME
     *  
     */	
	//@Length(max=6)
	private java.lang.String outTime;
    /**
     * 本地交易日期       db_column: LOCAL_SYS_DATE
     *  
     */	
	//@Length(max=8)
	private java.lang.String localSysDate;
    /**
     * 本地交易时间       db_column: LOCAL_SYS_TIME
     *  
     */	
	//@Length(max=6)
	private java.lang.String localSysTime;
    /**
     * 主机逻辑日期       db_column: HOST_LOGIC_DATE
     *  
     */	
	//@Length(max=8)
	private java.lang.String hostLogicDate;
    /**
     * 交易金额       db_column: TRAN_AMT
     *  
     */	
	//
	private java.lang.String tranAmt;
    /**
     * 原交易金额       db_column: VOID_AMT
     *  
     */	
	//
	private java.lang.String voidAmt;
    /**
     * 清算金额       db_column: SETTLE_AMT
     *  
     */	
	//
	private Long settleAmt;
    /**
     * 营业额       db_column: BILLING_AMT
     *  
     */	
	//
	private Long billingAmt;
    /**
     * 调整金额       db_column: ADJUST_AMT
     *  
     */	
	//@Length(max=42)
	private java.lang.String adjustAmt;
    /**
     * 清算扣率       db_column: SETTLE_RATE
     *  
     */	
	//
	private Long settleRate;
    /**
     * 营业扣率       db_column: BILLING_RATE
     *  
     */	
	//
	private Long billingRate;
    /**
     * 清算日期       db_column: SETTLE_DATE
     *  
     */	
	//@Length(max=8)
	private java.lang.String settleDate;
    /**
     * 转换扣率       db_column: CONVERSION_RATE
     *  
     */	
	//@Length(max=8)
	private java.lang.String conversionRate;
    /**
     * 货币码       db_column: CCY_CODE
     *  
     */	
	//@Length(max=3)
	private java.lang.String ccyCode;
    /**
     * 营业货币码       db_column: BILLING_CCY_CODE
     *  
     */	
	//@Length(max=3)
	private java.lang.String billingCcyCode;
    /**
     * 小费       db_column: TIP
     *  
     */	
	//
	private Long tip;
    /**
     * 手续费       db_column: FEE
     *  
     */	
	//
	private Long fee;
    /**
     * 收单行机构码       db_column: ACQ_INST_ID
     *  
     */	
	//@Length(max=11)
	private java.lang.String acqInstId;
    /**
     * 发送行机构码       db_column: FORWARD_INST_ID
     *  
     */	
	//@Length(max=11)
	private java.lang.String forwardInstId;
    /**
     * 收单终端号       db_column: TERMINAL_ID
     *  
     */	
	//@Length(max=8)
	private java.lang.String terminalId;
    /**
     * 收单商户号       db_column: MERCHANT_ID
     *  
     */	
	//@Length(max=15)
	private java.lang.String merchantId;
    /**
     * 商户名称       db_column: MERCHANT_NAME
     *  
     */	
	//@Length(max=40)
	private java.lang.String merchantName;
    /**
     * MCC码       db_column: MCC
     *  
     */	
	//@Length(max=4)
	private java.lang.String mcc;
    /**
     * POS流水号       db_column: TRACE_NO
     *  
     */	
	//
	private java.lang.Long traceNo;
    /**
     * 原POS流水号       db_column: VOID_TRACE_NO
     *  
     */	
	//
	private java.lang.Long voidTraceNo;
    /**
     * 系统参考号       db_column: TRAN_RRN
     *  
     */	
	//@Length(max=12)
	private java.lang.String tranRrn;
    /**
     * 原系统参考号       db_column: VOID_TRAN_RRN
     *  
     */	
	//@Length(max=12)
	private java.lang.String voidTranRrn;
    /**
     * 主机流水号       db_column: HOST_LS_NO
     *  
     */	
	//
	private java.lang.Long hostLsNo;
    /**
     * 原主机流水号       db_column: VOID_HOST_LS_NO
     *  
     */	
	//
	private java.lang.Long voidHostLsNo;
    /**
     * 票据号       db_column: INVOICE_NO
     *  
     */	
	//
	private java.lang.Long invoiceNo;
    /**
     * 原票据号       db_column: VOID_INVOICE_NO
     *  
     */	
	//
	private java.lang.Long voidInvoiceNo;
    /**
     * 批次号       db_column: BATCH_NO
     *  
     */	
	//
	private java.lang.Long batchNo;
    /**
     * 银行类型       db_column: BANK_TYPE
     *  
     */	
	//@Length(max=4)
	private java.lang.String bankType;
    /**
     * 卡类型       db_column: CARD_TYPE
     *  
     */	
	//@Length(max=2)
	private java.lang.String cardType;
    /**
     * POS条件码       db_column: CONDITION_CODE
     *  
     */	
	//@Length(max=2)
	private java.lang.String conditionCode;
    /**
     * 收单行ID       db_column: ACQ_BANK_ID
     *  
     */	
	//@Length(max=11)
	private java.lang.String acqBankId;
    /**
     * 收单行主机ID       db_column: ACQ_HOST_ID
     *  
     */	
	//@Length(max=2)
	private java.lang.String acqHostId;
    /**
     * 授权码       db_column: AUTH_NO
     *  
     */	
	//@Length(max=6)
	private java.lang.String authNo;
    /**
     * 响应码       db_column: RESP_CODE
     *  
     */	
	//@Length(max=3)
	private java.lang.String respCode;
    /**
     * 返回银行ID       db_column: RESP_BANK_ID
     *  
     */	
	//@Length(max=11)
	private java.lang.String respBankId;
    /**
     * 返回主机ID       db_column: RESP_HOST_ID
     *  
     */	
	//@Length(max=2)
	private java.lang.String respHostId;
    /**
     * 操作员号       db_column: OPER_NO
     *  
     */	
	//@Length(max=6)
	private java.lang.String operNo;
    /**
     * 本地清算日期       db_column: LOCAL_SETTLE_DATE
     *  
     */	
	//@Length(max=14)
	private java.lang.String localSettleDate;
    /**
     * 本地清算标志       db_column: LOCAL_SETTLE_FLAG
     *  
     */	
	//@Length(max=1)
	private java.lang.String localSettleFlag;
    /**
     * 交易账户       db_column: TRANS_ACCT_NO
     *  
     */	
	//@Length(max=19)
	private java.lang.String transAcctNo;
    /**
     * 交易账户有效期       db_column: TRANS_EXP_DATE
     *  
     */	
	//@Length(max=4)
	private java.lang.String transExpDate;
    /**
     * 账户类型       db_column: TRANS_ACCT_TYPE
     *  
     */	
	//@Length(max=2)
	private java.lang.String transAcctType;
    /**
     * 交易标识       db_column: TRAN_FLAG
     *  
     */	
	//@Length(max=1)
	private java.lang.String tranFlag;
    /**
     * 通知交易标识       db_column: ADV_FLAG
     *  
     */	
	//@Length(max=1)
	private java.lang.String advFlag;
    /**
     * 离线交易标识       db_column: OFFLINE_FLAG
     *  
     */	
	//@Length(max=1)
	private java.lang.String offlineFlag;
    /**
     * 冲正标识       db_column: SAF_FLAG
     *  
     */	
	//@Length(max=1)
	private java.lang.String safFlag;
    /**
     * 输入模式       db_column: INPUT_MODE
     *  
     */	
	//@Length(max=3)
	private java.lang.String inputMode;
    /**
     * 附加信息       db_column: ADD_DATA
     *  
     */	
	//@Length(max=60)
	private java.lang.String addData;
    /**
     * SSP系统交易ID       db_column: TRAN_ID
     *  
     */	
	//@Length(max=6)
	private java.lang.String tranId;
    /**
     * SSP系统渠道ID       db_column: CHANNEL_ID
     *  
     */	
	//@Length(max=3)
	private java.lang.String channelId;
    /**
     * 保持时间       db_column: KEEP_TIME
     *  
     */	
	//@Length(max=16)
	private java.lang.String keepTime;
    /**
     * 冲正发送次数       db_column: SEND_CNT
     *  
     */	
	//
	private java.lang.Long sendCnt;
    /**
     * 卡名称       db_column: CARD_NAME
     *  
     */	
	//@Length(max=10)
	private java.lang.String cardName;
    /**
     * 卡服务代码       db_column: SERVICE_CODE
     *  
     */	
	//@Length(max=3)
	private java.lang.String serviceCode;
    /**
     * TAG91值       db_column: ARPC_91
     *  
     */	
	//@Length(max=32)
	private java.lang.String arpc91;
    /**
     * Fall Back标识       db_column: FORCEBACKINDER_DFEC
     *  
     */	
	//@Length(max=2)
	private java.lang.String forcebackinderDfec;
    /**
     * IC 卡条件代码       db_column: CHIPCONDCODE_DFED
     *  
     */	
	//@Length(max=2)
	private java.lang.String chipcondcodeDfed;
    /**
     * 终端读取能力       db_column: TERMENTRYCAPAB_DFEE
     *  
     */	
	//@Length(max=2)
	private java.lang.String termentrycapabDfee;
    /**
     * 外卡TID       db_column: CARD_TID
     *  
     */	
	//@Length(max=15)
	private java.lang.String cardTid;
    /**
     * 外卡组织编号       db_column: FOREIGN_ID
     *  
     */	
	//@Length(max=15)
	private java.lang.String foreignId;
	//columns END

	public CurTranLs(){
	}

	public CurTranLs(
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
		
		public void setMsgId(java.lang.String value) {
			this.msgId = value;
		}
		
		public java.lang.String getMsgId() {
			return this.msgId;
		}
		
		public void setProcCode(java.lang.String value) {
			this.procCode = value;
		}
		
		public java.lang.String getProcCode() {
			return this.procCode;
		}
		
		public void setCardNo(java.lang.String value) {
			this.cardNo = value;
		}
		
		public java.lang.String getCardNo() {
			return this.cardNo;
		}
		
		public void setExpDate(java.lang.String value) {
			this.expDate = value;
		}
		
		public java.lang.String getExpDate() {
			return this.expDate;
		}
		
		public void setTranType(java.lang.Long value) {
			this.tranType = value;
		}
		
		public java.lang.Long getTranType() {
			return this.tranType;
		}
		
		public void setVoidTranType(java.lang.Long value) {
			this.voidTranType = value;
		}
		
		public java.lang.Long getVoidTranType() {
			return this.voidTranType;
		}
		
		public void setVoidOldTranType(java.lang.Long value) {
			this.voidOldTranType = value;
		}
		
		public java.lang.Long getVoidOldTranType() {
			return this.voidOldTranType;
		}
		
		public void setInDate(java.lang.String value) {
			this.inDate = value;
		}
		
		public java.lang.String getInDate() {
			return this.inDate;
		}
		
		public void setInTime(java.lang.String value) {
			this.inTime = value;
		}
		
		public java.lang.String getInTime() {
			return this.inTime;
		}
		
		public void setOutDate(java.lang.String value) {
			this.outDate = value;
		}
		
		public java.lang.String getOutDate() {
			return this.outDate;
		}
		
		public void setOutTime(java.lang.String value) {
			this.outTime = value;
		}
		
		public java.lang.String getOutTime() {
			return this.outTime;
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
		
		public void setHostLogicDate(java.lang.String value) {
			this.hostLogicDate = value;
		}
		
		public java.lang.String getHostLogicDate() {
			return this.hostLogicDate;
		}
		
		public void setTranAmt(java.lang.String value) {
			this.tranAmt = value;
		}
		
		public java.lang.String getTranAmt() {
			return this.tranAmt;
		}
		
		public void setVoidAmt(java.lang.String value) {
			this.voidAmt = value;
		}
		
		public java.lang.String getVoidAmt() {
			return this.voidAmt;
		}
		
		public void setSettleAmt(Long value) {
			this.settleAmt = value;
		}
		
		public Long getSettleAmt() {
			return this.settleAmt;
		}
		
		public void setBillingAmt(Long value) {
			this.billingAmt = value;
		}
		
		public Long getBillingAmt() {
			return this.billingAmt;
		}
		
		public void setAdjustAmt(java.lang.String value) {
			this.adjustAmt = value;
		}
		
		public java.lang.String getAdjustAmt() {
			return this.adjustAmt;
		}
		
		public void setSettleRate(Long value) {
			this.settleRate = value;
		}
		
		public Long getSettleRate() {
			return this.settleRate;
		}
		
		public void setBillingRate(Long value) {
			this.billingRate = value;
		}
		
		public Long getBillingRate() {
			return this.billingRate;
		}
		
		public void setSettleDate(java.lang.String value) {
			this.settleDate = value;
		}
		
		public java.lang.String getSettleDate() {
			return this.settleDate;
		}
		
		public void setConversionRate(java.lang.String value) {
			this.conversionRate = value;
		}
		
		public java.lang.String getConversionRate() {
			return this.conversionRate;
		}
		
		public void setCcyCode(java.lang.String value) {
			this.ccyCode = value;
		}
		
		public java.lang.String getCcyCode() {
			return this.ccyCode;
		}
		
		public void setBillingCcyCode(java.lang.String value) {
			this.billingCcyCode = value;
		}
		
		public java.lang.String getBillingCcyCode() {
			return this.billingCcyCode;
		}
		
		public void setTip(Long value) {
			this.tip = value;
		}
		
		public Long getTip() {
			return this.tip;
		}
		
		public void setFee(Long value) {
			this.fee = value;
		}
		
		public Long getFee() {
			return this.fee;
		}
		
		public void setAcqInstId(java.lang.String value) {
			this.acqInstId = value;
		}
		
		public java.lang.String getAcqInstId() {
			return this.acqInstId;
		}
		
		public void setForwardInstId(java.lang.String value) {
			this.forwardInstId = value;
		}
		
		public java.lang.String getForwardInstId() {
			return this.forwardInstId;
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
		
		public void setMerchantName(java.lang.String value) {
			this.merchantName = value;
		}
		
		public java.lang.String getMerchantName() {
			return this.merchantName;
		}
		
		public void setMcc(java.lang.String value) {
			this.mcc = value;
		}
		
		public java.lang.String getMcc() {
			return this.mcc;
		}
		
		public void setTraceNo(java.lang.Long value) {
			this.traceNo = value;
		}
		
		public java.lang.Long getTraceNo() {
			return this.traceNo;
		}
		
		public void setVoidTraceNo(java.lang.Long value) {
			this.voidTraceNo = value;
		}
		
		public java.lang.Long getVoidTraceNo() {
			return this.voidTraceNo;
		}
		
		public void setTranRrn(java.lang.String value) {
			this.tranRrn = value;
		}
		
		public java.lang.String getTranRrn() {
			return this.tranRrn;
		}
		
		public void setVoidTranRrn(java.lang.String value) {
			this.voidTranRrn = value;
		}
		
		public java.lang.String getVoidTranRrn() {
			return this.voidTranRrn;
		}
		
		public void setHostLsNo(java.lang.Long value) {
			this.hostLsNo = value;
		}
		
		public java.lang.Long getHostLsNo() {
			return this.hostLsNo;
		}
		
		public void setVoidHostLsNo(java.lang.Long value) {
			this.voidHostLsNo = value;
		}
		
		public java.lang.Long getVoidHostLsNo() {
			return this.voidHostLsNo;
		}
		
		public void setInvoiceNo(java.lang.Long value) {
			this.invoiceNo = value;
		}
		
		public java.lang.Long getInvoiceNo() {
			return this.invoiceNo;
		}
		
		public void setVoidInvoiceNo(java.lang.Long value) {
			this.voidInvoiceNo = value;
		}
		
		public java.lang.Long getVoidInvoiceNo() {
			return this.voidInvoiceNo;
		}
		
		public void setBatchNo(java.lang.Long value) {
			this.batchNo = value;
		}
		
		public java.lang.Long getBatchNo() {
			return this.batchNo;
		}
		
		public void setBankType(java.lang.String value) {
			this.bankType = value;
		}
		
		public java.lang.String getBankType() {
			return this.bankType;
		}
		
		public void setCardType(java.lang.String value) {
			this.cardType = value;
		}
		
		public java.lang.String getCardType() {
			return this.cardType;
		}
		
		public void setConditionCode(java.lang.String value) {
			this.conditionCode = value;
		}
		
		public java.lang.String getConditionCode() {
			return this.conditionCode;
		}
		
		public void setAcqBankId(java.lang.String value) {
			this.acqBankId = value;
		}
		
		public java.lang.String getAcqBankId() {
			return this.acqBankId;
		}
		
		public void setAcqHostId(java.lang.String value) {
			this.acqHostId = value;
		}
		
		public java.lang.String getAcqHostId() {
			return this.acqHostId;
		}
		
		public void setAuthNo(java.lang.String value) {
			this.authNo = value;
		}
		
		public java.lang.String getAuthNo() {
			return this.authNo;
		}
		
		public void setRespCode(java.lang.String value) {
			this.respCode = value;
		}
		
		public java.lang.String getRespCode() {
			return this.respCode;
		}
		
		public void setRespBankId(java.lang.String value) {
			this.respBankId = value;
		}
		
		public java.lang.String getRespBankId() {
			return this.respBankId;
		}
		
		public void setRespHostId(java.lang.String value) {
			this.respHostId = value;
		}
		
		public java.lang.String getRespHostId() {
			return this.respHostId;
		}
		
		public void setOperNo(java.lang.String value) {
			this.operNo = value;
		}
		
		public java.lang.String getOperNo() {
			return this.operNo;
		}
		
		public void setLocalSettleDate(java.lang.String value) {
			this.localSettleDate = value;
		}
		
		public java.lang.String getLocalSettleDate() {
			return this.localSettleDate;
		}
		
		public void setLocalSettleFlag(java.lang.String value) {
			this.localSettleFlag = value;
		}
		
		public java.lang.String getLocalSettleFlag() {
			return this.localSettleFlag;
		}
		
		public void setTransAcctNo(java.lang.String value) {
			this.transAcctNo = value;
		}
		
		public java.lang.String getTransAcctNo() {
			return this.transAcctNo;
		}
		
		public void setTransExpDate(java.lang.String value) {
			this.transExpDate = value;
		}
		
		public java.lang.String getTransExpDate() {
			return this.transExpDate;
		}
		
		public void setTransAcctType(java.lang.String value) {
			this.transAcctType = value;
		}
		
		public java.lang.String getTransAcctType() {
			return this.transAcctType;
		}
		
		public void setTranFlag(java.lang.String value) {
			this.tranFlag = value;
		}
		
		public java.lang.String getTranFlag() {
			return this.tranFlag;
		}
		
		public void setAdvFlag(java.lang.String value) {
			this.advFlag = value;
		}
		
		public java.lang.String getAdvFlag() {
			return this.advFlag;
		}
		
		public void setOfflineFlag(java.lang.String value) {
			this.offlineFlag = value;
		}
		
		public java.lang.String getOfflineFlag() {
			return this.offlineFlag;
		}
		
		public void setSafFlag(java.lang.String value) {
			this.safFlag = value;
		}
		
		public java.lang.String getSafFlag() {
			return this.safFlag;
		}
		
		public void setInputMode(java.lang.String value) {
			this.inputMode = value;
		}
		
		public java.lang.String getInputMode() {
			return this.inputMode;
		}
		
		public void setAddData(java.lang.String value) {
			this.addData = value;
		}
		
		public java.lang.String getAddData() {
			return this.addData;
		}
		
		public void setTranId(java.lang.String value) {
			this.tranId = value;
		}
		
		public java.lang.String getTranId() {
			return this.tranId;
		}
		
		public void setChannelId(java.lang.String value) {
			this.channelId = value;
		}
		
		public java.lang.String getChannelId() {
			return this.channelId;
		}
		
		public void setKeepTime(java.lang.String value) {
			this.keepTime = value;
		}
		
		public java.lang.String getKeepTime() {
			return this.keepTime;
		}
		
		public void setSendCnt(java.lang.Long value) {
			this.sendCnt = value;
		}
		
		public java.lang.Long getSendCnt() {
			return this.sendCnt;
		}
		
		public void setCardName(java.lang.String value) {
			this.cardName = value;
		}
		
		public java.lang.String getCardName() {
			return this.cardName;
		}
		
		public void setServiceCode(java.lang.String value) {
			this.serviceCode = value;
		}
		
		public java.lang.String getServiceCode() {
			return this.serviceCode;
		}
		
		public void setArpc91(java.lang.String value) {
			this.arpc91 = value;
		}
		
		public java.lang.String getArpc91() {
			return this.arpc91;
		}
		
		public void setForcebackinderDfec(java.lang.String value) {
			this.forcebackinderDfec = value;
		}
		
		public java.lang.String getForcebackinderDfec() {
			return this.forcebackinderDfec;
		}
		
		public void setChipcondcodeDfed(java.lang.String value) {
			this.chipcondcodeDfed = value;
		}
		
		public java.lang.String getChipcondcodeDfed() {
			return this.chipcondcodeDfed;
		}
		
		public void setTermentrycapabDfee(java.lang.String value) {
			this.termentrycapabDfee = value;
		}
		
		public java.lang.String getTermentrycapabDfee() {
			return this.termentrycapabDfee;
		}
		
		public void setCardTid(java.lang.String value) {
			this.cardTid = value;
		}
		
		public java.lang.String getCardTid() {
			return this.cardTid;
		}
		
		public void setForeignId(java.lang.String value) {
			this.foreignId = value;
		}
		
		public java.lang.String getForeignId() {
			return this.foreignId;
		}
/**
 *	
	private Set zzCurLss = new HashSet(0);
	public void setZzCurLss(Set<ZzCurLs> zzCurLs){
		this.zzCurLss = zzCurLs;
	}
	
	public Set<ZzCurLs> getZzCurLss() {
		return zzCurLss;
	}

	
	private Banktype banktype;
	
	public void setBanktype(Banktype banktype){
		this.banktype = banktype;
	}
	
	public Banktype getBanktype() {
		return banktype;
	}
	
	private Retcode retcode;
	
	public void setRetcode(Retcode retcode){
		this.retcode = retcode;
	}
	
	public Retcode getRetcode() {
		return retcode;
	}
	
	private Cardtype cardtype;
	
	public void setCardtype(Cardtype cardtype){
		this.cardtype = cardtype;
	}
	
	public Cardtype getCardtype() {
		return cardtype;
	}
	
	private Trantype trantype;
	
	public void setTrantype(Trantype trantype){
		this.trantype = trantype;
	}
	
	public Trantype getTrantype() {
		return trantype;
	}
*/

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("LsId",getLsId())
			.append("MsgId",getMsgId())
			.append("ProcCode",getProcCode())
			.append("CardNo",getCardNo())
			.append("ExpDate",getExpDate())
			.append("TranType",getTranType())
			.append("VoidTranType",getVoidTranType())
			.append("VoidOldTranType",getVoidOldTranType())
			.append("InDate",getInDate())
			.append("InTime",getInTime())
			.append("OutDate",getOutDate())
			.append("OutTime",getOutTime())
			.append("LocalSysDate",getLocalSysDate())
			.append("LocalSysTime",getLocalSysTime())
			.append("HostLogicDate",getHostLogicDate())
			.append("TranAmt",getTranAmt())
			.append("VoidAmt",getVoidAmt())
			.append("SettleAmt",getSettleAmt())
			.append("BillingAmt",getBillingAmt())
			.append("AdjustAmt",getAdjustAmt())
			.append("SettleRate",getSettleRate())
			.append("BillingRate",getBillingRate())
			.append("SettleDate",getSettleDate())
			.append("ConversionRate",getConversionRate())
			.append("CcyCode",getCcyCode())
			.append("BillingCcyCode",getBillingCcyCode())
			.append("Tip",getTip())
			.append("Fee",getFee())
			.append("AcqInstId",getAcqInstId())
			.append("ForwardInstId",getForwardInstId())
			.append("TerminalId",getTerminalId())
			.append("MerchantId",getMerchantId())
			.append("MerchantName",getMerchantName())
			.append("Mcc",getMcc())
			.append("TraceNo",getTraceNo())
			.append("VoidTraceNo",getVoidTraceNo())
			.append("TranRrn",getTranRrn())
			.append("VoidTranRrn",getVoidTranRrn())
			.append("HostLsNo",getHostLsNo())
			.append("VoidHostLsNo",getVoidHostLsNo())
			.append("InvoiceNo",getInvoiceNo())
			.append("VoidInvoiceNo",getVoidInvoiceNo())
			.append("BatchNo",getBatchNo())
			.append("BankType",getBankType())
			.append("CardType",getCardType())
			.append("ConditionCode",getConditionCode())
			.append("AcqBankId",getAcqBankId())
			.append("AcqHostId",getAcqHostId())
			.append("AuthNo",getAuthNo())
			.append("RespCode",getRespCode())
			.append("RespBankId",getRespBankId())
			.append("RespHostId",getRespHostId())
			.append("OperNo",getOperNo())
			.append("LocalSettleDate",getLocalSettleDate())
			.append("LocalSettleFlag",getLocalSettleFlag())
			.append("TransAcctNo",getTransAcctNo())
			.append("TransExpDate",getTransExpDate())
			.append("TransAcctType",getTransAcctType())
			.append("TranFlag",getTranFlag())
			.append("AdvFlag",getAdvFlag())
			.append("OfflineFlag",getOfflineFlag())
			.append("SafFlag",getSafFlag())
			.append("InputMode",getInputMode())
			.append("AddData",getAddData())
			.append("TranId",getTranId())
			.append("ChannelId",getChannelId())
			.append("KeepTime",getKeepTime())
			.append("SendCnt",getSendCnt())
			.append("CardName",getCardName())
			.append("ServiceCode",getServiceCode())
			.append("Arpc91",getArpc91())
			.append("ForcebackinderDfec",getForcebackinderDfec())
			.append("ChipcondcodeDfed",getChipcondcodeDfed())
			.append("TermentrycapabDfee",getTermentrycapabDfee())
			.append("CardTid",getCardTid())
			.append("ForeignId",getForeignId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getLsId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CurTranLs == false) return false;
		if(this == obj) return true;
		CurTranLs other = (CurTranLs)obj;
		return new EqualsBuilder()
			.append(getLsId(),other.getLsId())
			.isEquals();
	}
}

