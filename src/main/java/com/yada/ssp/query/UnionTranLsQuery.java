package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/10.UnionTranLs
 */
public class UnionTranLsQuery extends BaseQuery implements Serializable {
    private String merId;
    private String orderId;
    private String finishDateTimeBegin;
    private String finishDateTimeEnd;
    private String firstName;
    private String orgId;
    private String merchantCname;

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getMerchantCname() {
        return merchantCname;
    }

    public void setMerchantCname(String merchantCname) {
        this.merchantCname = merchantCname;
    }
}
