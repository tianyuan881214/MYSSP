package com.yada.ssp.model;

/**
 * @author sun
 *         微信对账文件
 */
public class WebCheckFile {

    private String id;//
    private String merchantId;//商户号
    private String merchantName;
    private String tranTime;//TRAN_TIME 交易时间
    private String tranDate;
    private String appid;//APPID 公众号ID
    private String subMerchantID;//SUB_MERCHANT_ID 子商户号
    private String deviceNumber; // DEVICE_NUMBER 设备号
    private String transactionId; //TRANSACTION_ID  微信订单号
    private String outTradeNo;//OUT_TRADE_NO 商户订单号
    private String userFlag;//USER_FLAG 用户标识
    private String tranType;//TRAN_TYPE 付款类型
    private String tranStart;//TRAN_START   交易类型
    private String paymentBank;//PAYMENT_BANK 付款银行
    private String currencyCategory;//CURRENCY_CATEGORY 货币类型
    private String totalAmount;//TOTAL_AMOUNT 总金额
    private String enterpriseRedPackage;//ENTERPRISE_RED_PACKAGE  企业红包
    private String refundId;//REFUND_ID 微信退款ID
    private String outRefundId;//OUT_REFUND_ID 商户退款ID
    private String returndAmt;//RETURND_AMT 退款金额
    private String erpRedundAmt;//ERP_REFUND_AMT 企业红包退款
    private String refundType;//REFUND_TYPE 退款类型
    private String refundStart;//REFUND_START 退款状态
    private String goodsName;//GOODS_NAME 商品名称
    private String mcrchantDbPackage;//MCRCHANT_DB_PACKAGE 数据包
    private String fee;//FEE 手续费
    private String feeRate;//FEE_RATE 费率
    private String inOrg;
    private String bankServiceAmt;//银行收手续费
    private String bank_fee;//收取费率
    private String netMerAmt;
    private String netBankAmt;

    public String getNetBankAmt() {
        return netBankAmt;
    }

    public void setNetBankAmt(String netBankAmt) {
        this.netBankAmt = netBankAmt;
    }

    public String getNetMerAmt() {
        return netMerAmt;
    }

    public void setNetMerAmt(String netMerAmt) {
        this.netMerAmt = netMerAmt;
    }

    public String getBankServiceAmt() {
        return bankServiceAmt;
    }

    public void setBankServiceAmt(String bankServiceAmt) {
        this.bankServiceAmt = bankServiceAmt;
    }

    public String getBank_fee() {
        return bank_fee;
    }

    public void setBank_fee(String bank_fee) {
        this.bank_fee = bank_fee;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getInOrg() {
        return inOrg;
    }

    public void setInOrg(String inOrg) {
        this.inOrg = inOrg;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTranTime() {
        return tranTime;
    }

    public void setTranTime(String tranTime) {
        this.tranTime = tranTime;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getSubMerchantID() {
        return subMerchantID;
    }

    public void setSubMerchantID(String subMerchantID) {
        this.subMerchantID = subMerchantID;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getTranStart() {
        return tranStart;
    }

    public void setTranStart(String tranStart) {
        this.tranStart = tranStart;
    }

    public String getPaymentBank() {
        return paymentBank;
    }

    public void setPaymentBank(String paymentBank) {
        this.paymentBank = paymentBank;
    }

    public String getCurrencyCategory() {
        return currencyCategory;
    }

    public void setCurrencyCategory(String currencyCategory) {
        this.currencyCategory = currencyCategory;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getEnterpriseRedPackage() {
        return enterpriseRedPackage;
    }

    public void setEnterpriseRedPackage(String enterpriseRedPackage) {
        this.enterpriseRedPackage = enterpriseRedPackage;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getOutRefundId() {
        return outRefundId;
    }

    public void setOutRefundId(String outRefundId) {
        this.outRefundId = outRefundId;
    }

    public String getReturndAmt() {
        return returndAmt;
    }

    public void setReturndAmt(String returndAmt) {
        this.returndAmt = returndAmt;
    }

    public String getErpRedundAmt() {
        return erpRedundAmt;
    }

    public void setErpRedundAmt(String erpRedundAmt) {
        this.erpRedundAmt = erpRedundAmt;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }

    public String getRefundStart() {
        return refundStart;
    }

    public void setRefundStart(String refundStart) {
        this.refundStart = refundStart;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getMcrchantDbPackage() {
        return mcrchantDbPackage;
    }

    public void setMcrchantDbPackage(String mcrchantDbPackage) {
        this.mcrchantDbPackage = mcrchantDbPackage;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(String feeRate) {
        this.feeRate = feeRate;
    }
}