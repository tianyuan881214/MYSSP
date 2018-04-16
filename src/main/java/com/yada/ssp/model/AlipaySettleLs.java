package com.yada.ssp.model;

import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/9.
 */
public class AlipaySettleLs implements Serializable {
    private static final String  merchant_id = "商户号";
    private static final String  merchant_cname= "商户名称";
    private static final String  first_Name= "所属机构";
    private static final String  second_Name= "二级机构";
    private static final String  out_trade_no= "商户订单号 ";
    private static final String  trade_no= "支付宝交易号 ";
    private static final String  tran_type= "业务类型 ";
    private static final String  order_amount= "订单金额";
    private static final String  service_charge= "服务费";
    private static final String  amount_rate= "商户扣率";
    private static final String  amount_fee= "商户手续费";
    private static final String  my_fee= "我行分润";
    private static final String  oth_fee= "他行分润占比";
    private static final String  oth_rate= "他行分润";
    private static final String  gs_rate= "公司分润占比";
    private static final String  gs_fee= "公司分润";
    private static final String  settle_date= "清算时间";
    private static final String  STATE= "清算时间";
    private static final String  SCAN_TYPE= "清算时间";
    private static final String  ACCOUNT_TYPE= "账号类型";


    private String merchantId;  //商户名称
    private String merchantCname; //商户名称
    private String storeId; //支付宝商户号
    private String outTradeNo; //支付宝订单号
    private String firsetName; //所属机构
    private String secondName; //二级机构
    private double orderAmout; //交易金额
    private double amountFee;  //总手续费
    private double settleAmount; //清算金额
    private double serviceCharge; //支付宝服务费
    private double myFee; //本行分润
    private double othFee; //其他分行分润
    private double gsFee; //公司分润
    private String accountType;//账号类型
    private String finishDate; //交易时间
    private  String settleDate; //清算时间

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
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

    public double getOrderAmout() {
        return orderAmout;
    }

    public void setOrderAmout(double orderAmout) {
        this.orderAmout = orderAmout;
    }

    public double getAmountFee() {
        return amountFee;
    }

    public void setAmountFee(double amountFee) {
        this.amountFee = amountFee;
    }

    public double getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(double settleAmount) {
        this.settleAmount = settleAmount;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
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

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }
}
