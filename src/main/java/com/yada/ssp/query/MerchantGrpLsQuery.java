package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

import java.io.Serializable;

/**
 * @author xianyong
 */
public class MerchantGrpLsQuery extends BaseQuery implements Serializable{

    private String merGrpName;
    private String lockMode;

    public String getMerGrpName() {
        return merGrpName;
    }

    public void setMerGrpName(String merGrpName) {
        this.merGrpName = merGrpName;
    }

    public String getLockMode() {
        return lockMode;
    }

    public void setLockMode(String lockMode) {
        this.lockMode = lockMode;
    }
}
