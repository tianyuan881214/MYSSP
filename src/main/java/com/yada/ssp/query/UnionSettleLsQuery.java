package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/7.
 */
public class UnionSettleLsQuery extends BaseQuery implements Serializable {
        private String tranDateTimeBegin;
        private String tranDateTimeEnd;
        private String orgId;
        private String orderId;//商户订单号  ORDER_ID
        private String accType;//账号类型 ACC_TYPE
        private String billNo;//账单号码 BILL_NO
        private String billType;//账单类型 BILL_TYPE
        private String bizType;//业务类型 BIZ_TYPE
        private Double discountAmt;//优惠金额 DISCOUNT_AMT
        private String interactMode;//交互方式 INTERACT_MODE

        private Double liquindationAmt;//清算净额 LIQUIDATION_AMT
        private String liquidationTime;// 清算日期 LIQUIDATION_TIME
        private String mercatCode;//MER_CAT_CODE  商户代码
        private Double merchantFee;//MERCHANT_FEE 商户手续费
        private Double settleementAmt;//SETTLEMENT_AMT 结算金额
        private String oldTxnTime;//OLD_TXN_TIME 原始交易日期时间

        private String queryId;//QUERY_ID  查询流水号
        private String origQryId;//ORIG_QRY_ID  原交易查询流水号
        private String termId;//TERM_ID 终端号

        private Double  othFee;//他行手续费 OTH_FEE
        private Double  myFee;//本行手续费 MY_FEE
        private Double gsFee;//公司手续费 GS_FEE
        private Double amoutFee;//总手续费 AMOUNT_FEE
        private String isOthAccount;//银行类别（是否本行） IS_OTH_ACCOUNT


        private String lsID;//表id
        private String merchantCname;//商户名称
        private String name;//所属机构
        private String merchantId;//商户号

    public String getTranDateTimeBegin() {
        return tranDateTimeBegin;
    }

    public void setTranDateTimeBegin(String tranDateTimeBegin) {
        this.tranDateTimeBegin = tranDateTimeBegin;
    }

    public String getTranDateTimeEnd() {
        return tranDateTimeEnd;
    }

    public void setTranDateTimeEnd(String tranDateTimeEnd) {
        this.tranDateTimeEnd = tranDateTimeEnd;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Double getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(Double discountAmt) {
        this.discountAmt = discountAmt;
    }

    public String getInteractMode() {
        return interactMode;
    }

    public void setInteractMode(String interactMode) {
        this.interactMode = interactMode;
    }

    public Double getLiquindationAmt() {
        return liquindationAmt;
    }

    public void setLiquindationAmt(Double liquindationAmt) {
        this.liquindationAmt = liquindationAmt;
    }

    public String getLiquidationTime() {
        return liquidationTime;
    }

    public void setLiquidationTime(String liquidationTime) {
        this.liquidationTime = liquidationTime;
    }

    public String getMercatCode() {
        return mercatCode;
    }

    public void setMercatCode(String mercatCode) {
        this.mercatCode = mercatCode;
    }

    public Double getMerchantFee() {
        return merchantFee;
    }

    public void setMerchantFee(Double merchantFee) {
        this.merchantFee = merchantFee;
    }

    public Double getSettleementAmt() {
        return settleementAmt;
    }

    public void setSettleementAmt(Double settleementAmt) {
        this.settleementAmt = settleementAmt;
    }

    public String getOldTxnTime() {
        return oldTxnTime;
    }

    public void setOldTxnTime(String oldTxnTime) {
        this.oldTxnTime = oldTxnTime;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getOrigQryId() {
        return origQryId;
    }

    public void setOrigQryId(String origQryId) {
        this.origQryId = origQryId;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public Double getOthFee() {
        return othFee;
    }

    public void setOthFee(Double othFee) {
        this.othFee = othFee;
    }

    public Double getMyFee() {
        return myFee;
    }

    public void setMyFee(Double myFee) {
        this.myFee = myFee;
    }

    public Double getGsFee() {
        return gsFee;
    }

    public void setGsFee(Double gsFee) {
        this.gsFee = gsFee;
    }

    public Double getAmoutFee() {
        return amoutFee;
    }

    public void setAmoutFee(Double amoutFee) {
        this.amoutFee = amoutFee;
    }

    public String getIsOthAccount() {
        return isOthAccount;
    }

    public void setIsOthAccount(String isOthAccount) {
        this.isOthAccount = isOthAccount;
    }

    public String getLsID() {
        return lsID;
    }

    public void setLsID(String lsID) {
        this.lsID = lsID;
    }

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

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
}
