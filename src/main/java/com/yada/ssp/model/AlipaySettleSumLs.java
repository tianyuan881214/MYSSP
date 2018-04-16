package com.yada.ssp.model;

import java.io.Serializable;

/**
 * @author xianyong
 */
public class AlipaySettleSumLs implements Serializable{

    private String  businessBase;//业务渠道
    private String 	storeId	;//	门店编号
    private String 	storeName	;//	门店名称
    private String 	orderSumAmt	;//	订单金额
    private String 	merchantSettleAmt	;//	商家实收
    private String 	alpFavourable	;//	支付宝优惠
    private String 	serviceAmt	;//	服务费
    private String 	netAmount	;//	实收净额
    private String 	settleDate	;//	结算日期
    private String  inOrg;
    private String  orgId;
    private String  pOrgId;

    public String getBusinessBase() {
        return businessBase;
    }

    public void setBusinessBase(String businessBase) {
        this.businessBase = businessBase;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOrderSumAmt() {
        return orderSumAmt;
    }

    public void setOrderSumAmt(String orderSumAmt) {
        this.orderSumAmt = orderSumAmt;
    }

    public String getMerchantSettleAmt() {
        return merchantSettleAmt;
    }

    public void setMerchantSettleAmt(String merchantSettleAmt) {
        this.merchantSettleAmt = merchantSettleAmt;
    }

    public String getAlpFavourable() {
        return alpFavourable;
    }

    public void setAlpFavourable(String alpFavourable) {
        this.alpFavourable = alpFavourable;
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

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getInOrg() {
        return inOrg;
    }

    public void setInOrg(String inOrg) {
        this.inOrg = inOrg;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getpOrgId() {
        return pOrgId;
    }

    public void setpOrgId(String pOrgId) {
        this.pOrgId = pOrgId;
    }
}
