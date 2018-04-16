package com.yada.ssp.model;

import java.io.Serializable;

/**
 * @author xianyong
 */
public class MerchantGrpLs implements Serializable {

    private String 	merGrpId	;//	CHAR(15 BYTE)	MER_GRP_ID	商户分组ID
    private String 	merGrpName	;//	VARCHAR2(64 BYTE)	MER_GRP_NAME	分组名称
    private String 	merchantName	;//	VARCHAR2(40 BYTE)	MERCHANT_CNAME	中文全称
    private String 	abbrName	;//	VARCHAR2(10 BYTE)	ABBR_CNAME	中文简称
    private String 	addressChn	;//	VARCHAR2(30 BYTE)	ADDRESS_CHN	中文地址
    private String 	cityName	;//	VARCHAR2(30 BYTE)	CITY_CNAME	所在城市中文名
    private String 	telephone	;//	VARCHAR2(12 BYTE)	TELEPHONE	电话号码
    private String 	postCode	;//	CHAR(6 BYTE)	POST_CODE	邮编
    private String 	fax	;//	VARCHAR2(12 BYTE)	FAX	传真
    private String 	manager	;//	VARCHAR2(8 BYTE)	MANAGER	联系人姓名
    private String 	zbank	;//	VARCHAR2(11 BYTE)	ZBANK	所属机构
    private String 	lockMode	;//	CHAR(1 BYTE)	LOCK_MODE	锁标示
    private String 	settleMode	;//	CHAR(1 BYTE)	SETTLE_MODE	清算模式
    private String 	updateOper	;//	VARCHAR2(20 BYTE)	UPDATE_OPER	更新柜员
    private String 	updateDate	;//	CHAR(8 BYTE)	UPDATE_DATE	更新日期
    private String 	updateTime	;//	CHAR(6 BYTE)	UPDATE_TIME	更新时间
    private String 	accountNo	;//	VARCHAR2(19 BYTE)	ACCOUNT_NO	入账账号
    private String 	accountName	;//	VARCHAR2(64 BYTE)	ACCOUNT_NAME	账号名称
    private String 	openingBank	;//	VARCHAR2(64 BYTE)	OPENING_BANK	账号开户行
    private String 	openingBankNo	;//	VARCHAR2(25 BYTE)	OPENING_BANK_NO	开户行行号
    private String 	openingBankAddress	;//	VARCHAR2(64 BYTE)	OPENING_BANK_ADDRESS	开户行地址
    private String 	cardHolderName	;//	VARCHAR2(64 BYTE)	CARDHOLDER_NAME	账号所属人/机构姓名
    private String 	cardHolderMobile	;//	CHAR(11 BYTE)	CARDHOLDER_MOVEIPHONE	账号所属人/机构手机
    private String 	cardHolderTelephone	;//	VARCHAR2(11 BYTE)	CARDHOLDER_TELEPHONE	账号所属人/机构电话
    private String 	idCard	;//	CHAR(18 BYTE)	ID_CARD	账号所属人身份证号
    private String 	memo	;//	VARCHAR2(40 BYTE)	MEMO	备注信息

    public String getMerGrpId() {
        return merGrpId;
    }

    public void setMerGrpId(String merGrpId) {
        this.merGrpId = merGrpId;
    }

    public String getMerGrpName() {
        return merGrpName;
    }

    public void setMerGrpName(String merGrpName) {
        this.merGrpName = merGrpName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getAbbrName() {
        return abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    public String getAddressChn() {
        return addressChn;
    }

    public void setAddressChn(String addressChn) {
        this.addressChn = addressChn;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getZbank() {
        return zbank;
    }

    public void setZbank(String zbank) {
        this.zbank = zbank;
    }

    public String getLockMode() {
        return lockMode;
    }

    public void setLockMode(String lockMode) {
        this.lockMode = lockMode;
    }

    public String getSettleMode() {
        return settleMode;
    }

    public void setSettleMode(String settleMode) {
        this.settleMode = settleMode;
    }

    public String getUpdateOper() {
        return updateOper;
    }

    public void setUpdateOper(String updateOper) {
        this.updateOper = updateOper;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
