package com.yada.ssp.model;

import java.io.Serializable;

/**
 * @author xianyong
 */
public class VAlpBocStlD implements Serializable {
    private String businessBase;
    private String merchantId;//char(15)
    private String merchantCname;//varchar2(64)
    private Double orderSumAmt;//varchar2(15)
    private Double serviceAmt;//varchar2(15)
    private Double netAmount;//varchar2(15)
    private Double merFee;//varchar2(15)
    private Double settleAmt;//varchar2(15)
    private String tranDate;//char(20)
    private String name;
    private Double merServiceAmt;

    public Double getMerServiceAmt() {
        return merServiceAmt;
    }

    public void setMerServiceAmt(Double merServiceAmt) {
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

    public String getMerchantCname() {
        return merchantCname;
    }

    public void setMerchantCname(String merchantCname) {
        this.merchantCname = merchantCname;
    }

    public Double getOrderSumAmt() {
        return orderSumAmt;
    }

    public void setOrderSumAmt(Double orderSumAmt) {
        this.orderSumAmt = orderSumAmt;
    }

    public Double getServiceAmt() {
        return serviceAmt;
    }

    public void setServiceAmt(Double serviceAmt) {
        this.serviceAmt = serviceAmt;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }

    public Double getMerFee() {
        return merFee;
    }

    public void setMerFee(Double merFee) {
        this.merFee = merFee;
    }

    public Double getSettleAmt() {
        return settleAmt;
    }

    public void setSettleAmt(Double settleAmt) {
        this.settleAmt = settleAmt;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }
}
