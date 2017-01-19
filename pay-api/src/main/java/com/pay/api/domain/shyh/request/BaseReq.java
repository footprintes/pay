package com.pay.api.domain.shyh.request;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 13:51
 */
public class BaseReq {

    /**
     * 经过Base64处理的商户证书代码
     */
    private String koalB64Cert;

    /**
     * 签名数据
     */
    private String signature;

    public String getKoalB64Cert() {
        return koalB64Cert;
    }

    @XmlAttribute(name = "KoalB64Cert")
    public void setKoalB64Cert(String koalB64Cert) {
        this.koalB64Cert = koalB64Cert;
    }

    public String getSignature() {
        return signature;
    }

    @XmlAttribute(name = "Signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }
}
