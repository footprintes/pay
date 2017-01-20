package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>联机开户-响应/p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 11:46
 */
public class OnlineAccountRes extends BaseRes{

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
     * 是否开通余额理财功能  Y|是 N|否 固定值N
     */
    private String sign;

    /**
     * 基金代码
     */
    private String fundCode;

    /**
     * 平台账户开户结果  S|成功   F|失败
     */
    private String acctOpenResult;

    /**
     * 平台账户开户结果描述
     */
    private String acctOpenDesc;

    /**
     * E账户主账户
     */
    private String eacctNo;

    /**
     * 平台理财专属子账户
     */
    private String subAcctNo;

    /**
     * 基金账户开户结果   S|成功  F|失败   如果不开通余额理财功能，该字段为
     */
    private String fundAcctOpenResult;

    /**
     * 基金账户开户结果描述
     */
    private String fundAcctOpenDesc;

    /**
     * 基金账户
     */
    private String fundAcct;

    /**
     * 基金交易账号
     */
    private String fundTxnAcct;

    /**
     * 签名数据
     */
    private String signature;

    public String getCoopCustNo() {
        return coopCustNo;
    }

    @XmlAttribute(name = "CoopCustNo")
    public void setCoopCustNo(String coopCustNo) {
        this.coopCustNo = coopCustNo;
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

    public String getIdNo() {
        return idNo;
    }

    @XmlAttribute(name = "IdNo")
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSign() {
        return sign;
    }

    @XmlAttribute(name = "Sign")
    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getFundCode() {
        return fundCode;
    }

    @XmlAttribute(name = "FundCode")
    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getAcctOpenResult() {
        return acctOpenResult;
    }

    @XmlAttribute(name = "AcctOpenResult")
    public void setAcctOpenResult(String acctOpenResult) {
        this.acctOpenResult = acctOpenResult;
    }

    public String getAcctOpenDesc() {
        return acctOpenDesc;
    }

    @XmlAttribute(name = "AcctOpenDesc")
    public void setAcctOpenDesc(String acctOpenDesc) {
        this.acctOpenDesc = acctOpenDesc;
    }

    public String getEacctNo() {
        return eacctNo;
    }

    @XmlAttribute(name = "EacctNo")
    public void setEacctNo(String eacctNo) {
        this.eacctNo = eacctNo;
    }

    public String getSubAcctNo() {
        return subAcctNo;
    }

    @XmlAttribute(name = "SubAcctNo")
    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo;
    }

    public String getFundAcctOpenResult() {
        return fundAcctOpenResult;
    }

    @XmlAttribute(name = "FundAcctOpenResult")
    public void setFundAcctOpenResult(String fundAcctOpenResult) {
        this.fundAcctOpenResult = fundAcctOpenResult;
    }

    public String getFundAcctOpenDesc() {
        return fundAcctOpenDesc;
    }

    @XmlAttribute(name = "FundAcctOpenDesc")
    public void setFundAcctOpenDesc(String fundAcctOpenDesc) {
        this.fundAcctOpenDesc = fundAcctOpenDesc;
    }

    public String getFundAcct() {
        return fundAcct;
    }

    @XmlAttribute(name = "FundAcct")
    public void setFundAcct(String fundAcct) {
        this.fundAcct = fundAcct;
    }

    public String getFundTxnAcct() {
        return fundTxnAcct;
    }

    @XmlAttribute(name = "FundTxnAcct")
    public void setFundTxnAcct(String fundTxnAcct) {
        this.fundTxnAcct = fundTxnAcct;
    }
}
