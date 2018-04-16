package com.yada.ssp.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/9.
 */
public class WebChatSettleLs implements Serializable {
    private static final String  merchant_id = "商户号";
    private static final String  merchant_cname= "商户名称";
    private static final String  first_Name= "所属机构";
    private static final String  second_Name= "二级机构";
    private static final String  out_trade_no= "商户订单号 ";
    private static final String  transaction_id = "微信订单号 ";
    private static final String  tran_type= "业务类型 ";
    private static final String  TOTAL_AMOUNT= "订单金额";
    private static final String  FEE= "商户手续费";
    private static final String  FEE_RATE= "商户扣率";
    private static final String  my_fee= "我行分润";
    private static final String  my_rate= "我行分润占比";
    private static final String  oth_fee= "他行分润占比";
    private static final String  oth_rate= "他行分润";
    private static final String  gs_rate= "公司分润占比";
    private static final String  gs_fee= "公司分润";
    private static final String  settle_date= "清算时间";

    private String merchantId;  //商户号
    private String merchantCname; //商户名称
    private String subMerchantId; //微信商户号
    private String  outTradeNo; //微信订单号
    private String firsetName;  //所属机构
    private String secondName;  //二级机构
    private String tranStart;  // 交易状态
    private double totalAmount;  //交易金额
    private double amountFee;  //总手续费
    private double settleFee ; //结算金额
    private double webFee;  //微信手续费
    private double feeRate;  //微信扣率
    private double myFee;   //我行分润
    private double othFee; //其它分行分润
    private double gsFee;  //公司分润
    private String accountType; //账号类型
    private String tranDate;  //交易时间
    private String  settleDate ; //清算时间

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

    public String getSubMerchantId() {
        return subMerchantId;
    }

    public void setSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getFirsetName() {
        return firsetName;
    }

    public void setFirsetName(String firsetName) {
        this.firsetName = firsetName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getTranStart() {
        return tranStart;
    }

    public void setTranStart(String tranStart) {
        this.tranStart = tranStart;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getAmountFee() {
        return amountFee;
    }

    public void setAmountFee(double amountFee) {
        this.amountFee = amountFee;
    }

    public double getSettleFee() {
        return settleFee;
    }

    public void setSettleFee(double settleFee) {
        this.settleFee = settleFee;
    }

    public double getWebFee() {
        return webFee;
    }

    public void setWebFee(double webFee) {
        this.webFee = webFee;
    }

    public double getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(double feeRate) {
        this.feeRate = feeRate;
    }

    public double getMyFee() {
        return myFee;
    }

    public void setMyFee(double myFee) {
        this.myFee = myFee;
    }

    public double getOthFee() {
        return othFee;
    }

    public void setOthFee(double othFee) {
        this.othFee = othFee;
    }

    public double getGsFee() {
        return gsFee;
    }

    public void setGsFee(double gsFee) {
        this.gsFee = gsFee;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }
}
