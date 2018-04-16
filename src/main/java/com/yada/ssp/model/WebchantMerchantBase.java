package com.yada.ssp.model;

import javax.persistence.*;
import java.io.Serializable;


public class WebchantMerchantBase implements Serializable {
    private static final long serialVersionUID = 297308760237832236L;
    private String issh;
    private String merchant_id;//        CHAR(15) not null,
    private String merchant_name;//      VARCHAR2(100) not null,
    private String merchant_shortname;// VARCHAR2(40) not null,
    private String service_phonr;//      VARCHAR2(20) not null,
    private String contact;//            VARCHAR2(10),
    private String contact_phone;//      VARCHAR2(11),
    private String  contact_email;//      VARCHAR2(30),
    private String channel_id;//         VARCHAR2(32) not null,
    private String  business;//           VARCHAR2(10) not null,
    private String merchant_remark;//    VARCHAR2(20) not null,
    private String sub_mch_id;//         VARCHAR2(32) not null

    public String getIssh() {
        return issh;
    }

    public void setIssh(String issh) {
        this.issh = issh;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public String getMerchant_shortname() {
        return merchant_shortname;
    }

    public void setMerchant_shortname(String merchant_shortname) {
        this.merchant_shortname = merchant_shortname;
    }

    public String getService_phonr() {
        return service_phonr;
    }

    public void setService_phonr(String service_phonr) {
        this.service_phonr = service_phonr;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getMerchant_remark() {
        return merchant_remark;
    }

    public void setMerchant_remark(String merchant_remark) {
        this.merchant_remark = merchant_remark;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    @Override
    public String toString() {
        return "WebchantMerchantBase{" +
                "issh='" + issh + '\'' +
                ", merchant_id='" + merchant_id + '\'' +
                ", merchant_name='" + merchant_name + '\'' +
                ", merchant_shortname='" + merchant_shortname + '\'' +
                ", service_phonr='" + service_phonr + '\'' +
                ", contact='" + contact + '\'' +
                ", contact_phone='" + contact_phone + '\'' +
                ", contact_email='" + contact_email + '\'' +
                ", channel_id='" + channel_id + '\'' +
                ", business='" + business + '\'' +
                ", merchant_remark='" + merchant_remark + '\'' +
                ", sub_mch_id='" + sub_mch_id + '\'' +
                '}';
    }
}
