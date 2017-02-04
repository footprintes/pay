package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>绑定卡变更-响应</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 13:25
 */
public class BindCardChangeRes extends BaseRes{

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

    public String getSubAcctNo() {
        return subAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo;
    }

    public String getProductCd() {
        return productCd;
    }

    public void setProductCd(String productCd) {
        this.productCd = productCd;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getNewCardNo() {
        return newCardNo;
    }

    public void setNewCardNo(String newCardNo) {
        this.newCardNo = newCardNo;
    }

    public String getNewReservedPhone() {
        return newReservedPhone;
    }

    public void setNewReservedPhone(String newReservedPhone) {
        this.newReservedPhone = newReservedPhone;
    }
}
