package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 14:36
 */
public class BaseRes {
    /**
     * 签名数据
     */
    private String signature;

    public String getSignature() {
        return signature;
    }

    @XmlAttribute(name = "Signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }
}
