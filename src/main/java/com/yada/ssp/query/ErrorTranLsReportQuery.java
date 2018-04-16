package com.yada.ssp.query;

/**
 * @author xianyong
 */
public class ErrorTranLsReportQuery {

    private String merchantId;
    private String tranSources;
    private String accountRelation;
    private String errorCause;
    private String tranDateTimeBegin;
    private String tranDateTimeEnd;

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
