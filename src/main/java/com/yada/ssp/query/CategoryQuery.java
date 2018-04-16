package com.yada.ssp.query;

import com.yada.security.base.BaseQuery;

/**
 * @author xianyong
 */
public class CategoryQuery extends BaseQuery {
    private String id;
    private String detail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail.trim();
    }
}
