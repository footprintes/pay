package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 14:36
 */
public class BaseRes implements Serializable {
    /**
     * 签名数据
     */
    private String signature;

    /**
     * 报文头
     */
    private CommonRsHdr commonRsHdr;

    public String getSignature() {
        return signature;
    }

    @XmlAttribute(name = "Signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }

    public CommonRsHdr getCommonRsHdr() {
        return commonRsHdr;
    }

    @XmlElement(name = "CommonRsHdr")
    public void setCommonRsHdr(CommonRsHdr commonRsHdr) {
        this.commonRsHdr = commonRsHdr;
    }
}
