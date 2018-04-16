package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

/**
 * Created by Administrator on 2017/9/10.
 */
public class WebChatTranLsQuery extends BaseQuery {
    private String orgId;
    private String merchantNo;
    private String outTradeNo;
    private String finishDateTimeBegin;
    private String finishDateTimeEnd;
    private String  firstName;
    private String merchantCname;

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

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
