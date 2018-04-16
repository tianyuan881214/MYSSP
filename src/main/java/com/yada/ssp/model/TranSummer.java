package com.yada.ssp.model;

import java.io.Serializable;

/**
 * @author xianyong
 */
public class TranSummer implements Serializable {

    private String id;//	VARCHAR2(32)	id
    private String source;//	CHAR(1)	来源 1银联 2支付宝 3微信
    private String merchantId;//	VARCHAR2(15)	商户号
    private String date;//	CHAR(8)	日期
    private Long sumConsume;//	NUMBER	总消费笔数
    private Double sumConsumeAmt;//	NUMBER(18,2)	总消费金额
    private Long sumRefund;//	NUMBER	总退款笔数
    private Double sumRefundAmt;//	NUMBER(18,2)	总退款金额
    private Double sumAmt;//	NUMBER(18,2)	总收益金额（总消费金额-总退款金额）
    private Long sumUndo;//	NUMBER	"撤销总笔数
    private Double sumUndoAmt;//	NUMBER(18,2)	"撤销总金额
    private String name;
    private String businessName;
    private String merchantCname;

    public String getMerchantCname() {
        return merchantCname;
    }

    public void setMerchantCname(String merchantCname) {
        this.merchantCname = merchantCname;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private MerchantBase merchantBase;

    public MerchantBase getMerchantBase() {
        return merchantBase;
    }

    public void setMerchantBase(MerchantBase merchantBase) {
        this.merchantBase = merchantBase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getSumConsume() {
        return sumConsume;
    }

    public void setSumConsume(Long sumConsume) {
        this.sumConsume = sumConsume;
    }

    public Double getSumConsumeAmt() {
        return sumConsumeAmt;
    }

    public void setSumConsumeAmt(Double sumConsumeAmt) {
        this.sumConsumeAmt = sumConsumeAmt;
    }

    public Long getSumRefund() {
        return sumRefund;
    }

    public void setSumRefund(Long sumRefund) {
        this.sumRefund = sumRefund;
    }

    public Double getSumRefundAmt() {
        return sumRefundAmt;
    }

    public void setSumRefundAmt(Double sumRefundAmt) {
        this.sumRefundAmt = sumRefundAmt;
    }

    public Double getSumAmt() {
        return sumAmt;
    }

    public void setSumAmt(Double sumAmt) {
        this.sumAmt = sumAmt;
    }

    public Long getSumUndo() {
        return sumUndo;
    }

    public void setSumUndo(Long sumUndo) {
        this.sumUndo = sumUndo;
    }

    public Double getSumUndoAmt() {
        return sumUndoAmt;
    }

    public void setSumUndoAmt(Double sumUndoAmt) {
        this.sumUndoAmt = sumUndoAmt;
    }
}
