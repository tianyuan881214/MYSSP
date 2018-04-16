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


public class MerchantBaseSon extends MerchantBase implements java.io.Serializable {

    private static final long serialVersionUID = -4915578671918958563L;
    /*public static final String MERCHANT_ID = "商户号";
    public static final String ACCOUNT_NO = "入账账号";//	VARCHAR2(25)	Y
    public static final String ACCOUNT_NAME = "账号名称";//	VARCHAR2(64)	Y
    public static final String OPENING_BANK = "账号开户行";//	VARCHAR2(64)	Y
    public static final String OPENING_BANK_NO = "开户行行号";//	VARCHAR2(25)	Y
    public static final String CARDHOLDER_NAME = "户主姓名";//	VARCHAR2(25)	Y
    public static final String CARDHOLDER_MOVEIPHONE = "户主手机";//	VARCHAR2(25)	Y
    public static final String CARDHOLDER_TELEPHONE = "户主电话";//	VARCHAR2(25)	Y
    public static final String ADDRESS_CHN = "户主中文地址";
    public static final String ADDRESS_ENG = "户主英文地址";
    public static final String POST_CODE = "户主邮编";
    public static final String FAX = "户主传真";
    public static final String MER_GRP_ID = "所属组";//	VARCHAR2(6)	Y
    public static final String SETTLED_STATUS = "入驻支付宝结果";
    public static final String CATEGORY_ID = "受理商户经营类目";//	VARCHAR2(6)	Y*/


    private String merchantId;//15 商户ID
    private String accountNo;//19 入账账户
    private String accountName;//64 账户名称
    private String openingBank;//64 账户开户行
    private String openingBankNo;//开户行行号 25
    private String openingBankAddress;//开户行地址 64
    private String cardHolderName;//账户所属人/机构 64
    private String merGrpId;//所属组 6
    private String cardHolderMobile;//账号所属人/机构手机 11
    private String cardHolderTelephone;//账号所属人/机构电话 11
    private String cardHolderAddressChn;//账号所属人/机构中文地址 64
    private String addressEng;//账号所属人/机构英文地址 64
    private String fax;//账号所属人/机构传真 11
    private String postCode;//账号所属人/机构邮编 6
    private String email;//账号所属人/机构邮箱 40
    private String idCard;//账号所属人身份证号 18
    private String businessLicense;//营业执照编号 20
    private String memo;//备注信息 40
    private String categoryId;

    private String contactName;//联系人姓名
    private String contactType;//联系人类型
    private String cardNo;//银行卡号
    private String cardName;//持卡人
    private String businessLicenseType;//营业执照类型
    private String provinceCode;
    private String cityCode;
    private String districtCode;

    private String merchantLevel;

    public String getMerchantLevel() {
        return merchantLevel;
    }

    public void setMerchantLevel(String merchantLevel) {
        this.merchantLevel = merchantLevel;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getBusinessLicenseType() {
        return businessLicenseType;
    }

    public void setBusinessLicenseType(String businessLicenseType) {
        this.businessLicenseType = businessLicenseType;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String getMerchantId() {
        return merchantId;
    }

    @Override
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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

    public String getOpeningBankAddress() {
        return openingBankAddress;
    }

    public void setOpeningBankAddress(String openingBankAddress) {
        this.openingBankAddress = openingBankAddress;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getMerGrpId() {
        return merGrpId;
    }

    public void setMerGrpId(String merGrpId) {
        this.merGrpId = merGrpId;
    }

    public String getCardHolderMobile() {
        return cardHolderMobile;
    }

    public void setCardHolderMobile(String cardHolderMobile) {
        this.cardHolderMobile = cardHolderMobile;
    }

    public String getCardHolderTelephone() {
        return cardHolderTelephone;
    }

    public void setCardHolderTelephone(String cardHolderTelephone) {
        this.cardHolderTelephone = cardHolderTelephone;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCardHolderAddressChn() {
        return cardHolderAddressChn;
    }

    public void setCardHolderAddressChn(String cardHolderAddressChn) {
        this.cardHolderAddressChn = cardHolderAddressChn;
    }

    @Override
    public String getAddressEng() {
        return addressEng;
    }

    @Override
    public void setAddressEng(String addressEng) {
        this.addressEng = addressEng;
    }

    @Override
    public String getFax() {
        return fax;
    }

    @Override
    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public String getPostCode() {
        return postCode;
    }

    @Override
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}

