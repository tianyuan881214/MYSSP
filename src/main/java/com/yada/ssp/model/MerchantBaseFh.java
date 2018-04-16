/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.yada.ssp.model;

import java.util.List;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class MerchantBaseFh implements java.io.Serializable {

    private static final long serialVersionUID = 3344599720238179828L;
    //alias
    public static final String TABLE_ALIAS = "商户资料";
    public static final String ALIAS_MERCHANT_ID = "商户号";
    public static final String ALIAS_MCC = "MCC码";
    public static final String ALIAS_MERCHANT_CNAME = "中文全称";
    public static final String ALIAS_MERCHANT_ENAME = "英文全称";
    public static final String ALIAS_ABBR_CNAME = "中文简称";
    public static final String ALIAS_ABBR_ENAME = "英文简称";
    public static final String ALIAS_ADDRESS_CHN = "商户中文地址";
    public static final String ALIAS_ADDRESS_ENG = "商户英文地址";
    public static final String ALIAS_CITY_CNAME = "商户所在城市中文名";
    public static final String ALIAS_CITY_ENAME = "商户所在城市英文名";
    public static final String ALIAS_TELEPHONE = "电话号码";
    public static final String ALIAS_POST_CODE = "邮编";
    public static final String ALIAS_FAX = "传真";
    public static final String ALIAS_MANAGER = "商户客户经理";
    public static final String ALIAS_SIGN_BANK_ID = "所属网点";
    public static final String ALIAS_SIGN_HOST_ID = "主机ID";
    public static final String ALIAS_ZBANK = "所属机构";
    public static final String ALIAS_ZBANK_ID = "机构ID";
    public static final String ALIAS_CCY_TYPE = "交易货币码";
    public static final String ALIAS_LOCK_MODE = "锁标示";
    public static final String ALIAS_SIGN_DATE = "签到日期";
    public static final String ALIAS_MERCHANT_STAT = "商户状态";
    public static final String ALIAS_SETTLE_MODE = "清算模式";
    public static final String ALIAS_UPDATE_OPER = "更新柜员";
    public static final String ALIAS_UPDATE_DATE = "更新日期";
    public static final String ALIAS_UPDATE_TIME = "更新时间";

    public static final String ALIAS_ERRRES = "错误原因";
    public static final String ALIAS_ORDER_NUM = "序号";
    public static final String ALLAS_SETTLE_MERCH_ID = "所属商圈";
    public static final String ALLAS_SEND_STATUS = "发送状态";
    public static final String ALLAS_SCAN_TYPE="扫描方式";
    public static final String ALLAS_ACCOUNT_TYPE="账户类型";
    public static final String ALLAS_STATE="商户状态";
    public static final String ALLAS_BELONG_ORG_ID="所属二级行";

    private boolean checked;
    //date formats
    private String errRes;//错误原因

    private String accountType;
    private String state;
    private String belongOrgId;


    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START
    /**
     * merchantId       db_column: MERCHANT_ID
     */
    //@Length(max=15)
    private String merchantId;
    /**
     * mcc       db_column: MCC
     */
    //@NotBlank @Length(max=4)
    private String mcc;
    /**
     * merchantCname       db_column: MERCHANT_CNAME
     */
    //@NotBlank @Length(max=40)
    private String merchantCname;
    /**
     * merchantEname       db_column: MERCHANT_ENAME
     */
    //@Length(max=20)
    private String merchantEname;
    /**
     * abbrCname       db_column: ABBR_CNAME
     */
    //@Length(max=10)
    private String abbrCname;
    /**
     * abbrEname       db_column: ABBR_ENAME
     */
    //@Length(max=8)
    private String abbrEname;
    /**
     * addressChn       db_column: ADDRESS_CHN
     */
    //@Length(max=30)
    private String addressChn;
    /**
     * addressEng       db_column: ADDRESS_ENG
     */
    //@Length(max=20)
    private String addressEng;
    /**
     * cityCname       db_column: CITY_CNAME
     */
    //@Length(max=30)
    private String cityCname;
    /**
     * cityEname       db_column: CITY_ENAME
     */
    //@Length(max=20)
    private String cityEname;
    /**
     * telephone       db_column: TELEPHONE
     */
    //@Length(max=20)
    private String telephone;
    /**
     * postCode       db_column: POST_CODE
     */
    //@Length(max=6)
    private String postCode;
    /**
     * fax       db_column: FAX
     */
    //@Length(max=20)
    private String fax;
    /**
     * manager       db_column: MANAGER
     */
    //@Length(max=8)
    private String manager;
    /**
     * settleMerchId       db_column: SETTLE_MERCH_ID
     */
    //@NotBlank @Length(max=15)
    private String settleMerchId;
    /**
     * signBankId       db_column: SIGN_BANK_ID
     */
    //@NotBlank @Length(max=11)
    private String signBankId;
    /**
     * signHostId       db_column: SIGN_HOST_ID
     */
    //@NotBlank @Length(max=2)
    private String signHostId;
    /**
     * zbank       db_column: ZBANK
     */
    //@NotBlank @Length(max=11)
    private String zbank;
    /**
     * ccyType       db_column: CCY_TYPE
     */
    //@Length(max=3)
    private String ccyType;
    /**
     * lockMode       db_column: LOCK_MODE
     */
    //@NotBlank @Length(max=1)
    private String lockMode;
    /**
     * signDate       db_column: SIGN_DATE
     */
    //@Length(max=8)
    private String signDate;
    /**
     * merchantStat       db_column: MERCHANT_STAT
     */
    //@NotBlank @Length(max=1)
    private String merchantStat;
    /**
     * settleMode       db_column: SETTLE_MODE
     */
    //@NotBlank @Length(max=1)
    private String settleMode;
    /**
     * updateOper       db_column: UPDATE_OPER
     */
    //@Length(max=20)
    private String updateOper;
    /**
     * updateDate       db_column: UPDATE_DATE
     */
    //@Length(max=8)
    private String updateDate;
    /**
     * updateTime       db_column: UPDATE_TIME
     */
    //@Length(max=6)
    private String updateTime;

    private Integer orderNum;
    //columns END
    /**
     * 支付宝返回的唯一标识
     */
    private String subMerchantId;

    /**
     * 微信返回标识
     */
    private  String sub_mch_id;

    private  String sendStatus;

    private  String scanType;

    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    private List<MerchantBusiness> merchantBusinesses;
    private EnterAiliMerchant enterAiliMerchant;

    private String orgId;

    private String accountNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    private String id;
    private String detail;
    private String merGrpId;

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getMerGrpId() {
        return merGrpId;
    }

    public void setMerGrpId(String merGrpId) {
        this.merGrpId = merGrpId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public EnterAiliMerchant getEnterAiliMerchant() {
        return enterAiliMerchant;
    }

    public void setEnterAiliMerchant(EnterAiliMerchant enterAiliMerchant) {
        this.enterAiliMerchant = enterAiliMerchant;
    }

    public List<MerchantBusiness> getMerchantBusinesses() {
        return merchantBusinesses;
    }

    public void setMerchantBusinesses(List<MerchantBusiness> merchantBusinesses) {
        this.merchantBusinesses = merchantBusinesses;
    }

    public String getSubMerchantId() {
        return subMerchantId;
    }

    public void setSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public MerchantBaseFh() {
    }

    public MerchantBaseFh(
            String merchantId
    ) {
        this.merchantId = merchantId;
    }


    public void setMerchantId(String value) {
        this.merchantId = value;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMcc(String value) {
        this.mcc = value;
    }

    public String getMcc() {
        return this.mcc;
    }

    public void setMerchantCname(String value) {
        this.merchantCname = value;
    }

    public String getMerchantCname() {
        return this.merchantCname;
    }

    public void setMerchantEname(String value) {
        this.merchantEname = value;
    }

    public String getMerchantEname() {
        return this.merchantEname;
    }

    public void setAbbrCname(String value) {
        this.abbrCname = value;
    }

    public String getAbbrCname() {
        return this.abbrCname;
    }

    public void setAbbrEname(String value) {
        this.abbrEname = value;
    }

    public String getAbbrEname() {
        return this.abbrEname;
    }

    public void setAddressChn(String value) {
        this.addressChn = value;
    }

    public String getAddressChn() {
        return this.addressChn;
    }

    public void setAddressEng(String value) {
        this.addressEng = value;
    }

    public String getAddressEng() {
        return this.addressEng;
    }

    public void setCityCname(String value) {
        this.cityCname = value;
    }

    public String getCityCname() {
        return this.cityCname;
    }

    public void setCityEname(String value) {
        this.cityEname = value;
    }

    public String getCityEname() {
        return this.cityEname;
    }

    public void setTelephone(String value) {
        this.telephone = value;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setPostCode(String value) {
        this.postCode = value;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public void setFax(String value) {
        this.fax = value;
    }

    public String getFax() {
        return this.fax;
    }

    public void setManager(String value) {
        this.manager = value;
    }

    public String getManager() {
        return this.manager;
    }

    public void setSettleMerchId(String value) {
        this.settleMerchId = value;
    }

    public String getSettleMerchId() {
        return this.settleMerchId;
    }

    public void setSignBankId(String value) {
        this.signBankId = value;
    }

    public String getSignBankId() {
        return this.signBankId;
    }

    public void setSignHostId(String value) {
        this.signHostId = value;
    }

    public String getSignHostId() {
        return this.signHostId;
    }

    public void setZbank(String value) {
        this.zbank = value;
    }

    public String getZbank() {
        return this.zbank;
    }

    public void setCcyType(String value) {
        this.ccyType = value;
    }

    public String getCcyType() {
        return this.ccyType;
    }

    public void setLockMode(String value) {
        this.lockMode = value;
    }

    public String getLockMode() {
        return this.lockMode;
    }

    public void setSignDate(String value) {
        this.signDate = value;
    }

    public String getSignDate() {
        return this.signDate;
    }

    public void setMerchantStat(String value) {
        this.merchantStat = value;
    }

    public String getMerchantStat() {
        return this.merchantStat;
    }

    public void setSettleMode(String value) {
        this.settleMode = value;
    }

    public String getSettleMode() {
        return this.settleMode;
    }

    public void setUpdateOper(String value) {
        this.updateOper = value;
    }


    public String getUpdateOper() {
        return this.updateOper;
    }

    public void setUpdateDate(String value) {
        this.updateDate = value;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateTime(String value) {
        this.updateTime = value;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBelongOrgId() {
        return belongOrgId;
    }

    public void setBelongOrgId(String belongOrgId) {
        this.belongOrgId = belongOrgId;
    }

    @Override
    public String toString() {
        return "MerchantBase{" +
                "checked=" + checked +
                ", errRes='" + errRes + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", mcc='" + mcc + '\'' +
                ", merchantCname='" + merchantCname + '\'' +
                ", merchantEname='" + merchantEname + '\'' +
                ", abbrCname='" + abbrCname + '\'' +
                ", abbrEname='" + abbrEname + '\'' +
                ", addressChn='" + addressChn + '\'' +
                ", addressEng='" + addressEng + '\'' +
                ", cityCname='" + cityCname + '\'' +
                ", cityEname='" + cityEname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", postCode='" + postCode + '\'' +
                ", fax='" + fax + '\'' +
                ", manager='" + manager + '\'' +
                ", settleMerchId='" + settleMerchId + '\'' +
                ", signBankId='" + signBankId + '\'' +
                ", signHostId='" + signHostId + '\'' +
                ", zbank='" + zbank + '\'' +
                ", ccyType='" + ccyType + '\'' +
                ", lockMode='" + lockMode + '\'' +
                ", signDate='" + signDate + '\'' +
                ", merchantStat='" + merchantStat + '\'' +
                ", settleMode='" + settleMode + '\'' +
                ", updateOper='" + updateOper + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", orderNum=" + orderNum +
                ", subMerchantId='" + subMerchantId + '\'' +
                ", sub_mch_id='" + sub_mch_id + '\'' +
                ", sendStatus='" + sendStatus + '\'' +
                ", scanType='" + scanType + '\'' +
                ", merchantBusinesses=" + merchantBusinesses +
                ", enterAiliMerchant=" + enterAiliMerchant +
                ", orgId='" + orgId + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", id='" + id + '\'' +
                ", detail='" + detail + '\'' +
                ", merGrpId='" + merGrpId + '\'' +
                '}';
    }

}

