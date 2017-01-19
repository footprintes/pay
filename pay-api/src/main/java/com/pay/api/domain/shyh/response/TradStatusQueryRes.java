package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>交易状态查询-响应</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 15:24
 */
public class TradStatusQueryRes extends BaseRes {

    /**
     * 渠道
     */
    private String ChannelId;

    /**
     * 原交易流水号
     */
    private String oriRqUID;

    /**
     * 核心响应交易流水号
     */
    private String respTxnNo;

    /**
     * 交易金额
     */
    private String amt;

    /**
     * 交易日期
     */
    private String tranDate;

    /**
     * 交易状态 I|处理中  F|交易失败   S|交易成功
     */
    private String txnStatus;

    /**
     * 交易状态描述
     */
    private String txnResult;

    public String getChannelId() {
        return ChannelId;
    }

    @XmlAttribute(name = "ChannelId")
    public void setChannelId(String channelId) {
        ChannelId = channelId;
    }

    public String getOriRqUID() {
        return oriRqUID;
    }

    @XmlAttribute(name = "OriRqUID")
    public void setOriRqUID(String oriRqUID) {
        this.oriRqUID = oriRqUID;
    }

    public String getRespTxnNo() {
        return respTxnNo;
    }

    @XmlAttribute(name = "RespTxnNo")
    public void setRespTxnNo(String respTxnNo) {
        this.respTxnNo = respTxnNo;
    }

    public String getAmt() {
        return amt;
    }

    @XmlAttribute(name = "Amt")
    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getTranDate() {
        return tranDate;
    }

    @XmlAttribute(name = "TranDate")
    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getTxnStatus() {
        return txnStatus;
    }

    @XmlAttribute(name = "TxnStatus")
    public void setTxnStatus(String txnStatus) {
        this.txnStatus = txnStatus;
    }

    public String getTxnResult() {
        return txnResult;
    }

    @XmlAttribute(name = "TxnResult")
    public void setTxnResult(String txnResult) {
        this.txnResult = txnResult;
    }
}
