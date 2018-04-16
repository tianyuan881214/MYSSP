package com.yada.ssp.model;

import com.microsoft.schemas.office.office.STInsetMode;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/10.
 */
public class AlipayTranLs implements Serializable {
    private static final String MERCHANT_ID = "商户号";
    private static final String OUT_TRADE_NO = "商户订单号";
    private static final String  MERCHANT_CNAME = "商户名称";
    private static final String TOTAL_AMOUNT = "交易金额";
    private static final String BATCH_NO = "终端批次号";
    private static final String TRACE_NO = "终端流水号";
    private static final String TRAN_TYPE = "交易类型";
    private static final String STATE = "入驻状态";
    private static final String OPERATOR_ID = "操作员号";
    private static final String REFUND_FLAG = "退货标识";
    private static final String TRAN_DATE = "交易日期";
    private static final String TRAN_TIME = "交易时间";
    private static final String FIRST_Name = "所属机构";
    private static final String SECOND_NAME = "二级机构";
    private String merchantId;
    private String outTradeNo;
    private String merchantCname;
    private Double totalAmount;
    private String batchNo;
    private String traceNo;
    private String tranType;
    private String state;
    private String operatorId;
    private String refundFlag;
    private String tranDate;
    private String tranTime;
    private String firstName;
    private String secondName;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getMerchantCname() {
        return merchantCname;
    }

    public void setMerchantCname(String merchantCname) {
        this.merchantCname = merchantCname;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
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
