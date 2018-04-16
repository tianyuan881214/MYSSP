package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/9.
 */
public class WebChatSettleLsQuery extends BaseQuery implements Serializable{
    private String merchantId;
    private String merchantCname;
    private String firstName;
    private String secondName;
    private String outTradeNo;
    private String transactionId;
    private String tranType;
    private Double totalAmount;
    private Double fee;
    private Double feeRate;
    private Double myFee;
    private Double myRate;
    private Double othFee;
    private Double othRate;
    private Double gsRate;
    private Double gsFee;

    private String subMchId;
    private String orgId;

    private String finishDateTimeBegin;
    private String finishDateTimeEnd;

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

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo ;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(Double feeRate) {
        this.feeRate = feeRate;
    }

    public Double getMyFee() {
        return myFee;
    }

    public void setMyFee(Double myFee) {
        this.myFee = myFee;
    }

    public Double getMyRate() {
        return myRate;
    }

    public void setMyRate(Double myRate) {
        this.myRate = myRate;
    }

    public Double getOthFee() {
        return othFee;
    }

    public void setOthFee(Double othFee) {
        this.othFee = othFee;
    }

    public Double getOthRate() {
        return othRate;
    }

    public void setOthRate(Double othRate) {
        this.othRate = othRate;
    }

    public Double getGsRate() {
        return gsRate;
    }

    public void setGsRate(Double gsRate) {
        this.gsRate = gsRate;
    }

    public Double getGsFee() {
        return gsFee;
    }

    public void setGsFee(Double gsFee) {
        this.gsFee = gsFee;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getFinishDateTimeBegin() {
        return finishDateTimeBegin;
    }

    public void setFinishDateTimeBegin(String finishDateTimeBegin) {
        this.finishDateTimeBegin = finishDateTimeBegin;
    }

    public String getFinishDateTimeEnd() {
        return finishDateTimeEnd;
    }

    public void setFinishDateTimeEnd(String finishDateTimeEnd) {
        this.finishDateTimeEnd = finishDateTimeEnd;
    }
}
