package com.yada.ssp.model;

import scala.Serializable;

/**
 * Created by Administrator on 2017/9/12.
 */
public class MerchantSettleLs implements Serializable {
    public static final String MERCHANT_ID ="商户号";
    public static final String MERCHANT_CNAME ="商户名称";
    public static final String  WEB_FEE_SUM ="微信手续费";
    public static final String  ALIPAY_FEE_SUM = "支付宝手续费";
    public static final String  WEBCHAT_SUM = "微信清算金额";
    public static final String  ALIPAY_SUM = "支付宝清算金额";
    public static final String   FEE_SUM = "总手续费";
    public static final String  ALIPAY_WEBCHAT_SUM = "总清算金额";
    public static final String   SECOND_NAME = "二级机构";
    public static final String  FIRST_NAME = "所属机构";
    public static final String  ALIPAY_SETTLE_DATE = "支付宝清算时间";
    public static final String  WEBCHAT_SETTLE_DATE = "微信清算时间";

    private  String merchantId; //商户号
    private  String merchantCname;//商户名称
    private  Double aliFee; //支付宝手续费
    private  Double  wechatFee; //微信手续费
    private  Double aliWeTotal; // 总交易金额
    private Double aliTranAmt; // 支付宝交易金额
    private Double weTranAmt; // 微信交易金额
    private  int count; // 总交易数
    private  Double  aliWeFee; // 总手续费
    private  Double  othFee; // 他行分润
    private  Double  myFee; //我行分润
    private  Double  gsFee;//公司分润
    private  Double  settleFee;//清算金额
    private  String  firstNo;//所属机构号
    private  String  firstName;//所属机构名称
    private  String  secondNo; //二级机构号
    private  String  secondName;//二级机构名称
    private  String  accountNo; //入账账号
    private  String accountName;//账号名称
    private  String openingBank;//账号开户行
    private  String openingBankNo;//开户行行号

    public Double getAliTranAmt() {
        return aliTranAmt;
    }

    public void setAliTranAmt(Double aliTranAmt) {
        this.aliTranAmt = aliTranAmt;
    }

    public Double getWeTranAmt() {
        return weTranAmt;
    }

    public void setWeTranAmt(Double weTranAmt) {
        this.weTranAmt = weTranAmt;
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

    public Double getAliFee() {
        return aliFee;
    }

    public void setAliFee(Double aliFee) {
        this.aliFee = aliFee;
    }

    public Double getWechatFee() {
        return wechatFee;
    }

    public void setWechatFee(Double wechatFee) {
        this.wechatFee = wechatFee;
    }

    public Double getAliWeTotal() {
        return aliWeTotal;
    }

    public void setAliWeTotal(Double aliWeTotal) {
        this.aliWeTotal = aliWeTotal;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getAliWeFee() {
        return aliWeFee;
    }

    public void setAliWeFee(Double aliWeFee) {
        this.aliWeFee = aliWeFee;
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

    public Double getSettleFee() {
        return settleFee;
    }

    public void setSettleFee(Double settleFee) {
        this.settleFee = settleFee;
    }

    public String getFirstNo() {
        return firstNo;
    }

    public void setFirstNo(String firstNo) {
        this.firstNo = firstNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondNo() {
        return secondNo;
    }

    public void setSecondNo(String secondNo) {
        this.secondNo = secondNo;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank;
    }

    public String getOpeningBankNo() {
        return openingBankNo;
    }

    public void setOpeningBankNo(String openingBankNo) {
        this.openingBankNo = openingBankNo;
    }
}
