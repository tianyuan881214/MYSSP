package com.yada.ssp.model;

import java.io.Serializable;

/**
 * @author xianyong
 * 支付宝对账文件分过的Model
 */
public class VAlpBocStl implements Serializable {
    private String businessBase;//业务名称
    private String merchantId;//char(15) // 商户号
    private String merchantCname;//varchar2(64) 商户名
    private String orderSumAmt;//varchar2(15) 交易金额总数
    private String serviceAmt;//varchar2(15) 支付宝收银行手续费合计
    private String netAmount;//varchar2(15) 支付宝清算至银行金额合计
    private String merFee;//varchar2(15) 银行净收益（总手续费-支付宝手续费）合计
    private String settleAmt;//varchar2(15) 银行清算至商户金额
    private String tranDate;//char(20) //交易日期
    private String name;                //所属机构
    private String merServiceAmt;//商户总付手续费

    public String getMerServiceAmt() {
        return merServiceAmt;
    }

    public void setMerServiceAmt(String merServiceAmt) {
        this.merServiceAmt = merServiceAmt;
    }

    public String getBusinessBase() {
        return businessBase;
    }

    public void setBusinessBase(String businessBase) {
        this.businessBase = businessBase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getmerchantId() {
        return merchantId;
    }

    public void setmerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantCname() {
        return merchantCname;
    }

    public void setMerchantCname(String merchantCname) {
        this.merchantCname = merchantCname;
    }

    public String getOrderSumAmt() {
        return orderSumAmt;
    }

    public void setOrderSumAmt(String orderSumAmt) {
        this.orderSumAmt = orderSumAmt;
    }

    public String getServiceAmt() {
        return serviceAmt;
    }

    public void setServiceAmt(String serviceAmt) {
        this.serviceAmt = serviceAmt;
    }

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    public String getMerFee() {
        return merFee;
    }

    public void setMerFee(String merFee) {
        this.merFee = merFee;
    }

    public String getSettleAmt() {
        return settleAmt;
    }

    public void setSettleAmt(String settleAmt) {
        this.settleAmt = settleAmt;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }
}
