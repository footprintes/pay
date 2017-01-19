package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>交易明细-响应</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 14:50
 */
public class TradDetailInfo {

    /**
     * 主机流水号
     */
    private String txnRef;

    /**
     * 业务流水号
     */
    private String txnBsnId;

    /**
     * 交易日期
     */
    private String txnDate;

    /**
     * 交易时间
     */
    private String txnTime;

    /**
     * 交易代码
     */
    private String flowCode;

    /**
     * 交易金额
     */
    private String txnAmt;

    /**
     * 交易摘要
     */
    private String theirRef;

    public String getTxnRef() {
        return txnRef;
    }

    @XmlAttribute(name = "TxnRef")
    public void setTxnRef(String txnRef) {
        this.txnRef = txnRef;
    }

    public String getTxnBsnId() {
        return txnBsnId;
    }

    @XmlAttribute(name = "TxnBsnId")
    public void setTxnBsnId(String txnBsnId) {
        this.txnBsnId = txnBsnId;
    }

    public String getTxnDate() {
        return txnDate;
    }

    @XmlAttribute(name = "TxnDate")
    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public String getTxnTime() {
        return txnTime;
    }

    @XmlAttribute(name = "TxnTime")
    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime;
    }

    public String getFlowCode() {
        return flowCode;
    }

    @XmlAttribute(name = "FlowCode")
    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public String getTxnAmt() {
        return txnAmt;
    }

    @XmlAttribute(name = "TxnAmt")
    public void setTxnAmt(String txnAmt) {
        this.txnAmt = txnAmt;
    }

    public String getTheirRef() {
        return theirRef;
    }

    @XmlAttribute(name = "TheirRef")
    public void setTheirRef(String theirRef) {
        this.theirRef = theirRef;
    }
}
