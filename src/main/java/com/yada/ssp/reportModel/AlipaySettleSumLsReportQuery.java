package com.yada.ssp.reportModel;

import java.io.Serializable;

/**
 * @author xianyong
 */
public class AlipaySettleSumLsReportQuery implements Serializable{
    private String  businessBase;//业务渠道
    private String storeId;
    private String settleDateTimeBegin;
    private String settleDateTimeEnd;

    /**
     * 机构和上级机构的查询条件
     */
    private String orgId;
    private String pOrgId;

    public String getBusinessBase() {
        return businessBase;
    }

    public void setBusinessBase(String businessBase) {
        this.businessBase = businessBase;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getSettleDateTimeBegin() {
        return settleDateTimeBegin;
    }

    public void setSettleDateTimeBegin(String settleDateTimeBegin) {
        this.settleDateTimeBegin = settleDateTimeBegin;
    }

    public String getSettleDateTimeEnd() {
        return settleDateTimeEnd;
    }

    public void setSettleDateTimeEnd(String settleDateTimeEnd) {
        this.settleDateTimeEnd = settleDateTimeEnd;
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
