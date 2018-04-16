package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/9.
 */
public class AlipaySettleLsQuery extends BaseQuery implements Serializable{
    private String outTradeNo;
    private String finishDateTimeBegin;
    private String finishDateTimeEnd;
    private String merchantCname;
    private String orgId;
    private String merchantId;
    private String firstName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo.trim();
    }

    public String getFinishDateTimeBegin() {
        return finishDateTimeBegin;
    }

    public void setFinishDateTimeBegin(String finishDateTimeBegin) {
        this.finishDateTimeBegin = finishDateTimeBegin;
    }

    public String getFinishDateTimeEnd() {
        return finishDateTimeEnd;
    }

    public void setFinishDateTimeEnd(String finishDateTimeEnd) {
        this.finishDateTimeEnd = finishDateTimeEnd;
    }

    public String getMerchantCname() {
        return merchantCname;
    }

    public void setMerchantCname(String merchantCname) {
        this.merchantCname = merchantCname.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
