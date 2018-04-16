package com.yada.ssp.model;

import oracle.sql.CHAR;

import java.io.Serializable;

/**
 * @author xianyong
 *         支付宝流水
 */
public class PayTranAlipayLs implements Serializable {
    private String outTradeNo;    //OUT_TRADE_NO	商户订单号
    private String oldBatchNo;    //OLD_BATCHNO	原批次号
    private String oldTraceNo;    //OLD_TRACENO	原终端流水号
    private String oldTranDate;    //OLD_TRANDATE	原交易日期
    private String oldTranTime;    //OLD_TRANTIME	原交易时间
    private String oldOutTradeNo;    //OLD_OUT_TRADE_NO	原商户订单号
    private String oldTerminalId;//	OLD_TERMINAL_ID	原终端号
    private String oldTradeNo;    //OLD_TRADE_NO	原支付宝交易号
    private String authCode;    //AUTH_CODE	支付授权码
    private String batchNo;//BATCH_NO	终端批次号
    private String body;    //	BODY	商户号
    private String buyerLoginId;    //BUYER_LOGON_ID	买家支付宝账号
    private Double buyerPayAmount;    //	BUYER_PAY_AMOUNT	买家付款的金额
    private String buyerUserId;    //	BUYER_USER_ID	买家在支付宝的用户
    private String code;    //CODE	网关返回码
    private Double discountableAmount;    //DISCOUNTABLE_AMOUNT	参与优惠计算的金额
    private String fundBillListId;    //FUND_BILL_LIST_ID	交易支付使用的资金渠道
    private String gmtPayment;    //GMT_PAYMENT	交易支付时间
    private String goodsIds;    //GOODS_IDS	通过goods_ids与表PAY_GOODS关联 选填 32 订单商品的编号
    private Double invoiceAmount;    //INVOICE_AMOUNT	交易中可给用户开具发票的金额
    private String lsFlag;    //LS_FLAG	订单状态
    private String operatorId;    //	OPERATOR_ID	操作员号
    private Double pointAmount;    //	POINT_AMOUNT	使用积分宝付款的金额
    private String refundFlag;    //REFUND_FLAG	退货标识
    private String royaltyInfoId;    //ROYALTY_INFO_ID	royalty_info表关联 选填 32 描述分账信息
    private String scene;    //SCENE	支付场景 条码支付，取值：bar_code 声波支付，取值：wave_code
    private String sellerId;    //	SELLER_ID	默认为商户签约账号对应的支付宝用户ID
    private String storeId;    //	STORE_ID	商户编号
    private String storeName;    //STORE_NAME	发生支付交易的商户门店名称
    private String subCode;    //SUB_CODE	业务返回码
    private String subject;    //SUBJECT	订单标题
    private String sysServiceProviderId;    //SYS_SERVICE_PROVIDER_ID	系统商编号 该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的
    private String terminalId;    //	TERMINAL_ID	终端编号
    private String timeOutExpress;    //TIMEOUT_EXPRESS	选填 6 订单允许的最晚付款时间取值范围：1m～15d
    private Double totalAmount;    //TOTAL_AMOUNT	 交易金额
    private String traceNo;    //TRACE_NO	终端流水号
    private String tradeNo;    //	TRADE_NO	支付宝交易号
    private String tranDate;    //TRAN_DATE	发送请求的日期
    private String tranTime;    //TRAN_TIME	发送请求的时间
    private String tranType;    //TRAN_TYPE	交易类型
    private Double undiscountableAmount;    //	UNDISCOUNTABLE_AMOUNT	不参与优惠计算的金额
    private String undoFlag;    //	UNDO_FLAG	撤销标识
    private String name;
    private String accountNo;
    private String inOrg;

    public String getInOrg() {
        return inOrg;
    }

    public void setInOrg(String inOrg) {
        this.inOrg = inOrg;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOldBatchNo() {
        return oldBatchNo;
    }

    public void setOldBatchNo(String oldBatchNo) {
        this.oldBatchNo = oldBatchNo;
    }

    public String getOldTraceNo() {
        return oldTraceNo;
    }

    public void setOldTraceNo(String oldTraceNo) {
        this.oldTraceNo = oldTraceNo;
    }

    public String getOldTranDate() {
        return oldTranDate;
    }

    public void setOldTranDate(String oldTranDate) {
        this.oldTranDate = oldTranDate;
    }

    public String getOldTranTime() {
        return oldTranTime;
    }

    public void setOldTranTime(String oldTranTime) {
        this.oldTranTime = oldTranTime;
    }

    public String getOldOutTradeNo() {
        return oldOutTradeNo;
    }

    public void setOldOutTradeNo(String oldOutTradeNo) {
        this.oldOutTradeNo = oldOutTradeNo;
    }

    public String getOldTerminalId() {
        return oldTerminalId;
    }

    public void setOldTerminalId(String oldTerminalId) {
        this.oldTerminalId = oldTerminalId;
    }

    public String getOldTradeNo() {
        return oldTradeNo;
    }

    public void setOldTradeNo(String oldTradeNo) {
        this.oldTradeNo = oldTradeNo;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBuyerLoginId() {
        return buyerLoginId;
    }

    public void setBuyerLoginId(String buyerLoginId) {
        this.buyerLoginId = buyerLoginId;
    }

    public Double getBuyerPayAmount() {
        return buyerPayAmount;
    }

    public void setBuyerPayAmount(Double buyerPayAmount) {
        this.buyerPayAmount = buyerPayAmount;
    }

    public String getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getDiscountableAmount() {
        return discountableAmount;
    }

    public void setDiscountableAmount(Double discountableAmount) {
        this.discountableAmount = discountableAmount;
    }

    public String getFundBillListId() {
        return fundBillListId;
    }

    public void setFundBillListId(String fundBillListId) {
        this.fundBillListId = fundBillListId;
    }

    public String getGmtPayment() {
        return gmtPayment;
    }

    public void setGmtPayment(String gmtPayment) {
        this.gmtPayment = gmtPayment;
    }

    public String getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(String goodsIds) {
        this.goodsIds = goodsIds;
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getLsFlag() {
        return lsFlag;
    }

    public void setLsFlag(String lsFlag) {
        this.lsFlag = lsFlag;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Double getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(Double pointAmount) {
        this.pointAmount = pointAmount;
    }

    public String getRefundFlag() {
        return refundFlag;
    }

    public void setRefundFlag(String refundFlag) {
        this.refundFlag = refundFlag;
    }

    public String getRoyaltyInfoId() {
        return royaltyInfoId;
    }

    public void setRoyaltyInfoId(String royaltyInfoId) {
        this.royaltyInfoId = royaltyInfoId;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSysServiceProviderId() {
        return sysServiceProviderId;
    }

    public void setSysServiceProviderId(String sysServiceProviderId) {
        this.sysServiceProviderId = sysServiceProviderId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTimeOutExpress() {
        return timeOutExpress;
    }

    public void setTimeOutExpress(String timeOutExpress) {
        this.timeOutExpress = timeOutExpress;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranTime() {
        return tranTime;
    }

    public void setTranTime(String tranTime) {
        this.tranTime = tranTime;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public Double getUndiscountableAmount() {
        return undiscountableAmount;
    }

    public void setUndiscountableAmount(Double undiscountableAmount) {
        this.undiscountableAmount = undiscountableAmount;
    }

    public String getUndoFlag() {
        return undoFlag;
    }

    public void setUndoFlag(String undoFlag) {
        this.undoFlag = undoFlag;
    }
}
