package com.yada.ssp.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/10.
 */
public class UnionTranLs implements Serializable {
    private static final String MERID= "商户号";
    private static final String ORDERID= "订单号";
    private static final String QUERYID= "流水号";
    private static final String TRACETIME= "交易时间";
    private static final String ACCNO= "交易账号";
    private static final String TXNAMT= "交易金额";
    private static final String FIRST_Name= "所属机构";
    private static final String SECOND_NAME= "二级机构";
    private static final String STATE= "商户状态";
    private static final String MERCHANT_CNAME= "商户名称";
    private static final String ORG_ID= "银行id";

    private String merId;
    private String orderId;
    private String queryId;
    private String traceTime;
    private String accNo;
    private String txNamt;
    private String firstName;
    private String secondName;
    private String state;
    private String merchantCname;
    private String orgId;

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

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getTraceTime() {
        return traceTime;
    }

    public void setTraceTime(String traceTime) {
        this.traceTime = traceTime;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getTxNamt() {
        return txNamt;
    }

    public void setTxNamt(String txNamt) {
        this.txNamt = txNamt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMerchantCname() {
        return merchantCname;
    }

    public void setMerchantCname(String merchantCname) {
        this.merchantCname = merchantCname;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
