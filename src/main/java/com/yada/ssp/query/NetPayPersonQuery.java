package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

/**
 * @author xianyong
 */
public class NetPayPersonQuery extends BaseQuery {
    private String merchant;
    private String terminal;
    private String userId;
    private String name;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant.trim();
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }
}
