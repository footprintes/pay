package com.pay.api.domain.shyh.request;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>绑定卡变更-请求</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 13:25
 */
public class BindCardChangeReq {

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
     * 身份证号
     */
    private String idNo;

    /**
     * 原绑定银行卡号
     */
    private String bindCardNo;

    /**
     * 新绑定银行卡号
     */
    private String newCardNo;

    /**
     * 银行卡预留手机号
     */
    private String reservedPhone;

    /**
     * 新银行卡预留手机号
     */
    private String newReservedPhone;

    /**
     * 修改类型  00:换卡 01:修改绑定卡手机号
     */
    private String modiType;

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

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getBindCardNo() {
        return bindCardNo;
    }

    public void setBindCardNo(String bindCardNo) {
        this.bindCardNo = bindCardNo;
    }

    public String getNewCardNo() {
        return newCardNo;
    }

    public void setNewCardNo(String newCardNo) {
        this.newCardNo = newCardNo;
    }

    public String getReservedPhone() {
        return reservedPhone;
    }

    public void setReservedPhone(String reservedPhone) {
        this.reservedPhone = reservedPhone;
    }

    public String getNewReservedPhone() {
        return newReservedPhone;
    }

    public void setNewReservedPhone(String newReservedPhone) {
        this.newReservedPhone = newReservedPhone;
    }

    public String getModiType() {
        return modiType;
    }

    public void setModiType(String modiType) {
        this.modiType = modiType;
    }

}
