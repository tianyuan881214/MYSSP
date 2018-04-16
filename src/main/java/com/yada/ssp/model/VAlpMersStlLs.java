package com.yada.ssp.model;

import java.io.Serializable;

/**
 * @author xianyong
 * 商户对账报表
 */
public class VAlpMersStlLs implements Serializable {
    private String merchantId;//商户号
    private String merchantCname;//商户名称
    private String terminalId;//终端号
    private String batchNo;//批次号
    private String oppositeId;//交易卡号
    private String tranDate;//交易日期
    private String tranTime;//交易时间
    private Double tranAmt;//交易金额
    private Double tranFee;//手续费
    private Double settleAmt;//结算金额
    private String authNo;//授权码
    private String tranCode;//交易码
    private String fqqs;//分期期数
    private String cardType;//卡别
    private String tradeNo;//参考码
    private String settleDate;//结算日期
    private String name;//机构名称
    private String accountNo;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantCname() {
        return merchantCname;
    }

    public void setMerchantCname(String merchantCname) {
        this.merchantCname = merchantCname;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getOppositeId() {
        return oppositeId;
    }

    public void setOppositeId(String oppositeId) {
        this.oppositeId = oppositeId;
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

    public Double getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(Double tranAmt) {
        this.tranAmt = tranAmt;
    }

    public Double getTranFee() {
        return tranFee;
    }

    public void setTranFee(Double tranFee) {
        this.tranFee = tranFee;
    }

    public Double getSettleAmt() {
        return settleAmt;
    }

    public void setSettleAmt(Double settleAmt) {
        this.settleAmt = settleAmt;
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

    public String getFqqs() {
        return fqqs;
    }

    public void setFqqs(String fqqs) {
        this.fqqs = fqqs;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
