package com.yada.ssp.model;

import java.io.Serializable;

/**
 * @author xianyong
 *         支付宝对账文件
 */
public class AiliCheckFile implements Serializable{
  /*  *//**
     * length 64 id
     *//*
    private String id;
    *//**
     * length 32 对账标识
     *//*
    private String dzFlag;
    *//**
     * length 100 买家支付宝账号id dzFlag buyerLogonId buyerPayAmount buyerUserId discountableAmount fundBillListId gmtPayment
     *//*
    private String buyerLogonId;
    *//**
     * length 11 买家付款的金额
     *//*
    private String buyerPayAmount;
    *//**
     * length 28 买家用户ID
     *//*
    private String buyerUserId;
    *//**
     * length 11 参与优惠计算的金额
     *//*
    private String discountableAmount;
    *//**
     * length 32 交易支付使用的资金渠道
     *//*
    private String fundBillListId;
    *//**
     * length 32 交易支付时间
     *//*
    private String gmtPayment;
    *//**
     * length 11 交易中可给用户开具发票的金额
     *//*
    private String invoiceAmount;
    *//**
     * length 32 商户识别号
     *//*
    private String merchantDiscernId;


    *//**
     * length 32 操作员号invoiceAmount,merchantDiscernId,operatorId,outTradeNo,pointAmount,receiptEndAmount,receiptAmount,refundId,scene,storeId
     *//*
    private String operatorId;
    *//**
     * length 64 商户订单号
     *//*
    private String outTradeNo;
    *//**
     * length 11 使用积分宝付款的金额
     *//*
    private String pointAmount;
    *//**
     * length 11 实收净额，扣除所有费用后
     *//*
    private String receiptEndAmount;
    *//**
     * length 11 实收金额
     *//*
    private String receiptAmount;
    *//**
     * length 32 退货标识
     *//*
    private String refundId;
    *//**
     * length 32 支付场景
     *//*
    private String scene;
    *//**
     * length 32 商户编号
     *//*
    private String storeId;
    *//**
     * length 512 发生支付交易的商户门店名称
     *//*
    private String storeName;
    *//**
     * length 32 终端编号storeName,terminalId,totalAmount,tradeNo,tranDate,tranTime,tranType,undiscounTableAmount
     *//*
    private String terminalId;
    *//**
     * length 11 交易金额
     *//*
    private String totalAmount;
    *//**
     * length 64 支付宝交易号
     *//*
    private String tradeNo;
    *//**
     * length 8 发送请求的日期
     *//*
    private String tranDate;
    *//**
     * length 6 发送请求的时间格式
     *//*
    private String tranTime;
    *//**
     * length 6 交易类型
     *//*
    private String tranType;
    *//**
     * length 11 实收净额
     *//*
    private String undiscounTableAmount;*/



    private String 	id	;//	ID	id
    private String 	tradeNo	;//	TRADE_NO	支付宝交易号
    private String 	outTradeNo	;//	OUT_TRADE_NO	商户订单号
    private String 	tranType	;//	TRAN_TYPE	业务类型
    private String 	createDate	;//	CREATE_DATE	创建时间
    private String 	finishDate	;//	FINISH_DATE	完成时间
    private String 	storeId	;//	STORE_ID	门店编号
    private String 	storeName	;//	STORE_NAME	门店名称
    private String 	operatorId	;//	OPERATOR_ID	操作员
    private String 	terminalId	;//	TERMINAL_ID	终端号
    private String 	oppositeId	;//	OPPOSITE_ID	对方账户
    private Double	orderAmount	;//	ORDER_AMOUNT	订单金额（元）
    private Double	merchantPaidAmount	;//	MERCHANT_PAID_AMOUNT	商家实收（元）
    private Double	alipayRedPacket	;//	ALIPAY_RED_PACKET	支付宝红包（元）
    private Double	integralTreasure	;//	INTEGRAL_TREASURE	集分宝（元）
    private Double	alipayPrivilege	;//	ALIPAY_PRIVILEGE	支付宝优惠（元）
    private Double	merchantPrivilege	;//	MERCHANT_PRIVILEGE	商家优惠（元）
    private Double	ticketVerification	;//	TICKET_VERIFICATION	券核销金额（元）
    private String 	ticketName	;//	TICKET_NAME	券名称
    private Double	merchantRedPacket	;//	MERCHANT_RED_PACKET	商家红包消费金额（元）
    private Double	cardConsume	;//	CARD_CONSUME	卡消费金额（元）
    private String 	refundBatchNo	;//	REFUND_BATCH_NO	退款批次号
    private Double	serviceCharge	;//	SERVICE_CHARGE	服务费（元）
    private Double	paidAmount	;//	PAID_AMOUNT	实收净额（元）
    private String 	merchantDiscernNo	;//	MERCHANT_DISCERN_NO	商户识别号
    private String 	tranWay	;//	TRAN_WAY	交易方式
    private String 	remark	;//	REMARK	备注

    private String merchantId;//商户号
    private String settleDate;
    private String name;
    private String accountNo;
    private String bankServiceAmt;//银行收手续费
    private String bank_fee;//收取费率
    private String netMerAmt;

    public String getBankServiceAmt() {
        return bankServiceAmt;
    }

    public void setBankServiceAmt(String bankServiceAmt) {
        this.bankServiceAmt = bankServiceAmt;
    }

    public String getBank_fee() {
        return bank_fee;
    }

    public void setBank_fee(String bank_fee) {
        this.bank_fee = bank_fee;
    }

    public String getNetMerAmt() {
        return netMerAmt;
    }

    public void setNetMerAmt(String netMerAmt) {
        this.netMerAmt = netMerAmt;
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

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
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

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getOppositeId() {
        return oppositeId;
    }

    public void setOppositeId(String oppositeId) {
        this.oppositeId = oppositeId;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getMerchantPaidAmount() {
        return merchantPaidAmount;
    }

    public void setMerchantPaidAmount(Double merchantPaidAmount) {
        this.merchantPaidAmount = merchantPaidAmount;
    }

    public Double getAlipayRedPacket() {
        return alipayRedPacket;
    }

    public void setAlipayRedPacket(Double alipayRedPacket) {
        this.alipayRedPacket = alipayRedPacket;
    }

    public Double getIntegralTreasure() {
        return integralTreasure;
    }

    public void setIntegralTreasure(Double integralTreasure) {
        this.integralTreasure = integralTreasure;
    }

    public Double getAlipayPrivilege() {
        return alipayPrivilege;
    }

    public void setAlipayPrivilege(Double alipayPrivilege) {
        this.alipayPrivilege = alipayPrivilege;
    }

    public Double getMerchantPrivilege() {
        return merchantPrivilege;
    }

    public void setMerchantPrivilege(Double merchantPrivilege) {
        this.merchantPrivilege = merchantPrivilege;
    }

    public Double getTicketVerification() {
        return ticketVerification;
    }

    public void setTicketVerification(Double ticketVerification) {
        this.ticketVerification = ticketVerification;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public Double getMerchantRedPacket() {
        return merchantRedPacket;
    }

    public void setMerchantRedPacket(Double merchantRedPacket) {
        this.merchantRedPacket = merchantRedPacket;
    }

    public Double getCardConsume() {
        return cardConsume;
    }

    public void setCardConsume(Double cardConsume) {
        this.cardConsume = cardConsume;
    }

    public String getRefundBatchNo() {
        return refundBatchNo;
    }

    public void setRefundBatchNo(String refundBatchNo) {
        this.refundBatchNo = refundBatchNo;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getMerchantDiscernNo() {
        return merchantDiscernNo;
    }

    public void setMerchantDiscernNo(String merchantDiscernNo) {
        this.merchantDiscernNo = merchantDiscernNo;
    }

    public String getTranWay() {
        return tranWay;
    }

    public void setTranWay(String tranWay) {
        this.tranWay = tranWay;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
