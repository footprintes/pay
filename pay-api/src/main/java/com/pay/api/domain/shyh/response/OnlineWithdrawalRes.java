package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>联机提现-响应</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 13:42
 */
public class OnlineWithdrawalRes {

    /**
     * 交易日期
     */
    private String bizDate;

    /**
     * 余额理财子帐号
     */
    private String subAcctNo;

    /**
     * 银行卡号
     */
    private String bindCardNo;

    /**
     * 交易金额
     */
    private String amount;

    /**
     * 入账币种 人民币-156  固定值：156
     */
    private String currency;

    /**
     * 交易摘要  固定值填写：薪太软提现
     */
    private String theirRef;

    /**
     * 用途
     */
    private String purpose;

    /**
     * 附件信息
     */
    private String attach;

    /**
     * 交易备注
     */
    private String memoInfo;

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

    public String getBindCardNo() {
        return bindCardNo;
    }

    @XmlAttribute(name = "BindCardNo")
    public void setBindCardNo(String bindCardNo) {
        this.bindCardNo = bindCardNo;
    }

    public String getAmount() {
        return amount;
    }

    @XmlAttribute(name = "Amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    @XmlAttribute(name = "Currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTheirRef() {
        return theirRef;
    }

    @XmlAttribute(name = "TheirRef")
    public void setTheirRef(String theirRef) {
        this.theirRef = theirRef;
    }

    public String getPurpose() {
        return purpose;
    }

    @XmlAttribute(name = "Purpose")
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getAttach() {
        return attach;
    }

    @XmlAttribute(name = "Attach")
    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getMemoInfo() {
        return memoInfo;
    }

    @XmlAttribute(name = "MemoInfo")
    public void setMemoInfo(String memoInfo) {
        this.memoInfo = memoInfo;
    }

    public String getBizDate() {
        return bizDate;
    }

    @XmlAttribute(name = "BizDate")
    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    public String getSignature() {
        return signature;
    }

    @XmlAttribute(name = "Signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }
}
