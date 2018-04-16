package com.yada.ssp.model;

import java.io.Serializable;

/**
 * @author xianyong
 *         支付宝配置参数类
 */
public class AlpConfigParam implements Serializable {
    /**
     * 支付宝网关名
     */
    private String openApiDomain;
    /**
     * 支付宝网关名
     */
    private String mcloudApiDomain;
    /**
     * 合作者身份ID（PID）length 16
     */
    private String pid;
    /**
     * 应用Id(appId)
     */
    private String appId;
    /**
     * RSA私钥
     */
    private String privateKey;
    /**
     * RSA公钥
     */
    private String publicKey;
    /**
     * 支付宝公钥
     */
    private String alpPublicKey;
    /**
     * 回调Ip端口
     */
    private String callBackIpPort;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getAlpPublicKey() {
        return alpPublicKey;
    }

    public void setAlpPublicKey(String alpPublicKey) {
        this.alpPublicKey = alpPublicKey;
    }

    public String getOpenApiDomain() {
        return openApiDomain;
    }

    public void setOpenApiDomain(String openApiDomain) {
        this.openApiDomain = openApiDomain;
    }

    public String getMcloudApiDomain() {
        return mcloudApiDomain;
    }

    public void setMcloudApiDomain(String mcloudApiDomain) {
        this.mcloudApiDomain = mcloudApiDomain;
    }

    public String getCallBackIpPort() {
        return callBackIpPort;
    }

    public void setCallBackIpPort(String callBackIpPort) {
        this.callBackIpPort = callBackIpPort;
    }
}
