package com.yada.ssp.model;

import java.io.Serializable;

/**
 * @author xianyong
 */
public class Category implements Serializable {
    private String id;//经营类目ID 20
    private String papers;//需要证件 300
    private String detail;//经营类目名称 200

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPapers() {
        return papers;
    }

    public void setPapers(String papers) {
        this.papers = papers;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
