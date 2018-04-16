package com.yada.ssp.reportModel;

import java.io.Serializable;

/**
 * @author xianyong
 */
public class AlpCheckFile implements Serializable{
    private String storeId;
    private String outTradeNo;
    private String tradeNo;
    private String finishDateTimeBegin;
    private String finishDateTimeEnd;
    private String accountNo;
    private String terminalId;
    /**
     * 机构和上级机构的查询条件
     */
    private String orgId;
    private String pOrgId;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
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

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
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

}
