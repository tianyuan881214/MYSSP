package com.yada.ssp.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/5.
 */
public class UnionMerchantBase implements Serializable {
    public static final String ALIAS_MERCHANT_ID="商户号";
    public static final String ALIAS_UNION_NAME="商户名称";
    public static final String ALIAS_MERCHANT_SHORTNAME="商户简称";
    public static final String ALIAS_SERVICE_PHONR="客服电话";
    public static final String ALIAS_CONTACT="联系人";
    public static final String ALIAS_CONTANT_PHONE="联系人电话";
    public static final String ALIAS_CONTACT_EAMIL="联系人邮箱";
    public static final String ALIAS_UNION_REMARK="商户备注";
    public static final String ALIAS_UNION_SUB_MCH_ID="子商户号";

    private String merchantId;//建档商户号，主键
    private String unionName   ;//商户名称
    private String merchantShortname;//商户简称
    private String servicePhonr;//客服电话
    private String contact;//联系人
    private String contactPhone ;//联系人电话
    private String contactEmail;//联系人邮箱
    private String unionRemark;//商户备注，建议直接用商户号
    private String unionSubmchid;//子商户号


    public UnionMerchantBase(String merchantId, String unionName, String merchantShortname, String servicePhonr, String contact, String contactPhone, String contactEmail, String channelId, String business, String unionRemark, String unionSubmchid) {
        this.merchantId = merchantId;
        this.unionName = unionName;
        this.merchantShortname = merchantShortname;
        this.servicePhonr = servicePhonr;
        this.contact = contact;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.unionRemark = unionRemark;
        this.unionSubmchid = unionSubmchid;
    }

    public UnionMerchantBase() {
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getUnionName() {
        return unionName;
    }

    public void setUnionName(String unionName) {
        this.unionName = unionName;
    }

    public String getMerchantShortname() {
        return merchantShortname;
    }

    public void setMerchantShortname(String merchantShortname) {
        this.merchantShortname = merchantShortname;
    }

    public String getServicePhonr() {
        return servicePhonr;
    }

    public void setServicePhonr(String servicePhonr) {
        this.servicePhonr = servicePhonr;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }


    public String getUnionRemark() {
        return unionRemark;
    }

    public void setUnionRemark(String unionRemark) {
        this.unionRemark = unionRemark;
    }

    public String getUnionSubmchid() {
        return unionSubmchid;
    }

    public void setUnionSubmchid(String unionSubmchid) {
        this.unionSubmchid = unionSubmchid;
    }

    @Override
    public String toString() {
        return "UnionMerchantBase{" +
                "merchantId='" + merchantId + '\'' +
                ", unionName='" + unionName + '\'' +
                ", merchantShortname='" + merchantShortname + '\'' +
                ", servicePhonr='" + servicePhonr + '\'' +
                ", contact='" + contact + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", unionRemark='" + unionRemark + '\'' +
                ", unionSubmchid='" + unionSubmchid + '\'' +
                '}';
    }
}
