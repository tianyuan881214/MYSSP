package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

import java.io.Serializable;

/**
 * @author xianyong
 */
public class ErrorTranLsQuery extends BaseQuery implements Serializable{

    private String merchantId;
    private String tranSources;
    private String accountRelation;
    private String errorCause;
    private String tranDateTimeBegin;
    private String tranDateTimeEnd;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getpOrgId() {
        return pOrgId;
    }

    public void setpOrgId(String pOrgId) {
        this.pOrgId = pOrgId;
    }

    private String orgId;
    private String pOrgId;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId.trim();
    }

    public String getTranSources() {
        return tranSources;
    }

    public void setTranSources(String tranSources) {
        this.tranSources = tranSources;
    }

    public String getAccountRelation() {
        return accountRelation;
    }

    public void setAccountRelation(String accountRelation) {
        this.accountRelation = accountRelation;
    }

    public String getErrorCause() {
        return errorCause;
    }

    public void setErrorCause(String errorCause) {
        this.errorCause = errorCause;
    }

    public String getTranDateTimeBegin() {
        return tranDateTimeBegin;
    }

    public void setTranDateTimeBegin(String tranDateTimeBegin) {
        this.tranDateTimeBegin = tranDateTimeBegin;
    }

    public String getTranDateTimeEnd() {
        return tranDateTimeEnd;
    }

    public void setTranDateTimeEnd(String tranDateTimeEnd) {
        this.tranDateTimeEnd = tranDateTimeEnd;
    }
}
