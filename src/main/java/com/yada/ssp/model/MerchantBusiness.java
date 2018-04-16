package com.yada.ssp.model;

import java.util.List;

public class MerchantBusiness {

    public String paymerchantBases;
    public String businessBase;
    public String feeTable;
    public boolean checked;
    private MerchantBase merchantBase;
    private FeeTable feeTables;
    private BusinessBase businessBases;
    public String merchantGrpLs;

    public String getMerchantGrpLs() {
        return merchantGrpLs;
    }

    public void setMerchantGrpLs(String merchantGrpLs) {
        this.merchantGrpLs = merchantGrpLs;
    }

    public MerchantBase getMerchantBase() {
        return merchantBase;
    }

    public void setMerchantBase(MerchantBase merchantBase) {
        this.merchantBase = merchantBase;
    }

    public FeeTable getFeeTables() {
        return feeTables;
    }

    public void setFeeTables(FeeTable feeTables) {
        this.feeTables = feeTables;
    }

    public BusinessBase getBusinessBases() {
        return businessBases;
    }

    public void setBusinessBases(BusinessBase businessBases) {
        this.businessBases = businessBases;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getPaymerchantBases() {
        return paymerchantBases;
    }

    public void setPaymerchantBases(String paymerchantBases) {
        this.paymerchantBases = paymerchantBases;
    }

    public String getBusinessBase() {
        return businessBase;
    }

    public void setBusinessBase(String businessBase) {
        this.businessBase = businessBase;
    }

    public String getFeeTable() {
        return feeTable;
    }

    public void setFeeTable(String feeTable) {
        this.feeTable = feeTable;
    }

    @Override
    public String toString() {
        return "MerchantBusiness [paymerchantBases=" + paymerchantBases
                + ", businessBase=" + businessBase + ", feeTable=" + feeTable
                + "]";
    }


}
