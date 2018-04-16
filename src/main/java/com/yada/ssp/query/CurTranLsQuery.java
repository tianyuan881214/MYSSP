package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

import java.io.Serializable;

/**
 * @author xianyong
 */
public class CurTranLsQuery extends BaseQuery implements Serializable {

    private String merchantName;
    private String cardNo;
    private String localSysDateTimeBegin;
    private String localSysDateTimeEnd;
    private String merchantId;
    private String localSysDate;
    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getLocalSysDate() {
        return localSysDate;
    }

    public void setLocalSysDate(String localSysDate) {
        this.localSysDate = localSysDate;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo.trim();
    }

    public String getLocalSysDateTimeBegin() {
        return localSysDateTimeBegin;
    }

    public void setLocalSysDateTimeBegin(String localSysDateTimeBegin) {
        this.localSysDateTimeBegin = localSysDateTimeBegin.trim();
    }

    public String getLocalSysDateTimeEnd() {
        return localSysDateTimeEnd;
    }

    public void setLocalSysDateTimeEnd(String localSysDateTimeEnd) {
        this.localSysDateTimeEnd = localSysDateTimeEnd.trim();
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName.trim();
    }



}
