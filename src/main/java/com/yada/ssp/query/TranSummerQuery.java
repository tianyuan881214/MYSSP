package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

/**
 * @author xianyong
 */
public class TranSummerQuery extends BaseQuery {

    private String source;

    private String merchantId;

    private String tranDateTimeBegin;

    private String tranDateTimeEnd;

    /**
     * 机构和上级机构的查询条件
     */
    private String orgId;
    private String pOrgId;

    public String getpOrgId() {
        return pOrgId;
    }

    public void setpOrgId(String pOrgId) {
        this.pOrgId = pOrgId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId.trim();
    }

    public String getTranDateTimeBegin() {
        return tranDateTimeBegin;
    }

    public void setTranDateTimeBegin(String tranDateTimeBegin) {
        this.tranDateTimeBegin = tranDateTimeBegin.trim();
    }

    public String getTranDateTimeEnd() {
        return tranDateTimeEnd;
    }

    public void setTranDateTimeEnd(String tranDateTimeEnd) {
        this.tranDateTimeEnd = tranDateTimeEnd.trim();
    }
}
