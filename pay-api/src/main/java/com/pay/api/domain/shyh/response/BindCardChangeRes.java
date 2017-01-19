package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>绑定卡变更-响应</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 13:25
 */
public class BindCardChangeRes {

    /**
     * 子账号
     */
    private String subAcctNo;

    /**
     * 产品参数
     */
    private String productCd;

    /**
     * 姓名
     */
    private String custName;

    /**
     * 新绑定银行卡号
     */
    private String newCardNo;

    /**
     * 新银行卡预留手机号
     */
    private String newReservedPhone;

    /**
     * 签名数据
     */
    private String signature;

    public String getSubAcctNo() {
        return subAcctNo;
    }

    @XmlAttribute(name = "SubAcctNo")
    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo;
    }

    public String getProductCd() {
        return productCd;
    }

    @XmlAttribute(name = "ProductCd")
    public void setProductCd(String productCd) {
        this.productCd = productCd;
    }

    public String getCustName() {
        return custName;
    }

    @XmlAttribute(name = "CustName")
    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getNewCardNo() {
        return newCardNo;
    }

    @XmlAttribute(name = "NewCardNo")
    public void setNewCardNo(String newCardNo) {
        this.newCardNo = newCardNo;
    }

    public String getNewReservedPhone() {
        return newReservedPhone;
    }

    @XmlAttribute(name = "NewReservedPhone")
    public void setNewReservedPhone(String newReservedPhone) {
        this.newReservedPhone = newReservedPhone;
    }

    public String getSignature() {
        return signature;
    }

    @XmlAttribute(name = "Signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }
}
