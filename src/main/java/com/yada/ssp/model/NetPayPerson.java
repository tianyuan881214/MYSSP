package com.yada.ssp.model;

import java.io.Serializable;

/**
 * @author xianyong
 */
public class NetPayPerson implements Serializable{
    /**
     * 商户号 varchar2(15) 不可为空 联合主键之一
     */
    private String merchant;
    /**
     * 终端号 varchar2(8) 可为空
     */
    private String terminal;
    /**
     * 用户号 varchar2(16) 不可为空 联合主键之一
     */
    private String userId;
    /**
     * 密码 varchar2(32) 不可为空
     */
    private String pwd;
    /**
     * 用户名 varchar2(30) 可为空
     */
    private String name;
    /**
     * 电话 varchar2(30) 可为空
     */
    private String phone;
    /**
     * 级别 varchar2(1) 可为空 （A:管理员,P:普通）
     */
    private String level;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
