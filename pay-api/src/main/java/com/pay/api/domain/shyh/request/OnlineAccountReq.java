package com.pay.api.domain.shyh.request;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * <p>联机开户-请求</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 11:46
 */
public class OnlineAccountReq implements Serializable {

    /**
     * 合作方客户账号
     */
    private String coopCustNo;

    /**
     * 理财产品参数 固定值:xtrBalFinancing
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
     * 证件到期日
     */
    private String expDay;

    /**
     * 手机号
     */
    private String mobllePhone;

    /**
     * 绑定银行卡号
     */
    private String bindCardNo;

    /**
     * 银行卡预留手机号
     */
    private String reservedPhone;

    /**
     * 是否开通余额理财功能  Y|是 N|否 固定值N
     */
    private String sign;

    /**
     * 基金代码
     */
    private String fundCode;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 家庭住址
     */
    private String homeAddr;

    /**
     * 职业
     */
    private String occupation;

    public String getCoopCustNo() {
        return coopCustNo;
    }

    public void setCoopCustNo(String coopCustNo) {
        this.coopCustNo = coopCustNo;
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

    public String getExpDay() {
        return expDay;
    }

    public void setExpDay(String expDay) {
        this.expDay = expDay;
    }

    public String getMobllePhone() {
        return mobllePhone;
    }

    public void setMobllePhone(String mobllePhone) {
        this.mobllePhone = mobllePhone;
    }

    public String getBindCardNo() {
        return bindCardNo;
    }

    public void setBindCardNo(String bindCardNo) {
        this.bindCardNo = bindCardNo;
    }

    public String getReservedPhone() {
        return reservedPhone;
    }

    public void setReservedPhone(String reservedPhone) {
        this.reservedPhone = reservedPhone;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
