package com.yada.ssp.model;

import org.hibernate.cfg.beanvalidation.GroupsPerOperation;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/10.
 */
public class WebChatTranLs implements Serializable {
    private static final String  MERCHANT_NO="小商户号";
    private static final String  OUT_TRADE_NO="商户订单号";
    private static final String  OLD_BATCHNO="原批次号";
    private static final String  OLD_TRACENO="原终端流水号";
    private static final String  OLD_TRANDATE="原交易日期";
    private static final String  OLD_TRANTIME="原交易时间";
    private static final String  AUTH_CODE="支付授权码";
    private static final String  BATCH_NO="终端批次号";
    private static final String  MCH_ID="商户号";
    private static final String  MERCHANT_CNAME="商户名称";
    private static final String  STATE="入驻状态";
    private static final String  OPERATOR_ID="操作员号";
    private static final String  REFUND_FLAG="退货标识";
    private static final String  RESULT_CODE="业务结果";
    private static final String  RETURN_CODE="返回状态码";
    private static final String  TOTAL_AMOUNT="交易金额";
    private static final String  TRACE_NO="终端流水号";
    private static final String  TRAN_DATE="清算日期";
    private static final String  TRAN_TIME="清算时间";
    private static final String  TRAN_TYPE="交易类型";
    private static final String  TRANSACTION_ID="微信支付订单号";
    private static final String  FIRST_Name="所属机构";
    private static final String  SECOND_NAME = "二级机构";

    private String merchantNo;
    private String outTradeNo;
    private String oldbatchNo;
    private String oldtraceNo;
    private String oldTrandate;
    private String oldTrantime;
    private String authCode;
    private String batchNO;
    private String mchId;
    private String merchantCname;
    private String state;
    private String operatorId;
    private String refundFlag;
    private String resultCode;
    private String returnCode;
    private Double totalAmount;
    private String traceNo;
    private String tranDate;
    private String tranTime;
    private String tranType;
    private String transactionId;
    private String firstName;
    private String secondName;

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOldbatchNo() {
        return oldbatchNo;
    }

    public void setOldbatchNo(String oldbatchNo) {
        this.oldbatchNo = oldbatchNo;
    }

    public String getOldtraceNo() {
        return oldtraceNo;
    }

    public void setOldtraceNo(String oldtraceNo) {
        this.oldtraceNo = oldtraceNo;
    }

    public String getOldTrandate() {
        return oldTrandate;
    }

    public void setOldTrandate(String oldTrandate) {
        this.oldTrandate = oldTrandate;
    }

    public String getOldTrantime() {
        return oldTrantime;
    }

    public void setOldTrantime(String oldTrantime) {
        this.oldTrantime = oldTrantime;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getBatchNO() {
        return batchNO;
    }

    public void setBatchNO(String batchNO) {
        this.batchNO = batchNO;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMerchantCname() {
        return merchantCname;
    }

    public void setMerchantCname(String merchantCname) {
        this.merchantCname = merchantCname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
