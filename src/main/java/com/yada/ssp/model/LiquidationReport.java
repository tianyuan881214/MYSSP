/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.model;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class LiquidationReport implements java.io.Serializable {

    private String businessBase;//渠道类型
    private String orgId;//二级行机构号
    private String name;//二级行机构名称
    private String tCount;  // 总交易笔数
    private String totalAmount;//总交易金额
    private String amountFee;  //总手续费
    private String fee;  //服务费
    private String othFee;//他行分润金额
    private String gsFee;//公司分润
    private String myFee;//本行分润金额

    private String firstOrgId;//所属机构号
    private String firstName;//所属行名称
    private String othRate;//他行分润百分比
    private String gsRate;//公司分润百分比


    public String gettCount() {
        return tCount;
    }

    public void settCount(String tCount) {
        this.tCount = tCount;
    }

    public String getAmountFee() {
        return amountFee;
    }

    public void setAmountFee(String amountFee) {
        this.amountFee = amountFee;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String tranDate;

    public String getFirstOrgId() {
        return firstOrgId;
    }

    public void setFirstOrgId(String firstOrgId) {
        this.firstOrgId = firstOrgId;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
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

    public String getOthRate() {
        return othRate;
    }

    public void setOthRate(String othRate) {
        this.othRate = othRate;
    }

    public String getOthFee() {
        return othFee;
    }

    public void setOthFee(String othFee) {
        this.othFee = othFee;
    }

    public String getGsRate() {
        return gsRate;
    }

    public void setGsRate(String gsRate) {
        this.gsRate = gsRate;
    }

    public String getGsFee() {
        return gsFee;
    }

    public void setGsFee(String gsFee) {
        this.gsFee = gsFee;
    }

    public String getMyFee() {
        return myFee;
    }

    public void setMyFee(String myFee) {
        this.myFee = myFee;
    }

}

