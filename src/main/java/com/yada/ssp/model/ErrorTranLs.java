package com.yada.ssp.model;

/**
 * @author xianyong
 */
public class ErrorTranLs {

    private String 	id	;//	ID	VARCHAR2(32)	ID
    private String 	tranSources	;//	TRAN_SOURCES	CHAR(1)	流水来源 1本地 2支付宝 3微信 4银联 5 miss
    private String 	accountRelation	;//	ACCOUNT_RELATION	CHAR(1)	对账关系  1本地与支付宝，2本地与微信，3本地与银联，4本地与miss
    private String 	errorCause	;//	ERROR_CAUSE	CHAR(1)	差错原因 1本地长宽，2本地短款
    private String 	tranNo	;//	TRAN_NO	VARCHAR2(64)	流水号
    private String 	tranType	;//	TRAN_TYPR	CHAR(6)	交易类型
    private String 	tranDate	;//	TRAN_DATE	CHAR(8)	交易日期
    private String 	tranTime	;//	TRAN_TIME	CHAR(6)	交易时间
    private String 	cardNo	;//	CARD_NO	VARCHAR2(19)	交易卡号
    private String 	merchantId	;//	MERCHNAT_ID	VARCHAR2(15)	商户号
    private String 	terminalNo	;//	TEMINAL_NO	VARCHAR2(15)	终端号
    private String 	terminalLsNo	;//	TEMINAL_LS_NO	VARCHAR2(15)	终端流水号
    private Double 	tranAmt	;//	TRAN_AMT	NUMBER(13,2)	交易金额
    private String 	batchNo	;//	BATCH_NO	VARCHAR2(15)	批次号
    private String 	operNo	;//	OPER_NO	VARCHAR2(15)	操作员号
    private String 	refundNo	;//	REFUND_NO	VARCHAR2(64)	退货单号
    private String 	authNo	;//	AUTH_NO	VARCHAR2(20)	授权码
    private String 	tranCode	;//	TRAN_CODE	VARCHAR2(15)	交易码
    private String 	referenceNo	;//	REFERENCE_NO	VARCHAR2(15)	参考号
    private String orgId;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTranSources() {
        return tranSources;
    }

    public void setTranSources(String tranSources) {
        this.tranSources = tranSources;
    }

    public String getAccountRelation() {
        return accountRelation;
    }

    public void setAccountRelation(String accountRelation) {
        this.accountRelation = accountRelation;
    }

    public String getErrorCause() {
        return errorCause;
    }

    public void setErrorCause(String errorCause) {
        this.errorCause = errorCause;
    }

    public String getTranNo() {
        return tranNo;
    }

    public void setTranNo(String tranNo) {
        this.tranNo = tranNo;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getTerminalLsNo() {
        return terminalLsNo;
    }

    public void setTerminalLsNo(String terminalLsNo) {
        this.terminalLsNo = terminalLsNo;
    }

    public Double getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(Double tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getOperNo() {
        return operNo;
    }

    public void setOperNo(String operNo) {
        this.operNo = operNo;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getAuthNo() {
        return authNo;
    }

    public void setAuthNo(String authNo) {
        this.authNo = authNo;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }
}
