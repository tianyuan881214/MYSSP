package com.yada.ssp.model;

import java.io.Serializable;

/**
 * @author xianyong
 * 微信流水
 */
public class PayTranWeChatLs implements Serializable{
    private String	outTradeNo	;//	商户订单号	OUT_TRADE_NO	VARCHAR2(32 BYTE)
    private String	oldBatchNo	;//	原批次号	OLD_BATCHNO	VARCHAR2(6 BYTE)
    private String	oldTraceNo	;//	原终端流水号	OLD_TRACENO	CHAR(6 BYTE)
    private String	oldTranDate	;//	原交易日期	OLD_TRANDATE	CHAR(8 BYTE)
    private String	oldTranTime	;//	原交易时间	OLD_TRANTIME	CHAR(6 BYTE)
    private String	authCode	;//	必填 32 支付授权码	AUTH_CODE	VARCHAR2(32 BYTE)
    private String	batchNo	;//	终端批次号	BATCH_NO	CHAR(6 BYTE)
    private String	errCode	;//	错误代码	ERR_CODE	VARCHAR2(32 BYTE)
    private String	mchId	;//	微信支付分配的商户号	MCH_ID	VARCHAR2(32 BYTE)
    private String	merchantNo	;//	商户编号	MERCHANT_NO	VARCHAR2(15 BYTE)
    private String  merchantName;//商户名称
    private String	operatorId	;//	操作员号	OPERATOR_ID	CHAR(6 BYTE)
    private String	refundFlag	;//	退货标识	REFUND_FLAG	CHAR(1 BYTE)
    private String	resultCode	;//	业务结果	RESULT_CODE	VARCHAR2(16 BYTE)
    private String	returnCode	;//	返回状态码,SUCCESS/FAIL 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断	RETURN_CODE	VARCHAR2(16 BYTE)
    private String	returnMsg	;//	签名失败	返回信息，如非空，为错误原因 签名失败 参数格式校验错误	RETURN_MSG	VARCHAR2(128 BYTE)
    private String	terminalId	;//	终端编号	TERMINAL_ID	CHAR(8 BYTE)
    private String	totalAmount	;//	交易金额	TOTAL_AMOUNT	NUMBER(18,2)
    private String	traceNo	;//	终端流水号	TRACE_NO	CHAR(6 BYTE)
    private String	tradeType	;//	交易类型	TRADE_TYPE	VARCHAR2(16 BYTE)
    private String	tranDate	;//	发送请求的日期	TRAN_DATE	CHAR(8 BYTE)
    private String	tranTime	;//	发送请求的时间格式	TRAN_TIME	CHAR(6 BYTE)
    private String	tranType	;//	交易类型	TRAN_TYPE	CHAR(6 BYTE)
    private String	transactionId	;//	微信支付订单号	TRANSACTION_ID	VARCHAR2(32 BYTE)
    private String	undoFlag	;//	撤销标识	UNDO_FLAG	CHAR(1 BYTE)
    private String name;
    private String inOrg;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getInOrg() {
        return inOrg;
    }

    public void setInOrg(String inOrg) {
        this.inOrg = inOrg;
    }

    private String merchantCname;

    public String getMerchantCname() {
        return merchantCname;
    }

    public void setMerchantCname(String merchantCname) {
        this.merchantCname = merchantCname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOldBatchNo() {
        return oldBatchNo;
    }

    public void setOldBatchNo(String oldBatchNo) {
        this.oldBatchNo = oldBatchNo;
    }

    public String getOldTraceNo() {
        return oldTraceNo;
    }

    public void setOldTraceNo(String oldTraceNo) {
        this.oldTraceNo = oldTraceNo;
    }

    public String getOldTranDate() {
        return oldTranDate;
    }

    public void setOldTranDate(String oldTranDate) {
        this.oldTranDate = oldTranDate;
    }

    public String getOldTranTime() {
        return oldTranTime;
    }

    public void setOldTranTime(String oldTranTime) {
        this.oldTranTime = oldTranTime;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getRefundFlag() {
        return refundFlag;
    }

    public void setRefundFlag(String refundFlag) {
        this.refundFlag = refundFlag;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranTime() {
        return tranTime;
    }

    public void setTranTime(String tranTime) {
        this.tranTime = tranTime;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUndoFlag() {
        return undoFlag;
    }

    public void setUndoFlag(String undoFlag) {
        this.undoFlag = undoFlag;
    }
}
