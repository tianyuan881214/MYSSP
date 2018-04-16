package com.yada.ssp.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/7.
 */
public class UnionSettleLs implements Serializable{
    private static final String ORDER_ID = "商户订单号";
    private static final String ACC_TYPE = "账号类型";
    private static final String BILL_NO = "账单号码";
    private static final String BILL_TYPE = "账单类型";
    private static final String BIZ_TYPE= "业务类型";
    private static final String DISCOUNT_AMT= "优惠金额";
    private static final String INTERACT_MODE= "交互方式";
    private static final String LIQUIDATION_AMT= "清算净额";
    private static final String LIQUIDATION_TIME= "清算日期";
    private static final String  MER_CAT_CODE= "商户代码";
    private static final String MERCHANT_FEE= "商户手续费";
    private static final String SETTLEMENT_AMT= "结算金额";
    private static final String OLD_TXN_TIME= "原始交易日期时间";
    private static final String QUERY_ID= "查询流水号";
    private static final String ORIG_QRY_ID= "原交易查询流水号";
    private static final String TERM_ID= "终端号";

    private static final String OTH_FEE= "他行手续费";
    private static final String MY_FEE= "本行手续费";
    private static final String GS_FEE= "公司手续费";
    private static final String AMOUNT_FEE= "总手续费";
    private static final String IS_OTH_ACCOUNT= "是否本行";

    private static final String LS_ID= "表id";
    private static final String MERCHANT_CNAME= "商户名称";
    private static final String Name= "机构名称";
    private static final String MERCHANT_ID= "商户号";

    private String orderId;//商户订单号  ORDER_ID
    private String accType;//账号类型 ACC_TYPE
    private String billNo;//账单号码 BILL_NO
    private String billType;//账单类型 BILL_TYPE
    private String bizType;//业务类型 BIZ_TYPE
    private String discountAmt;//优惠金额 DISCOUNT_AMT
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
    private String name;//机构名称
    private String merchantId;//商户号

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

    public String getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(String discountAmt) {
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
