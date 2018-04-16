package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

import java.io.Serializable;

/**
 *
 */
public class LiquidationReportQuery extends BaseQuery implements Serializable{
    private String businessBase;//渠道类型
    private String orgId;//二级行机构号
    private String name;//二级行机构名称
    private String firstOrgId;//所属机构号
    private String firstName;//所属行名称
    private String totalAmount;//交易金额
    private String othRate;//他行分润百分比
    private String othFee;//他行分润金额
    private String gsRate;//公司分润百分比
    private String gsFee;//公司分润
    private String myFee;//本行分润金额

    private String tranDateTimeBegin;//开始日期
    private String tranDateTimeEnd;  //结束日期

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

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
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
