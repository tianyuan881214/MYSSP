package com.yada.ssp.model;

/**
 * @author xianyong
 *         入驻支付宝
 */
public class EnterAiliMerchant {

    /*public static final String EXTERNAL_ID="受理商户编号";
    public static final String NAME="受理商户名称";
    public static final String ALIAS_NAME="受理商户简称";
    public static final String SERVICE_PHONE="受理商户客服电话";
    public static final String CONTACT_NAME="受理商户联系人名称";
    public static final String CONTACT_PHONE="受理商户联系人电话";
    public static final String CONTACT_MOBILE="受理商户联系人手机";
    public static final String CATEGORY_ID="受理商户经营类目";
    public static final String SOURCE="受理商户来源机构标识";
    public static final String BUSINESS_LICENSE="受理商户营业执照编号";
    public static final String ID_CARD="受理商户身份证编号";
    public static final String SUB_MERCHANT_ID="支付宝内唯一商户编号";
    public static final String FEE="手续费";
    public static final String LOCK_MODE="账号是否可用";
    public static final String OPER_NO="更新操作员号";
    public static final String UP_SELECT="上送选项";
    public static final String UPDATE_DATE="更新日期";
    public static final String UPDATE_TIME="更新时间";*/


private String issh;
    /**
     * length 15 受理商户编号
     */
    private String external_id;
    /**
     * length 128 受理商户经营类目
     */
    private String category_id;
    /**
     * length 20 受理商户来源机构标识
     */
    private String source;
    /**
     * length 11 支付宝内的唯一标识
     */
    private String sub_merchant_id;
    /**
     * length 6 上送选项
     */
    private String up_select;

    private String name;

    private String alias_name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias_name() {
        return alias_name;
    }

    public void setAlias_name(String alias_name) {
        this.alias_name = alias_name;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSub_merchant_id() {
        return sub_merchant_id;
    }

    public void setSub_merchant_id(String sub_merchant_id) {
        this.sub_merchant_id = sub_merchant_id;
    }

    public String getUp_select() {
        return up_select;
    }

    public void setUp_select(String up_select) {
        this.up_select = up_select;
    }

    public String getIssh() {
        return issh;
    }

    public void setIssh(String issh) {
        this.issh = issh;
    }
/**
     * length 128 受理商户名称
     *//*
    private String name;
    *//**
     * length 64 受理商户简称
     *//*
    private String alias_name;
    *//**
     * length 64 受理商户客服电话
     *//*
    private String service_phone;
    *//**
     * length 64 受理商户联系人名称
     *//*
    private String contact_name;
    *//**
     * length 64 受理商户联系人电话
     *//*
    private String contact_phone;
    *//**
     * length 64 受理商户联系人手机
     *//*
    private String contact_mobile;



    *//**
     * length 20 受理商户营业执照
     *//*
    private String business_license;
    *//**
     * length 20 受理商户身份证编号
     *//*
    private String id_card;


    *//**
     * length 6 手续费
     *//*
    private String fee;
    *//**
     * length 1 账号是否可用
     *//*
    private String lock_mode;
    *//**
     * length 20 更新操作员号
     *//*
    private String oper_no;

    *//**
     * length 8 更新日期
     *//*
    private String update_date;
    *//**
     * length 6 更新时间
     *//*
    private String update_time;*/


}
