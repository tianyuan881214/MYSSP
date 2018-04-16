package com.yada.ssp.reportModel;

import java.io.Serializable;

/**
 * @author xianyong
 */
public class VAlpBocStlModel implements Serializable {

    private String businessBase;
    private String merchantId;
    private String tranDateTimeBegin;
    private String tranDateTimeEnd;

    public String getBusinessBase() {
        return businessBase;
    }

    public void setBusinessBase(String businessBase) {
        this.businessBase = businessBase;
    }

    /**
     * 机构和上级机构的查询条件
     */
    private String orgId;
    private String pOrgId;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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
}
