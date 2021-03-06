package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

/**
 * @author xianyong
 */
public class PayTranAilpayLsQuery extends BaseQuery {

    private String storeId;
    private String outTradeNo;
    private String tradeNo;
    private String buyerLoginId;
    private String tranDateTimeBegin;
    private String tranDateTimeEnd;
    private String accountNo;
    private String terminalId;

    private String tranDate;

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

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranDateTimeEnd() {
        return tranDateTimeEnd;
    }

    public void setTranDateTimeEnd(String tranDateTimeEnd) {
        this.tranDateTimeEnd = tranDateTimeEnd;
    }

    public String getTranDateTimeBegin() {
        return tranDateTimeBegin;
    }

    public void setTranDateTimeBegin(String tranDateTimeBegin) {
        this.tranDateTimeBegin = tranDateTimeBegin;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo.trim();
    }

    public String getBuyerLoginId() {
        return buyerLoginId;
    }

    public void setBuyerLoginId(String buyerLoginId) {
        this.buyerLoginId = buyerLoginId.trim();
    }


    @Override
    public String toString() {
        return "PayTranAilpayLsQuery{" +
                "storeId='" + storeId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", buyerLoginId='" + buyerLoginId + '\'' +
                ", tranDateTimeBegin='" + tranDateTimeBegin + '\'' +
                ", tranDateTimeEnd='" + tranDateTimeEnd + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", tranDate='" + tranDate + '\'' +
                ", orgId='" + orgId + '\'' +
                ", pOrgId='" + pOrgId + '\'' +
                '}';
    }
}
