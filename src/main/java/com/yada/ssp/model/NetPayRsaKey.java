package com.yada.ssp.model;

/**
 * @author xianyong
 */
public class NetPayRsaKey {
    private String keyVer;
    private String publicE;
    private String publicM;
    private String privateD;
    private String privateM;

    public String getKeyVer() {
        return keyVer;
    }

    public void setKeyVer(String keyVer) {
        this.keyVer = keyVer;
    }

    public String getPublicE() {
        return publicE;
    }

    public void setPublicE(String publicE) {
        this.publicE = publicE;
    }

    public String getPublicM() {
        return publicM;
    }

    public void setPublicM(String publicM) {
        this.publicM = publicM;
    }

    public String getPrivateD() {
        return privateD;
    }

    public void setPrivateD(String privateD) {
        this.privateD = privateD;
    }

    public String getPrivateM() {
        return privateM;
    }

    public void setPrivateM(String privateM) {
        this.privateM = privateM;
    }
}
