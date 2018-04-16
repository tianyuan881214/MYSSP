package com.yada.xmlUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xianyong
 */
public class ReportHeader {
    public static Map<String, String> errorTranLsHeader = new LinkedHashMap<String, String>();
    public static Map<String, String> ailiCheckFileHeader = new LinkedHashMap<String, String>();
    public static Map<String, String> vAlpBocStlHeader = new LinkedHashMap<String, String>();
    public static Map<String, String> tranSummerHeader = new LinkedHashMap<String, String>();
    public static Map<String, String> alpSettleSumLsHeader = new LinkedHashMap<String, String>();
    public static Map<String, String> webCheckFileHeader = new LinkedHashMap<String, String>();
    public static Map<String, String> payTranAlipayLsHeader = new LinkedHashMap<String, String>();
    public static Map<String, String> payTranWechatLsHeader = new LinkedHashMap<String, String>();
    //报表
    public static Map<String, String> UnionSettleLsLsHeader = new LinkedHashMap<String, String>();
    public static Map<String, String> AlipaySettlsHeader = new LinkedHashMap<String, String>();
    public static Map<String, String> WebChatSettlsHeader = new LinkedHashMap<String, String>();
    //流水
    public static Map<String, String> webChatTranLsHeader = new LinkedHashMap<String, String>();
    public static Map<String, String> alipayTranLsHeader = new LinkedHashMap<String, String>();
    public static Map<String, String>  unionTranLsHeader= new LinkedHashMap<String, String>();


    //二级
    public static Map<String, String> liquidationReportHeader = new LinkedHashMap<String, String>();
    //商户清算汇总
    public static Map<String, String>  merchantSettleLsReportHeader= new LinkedHashMap<String, String>();
    static {
        errorTranLsHeader.put("tranSources","业务渠道");
        errorTranLsHeader.put("accountRelation","对账关系");
        errorTranLsHeader.put("errorCause","差错原因");
        errorTranLsHeader.put("tranNo","流水号");
        errorTranLsHeader.put("tranType","交易类型");
        errorTranLsHeader.put("tranDate","交易日期");
        errorTranLsHeader.put("tranTime","交易时间");
        errorTranLsHeader.put("cardNo","交易卡号");
        errorTranLsHeader.put("merchantId","商户号");
        errorTranLsHeader.put("terminalNo","终端号");
        errorTranLsHeader.put("terminalLsNo","终端流水号");
        errorTranLsHeader.put("tranAmt","交易金额");
        errorTranLsHeader.put("batchNo","批次号");
        errorTranLsHeader.put("operNo","操作员号");
        errorTranLsHeader.put("refundNo","退货单号");
        errorTranLsHeader.put("authNo","授权码");
        errorTranLsHeader.put("tranCode","交易码");
        errorTranLsHeader.put("referenceNo","参考号");
    }
    static {
        ailiCheckFileHeader.put("merchantId","商户号");
        ailiCheckFileHeader.put("storeName","商户名");
        ailiCheckFileHeader.put("outTradeNo","本地订单号");
        ailiCheckFileHeader.put("tradeNo","支付宝订单号");
        ailiCheckFileHeader.put("tranType","业务类型");
        ailiCheckFileHeader.put("orderAmount","订单金额");
        ailiCheckFileHeader.put("serviceCharge","支付宝服务费");
        ailiCheckFileHeader.put("merchantPaidAmount","银行应入账金额");
        ailiCheckFileHeader.put("bankServiceAmt","银行服务费");
        ailiCheckFileHeader.put("bank_fee","银行扣率");
        ailiCheckFileHeader.put("netMerAmt","商户应入账金额");
        ailiCheckFileHeader.put("refundBatchNo","退款批次号");
        ailiCheckFileHeader.put("settleDate","清算时间");
        ailiCheckFileHeader.put("name","所属机构");
    }
    static {
        vAlpBocStlHeader.put("businessBase","业务渠道");
        vAlpBocStlHeader.put("merchantId","商户号");
        vAlpBocStlHeader.put("merchantCname","商户名称");
        vAlpBocStlHeader.put("orderSumAmt","交易金额");
        vAlpBocStlHeader.put("serviceAmt","支付宝收银行手续费");
        vAlpBocStlHeader.put("netAmount","支付宝清算至银行金额");
        vAlpBocStlHeader.put("merFee","银行净收益（总手续费-支付宝手续费）");
        vAlpBocStlHeader.put("merServiceAmt","商户总付手续费");
        vAlpBocStlHeader.put("settleAmt","银行清算至商户金额");
        vAlpBocStlHeader.put("name","归属机构");
        vAlpBocStlHeader.put("tranDate","交易时间");
    }
    static {
        tranSummerHeader.put("businessName","业务渠道");
        tranSummerHeader.put("merchantId","商户号");
        tranSummerHeader.put("merchantCname","商户名称");
        tranSummerHeader.put("sumConsume","消费总笔数");
        tranSummerHeader.put("sumConsumeAmt","消费总金额");
        tranSummerHeader.put("sumRefund","退款总笔数");
        tranSummerHeader.put("sumRefundAmt","退款总金额");
        tranSummerHeader.put("sumUndo","撤销总笔数");
        tranSummerHeader.put("sumUndoAmt","撤销总金额");
        tranSummerHeader.put("name","所属机构");
        tranSummerHeader.put("date","日期");
    }
    static {
        alpSettleSumLsHeader.put("businessBase","业务名称");
        alpSettleSumLsHeader.put("storeId","商户号");
        alpSettleSumLsHeader.put("storeName","商户名称");
        alpSettleSumLsHeader.put("orderSumAmt","订单金额");
        alpSettleSumLsHeader.put("merchantSettleAmt","商家实收");
        alpSettleSumLsHeader.put("serviceAmt","服务费");
        alpSettleSumLsHeader.put("netAmount","实收净额");
        alpSettleSumLsHeader.put("settleDate","日期");
        alpSettleSumLsHeader.put("inOrg","所属机构");
    }
    static {
        webCheckFileHeader.put("merchantId","商户号");
        webCheckFileHeader.put("merchantName","商户名称");
        webCheckFileHeader.put("tranStart","交易类型");
        webCheckFileHeader.put("totalAmount","订单金额");
        webCheckFileHeader.put("fee","微信服务费");
        webCheckFileHeader.put("feeRate","微信扣率");
        webCheckFileHeader.put("netBankAmt","银行应入账金额");
        webCheckFileHeader.put("bankServiceAmt","银行服务费");
        webCheckFileHeader.put("bank_fee","银行扣率");
        webCheckFileHeader.put("netMerAmt","商户应入账金额");
        webCheckFileHeader.put("outRefundId","退款单号");
        webCheckFileHeader.put("returndAmt","退款金额");
        webCheckFileHeader.put("tranTime","清算时间");
        webCheckFileHeader.put("inOrg","所属机构");
    }
    static {
        payTranAlipayLsHeader.put("storeId","商户号");
        payTranAlipayLsHeader.put("storeName","商户名称");
        payTranAlipayLsHeader.put("terminalId","终端号");
        payTranAlipayLsHeader.put("accountNo","入账账号");
        payTranAlipayLsHeader.put("outTradeNo","商户订单号");
        payTranAlipayLsHeader.put("tradeNo","支付宝交易号");
        payTranAlipayLsHeader.put("totalAmount","交易金额");
        payTranAlipayLsHeader.put("tradeType","交易类型");
        payTranAlipayLsHeader.put("tranDate","交易日期");
        payTranAlipayLsHeader.put("tranTime","交易时间");
        payTranAlipayLsHeader.put("name","所属机构");
    }
    static {
        payTranWechatLsHeader.put("merchantNo","商户号");
        payTranWechatLsHeader.put("merchantCname","商户名称");
        payTranWechatLsHeader.put("outTradeNo","商户订单号");
        payTranWechatLsHeader.put("transactionId","微信支付订单号");
        payTranWechatLsHeader.put("totalAmount","交易金额");
        payTranWechatLsHeader.put("tradeType","交易类型");
        payTranWechatLsHeader.put("resultCode","业务结果");
        payTranWechatLsHeader.put("tranDate","交易日期");
        payTranWechatLsHeader.put("tranTime","交易时间");
        payTranWechatLsHeader.put("name","所属机构");
    }
    static {
        UnionSettleLsLsHeader.put("merchantId","商户号");
        UnionSettleLsLsHeader.put("orderId","商户订单号");
        UnionSettleLsLsHeader.put("merchantCname","商户名称");
        UnionSettleLsLsHeader.put("accType","账号类型");
        UnionSettleLsLsHeader.put("billNo","账单号码");
        UnionSettleLsLsHeader.put("billType","账单类型");
        UnionSettleLsLsHeader.put("bizType","业务类型");
        UnionSettleLsLsHeader.put("liquindationAmt","清算净额");
        UnionSettleLsLsHeader.put("settleementAmt","结算金额");
        UnionSettleLsLsHeader.put("merchantFee","商户手续费");
        UnionSettleLsLsHeader.put("othFee","他行手续费");
        UnionSettleLsLsHeader.put("myFee","本行手续费");
        UnionSettleLsLsHeader.put("gsFee","公司手续费");
        UnionSettleLsLsHeader.put("amoutFee","总手续费");
        UnionSettleLsLsHeader.put("isOthAccount","银行类别");
        UnionSettleLsLsHeader.put("name","所属机构");
        UnionSettleLsLsHeader.put("liquidationTime","清算日期");
    }
    static {
        AlipaySettlsHeader.put("merchantId","商户号");
        AlipaySettlsHeader.put("merchantCname","商户名称");
        AlipaySettlsHeader.put("storeId","支付宝商户号");
        AlipaySettlsHeader.put("outTradeNo","支付宝订单号");
        AlipaySettlsHeader.put("firsetName","所属机构");
        AlipaySettlsHeader.put("secondName","二级机构");
        AlipaySettlsHeader.put("orderAmout","交易金额");
        AlipaySettlsHeader.put("amountFee","总手续费");
        AlipaySettlsHeader.put("settleAmount","清算金额");
        AlipaySettlsHeader.put("serviceCharge","支付宝服务费");
        AlipaySettlsHeader.put("myFee","本行分润");
        AlipaySettlsHeader.put("othFee","其他分行分润");
        AlipaySettlsHeader.put("gsFee","公司分润");
        AlipaySettlsHeader.put("accountType","账号类型");
        AlipaySettlsHeader.put("finishDate","交易时间");
        AlipaySettlsHeader.put("settleDate","清算时间");
    }
    static {
        WebChatSettlsHeader.put("merchantId","商户号");
        WebChatSettlsHeader.put("merchantCname","商户名称");
        WebChatSettlsHeader.put("subMerchantId","微信商户号");
        WebChatSettlsHeader.put("outTradeNo","微信订单号");
        WebChatSettlsHeader.put("firsetName","所属机构");
        WebChatSettlsHeader.put("secondName","二级机构");
        WebChatSettlsHeader.put("tranStart","交易状态");
        WebChatSettlsHeader.put("totalAmount","交易金额");
        WebChatSettlsHeader.put("amountFee","总手续费");
        WebChatSettlsHeader.put("settleFee","结算金额");
        WebChatSettlsHeader.put("webFee","微信手续费");
        WebChatSettlsHeader.put("feeRate","微信扣率");
        WebChatSettlsHeader.put("myFee","我行分润");
        WebChatSettlsHeader.put("othFee","其它分行分润");
        WebChatSettlsHeader.put("gsFee","公司分润");
        WebChatSettlsHeader.put("accountType","账号类型");
        WebChatSettlsHeader.put("tranDate","交易时间");
        WebChatSettlsHeader.put("settleDate","清算时间");
    }
    static {
        webChatTranLsHeader.put("merchantNo","商户号");
        webChatTranLsHeader.put("outTradeNo","商户订单号");
        webChatTranLsHeader.put("authCode","支付授权码");
        webChatTranLsHeader.put("batchNO","终端批次号");
        webChatTranLsHeader.put("merchantCname","商户名称");
        webChatTranLsHeader.put("state","入驻状态");
        webChatTranLsHeader.put("operationId","操作员号");
        webChatTranLsHeader.put("refundFlag","退货标识");
        webChatTranLsHeader.put("returnCode","返回状态码");
        webChatTranLsHeader.put("totalAmount","交易金额");
        webChatTranLsHeader.put("traceNo","终端流水号");
        webChatTranLsHeader.put("tranType","交易类型");
        webChatTranLsHeader.put("transactionId","微信支付订单号");
        webChatTranLsHeader.put("secondName","二级机构");
        webChatTranLsHeader.put("firstName","所属机构");
        webChatTranLsHeader.put("oldTranDate","清算时间");
    }
    static {
        alipayTranLsHeader.put("merchantId","商户号");
        alipayTranLsHeader.put("outTradeNo","商户订单号");
        alipayTranLsHeader.put("merchantCname","商户名称");
        alipayTranLsHeader.put("traceNo","终端流水号");
        alipayTranLsHeader.put("tranType","交易类型");
        alipayTranLsHeader.put("state","商户状态");
        alipayTranLsHeader.put("operatorId","操作员号");
        alipayTranLsHeader.put("refundFlag","退货标识");
        alipayTranLsHeader.put("secondName","二级机构");
        alipayTranLsHeader.put("firstName","所属机构");
        alipayTranLsHeader.put("totalAmount","交易金额");
        alipayTranLsHeader.put("oldTrantime","交易时间");
        alipayTranLsHeader.put("oldTrandate","交易时间");
    }
    static {

        unionTranLsHeader.put("merId","商户号");
        unionTranLsHeader.put("orderId","商户订单号");
        unionTranLsHeader.put("merchantCname","商户名称");
        unionTranLsHeader.put("queryId","流水号");
        unionTranLsHeader.put("accNo","交易账号");
        unionTranLsHeader.put("txNamt","交易金额");
        unionTranLsHeader.put("secondName","二级机构");
        unionTranLsHeader.put("firstName","所属机构");
        unionTranLsHeader.put("state","商户状态");
        unionTranLsHeader.put("traceTime","交易时间");
    }
    static {
//        liquidationReportHeader.put("businessBase","业务渠道");
        liquidationReportHeader.put("orgId","二级行机构号");
        liquidationReportHeader.put("name","二级行机构名称");
        liquidationReportHeader.put("tCount","总交易笔数"); // 总交易笔数
        liquidationReportHeader.put("totalAmount","交易金额");
        liquidationReportHeader.put("amountFee","总手续费");
        liquidationReportHeader.put("fee","服务费");
        liquidationReportHeader.put("othFee","其他行分润");
//        liquidationReportHeader.put("othRate","他行分润百分比");
//        liquidationReportHeader.put("othFee","他行分润金额");
//        liquidationReportHeader.put("gsRate","公司分润百分比");
        liquidationReportHeader.put("gsFee","公司分润");
//        liquidationReportHeader.put("myFee","本行分润金额");
        liquidationReportHeader.put("myFee","本行分润");
    }
    static {
        merchantSettleLsReportHeader.put("merchantId","商户号");
        merchantSettleLsReportHeader.put("merchantCname","商户名称");
        merchantSettleLsReportHeader.put("count","总交易数");
        merchantSettleLsReportHeader.put("aliWeTotal","总交易金额");
        merchantSettleLsReportHeader.put("aliWeFee","总手续费");
        merchantSettleLsReportHeader.put("settleFee","总清算金额");
        merchantSettleLsReportHeader.put("aliTranAmt","支付宝交易金额");
        merchantSettleLsReportHeader.put("aliFee","支付宝手续费");
        merchantSettleLsReportHeader.put("weTranAmt","微信交易金额");
        merchantSettleLsReportHeader.put("wechatFee","微信手续费");
        merchantSettleLsReportHeader.put("othFee","其他分行分润");
        merchantSettleLsReportHeader.put("myFee","我行分润");
        merchantSettleLsReportHeader.put("gsFee","公司分润");
        merchantSettleLsReportHeader.put("firstNo","所属机构号");
        merchantSettleLsReportHeader.put("firstName","所属机构名称");
        merchantSettleLsReportHeader.put("secondNo","二级机构号");
        merchantSettleLsReportHeader.put("secondName","二级机构名称");
        merchantSettleLsReportHeader.put("accountNo","入账账号");
        merchantSettleLsReportHeader.put("accountName","账号名称");
        merchantSettleLsReportHeader.put("openingBank","账号开户行");
        merchantSettleLsReportHeader.put("openingBankNo","开户行行号");
    }
}