package com.pay.api.domain.shyh.request;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>交易明细查询-请求</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 14:40
 */
public class TradDetailQueryReq extends BaseReq {

    /**
     * 余额理财子帐号
     */
    private String subAcctNo;

    /**
     * 币种  固定值：156
     */
    private String currency;

    /**
     * 开始日期
     */
    private String beginDt;

    /**
     * 结束日期
     */
    private String endDt;

    /**
     * 显示记录条数
     */
    private String pageSize;

    /**
     * 记录显示起始数
     */
    private String skipRecord;

    public String getSubAcctNo() {
        return subAcctNo;
    }

    @XmlAttribute(name = "SubAcctNo")
    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo;
    }

    public String getCurrency() {
        return currency;
    }

    @XmlAttribute(name = "Currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBeginDt() {
        return beginDt;
    }

    @XmlAttribute(name = "BeginDt")
    public void setBeginDt(String beginDt) {
        this.beginDt = beginDt;
    }

    public String getEndDt() {
        return endDt;
    }

    @XmlAttribute(name = "EndDt")
    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public String getPageSize() {
        return pageSize;
    }

    @XmlAttribute(name = "PageSize")
    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getSkipRecord() {
        return skipRecord;
    }

    @XmlAttribute(name = "SkipRecord")
    public void setSkipRecord(String skipRecord) {
        this.skipRecord = skipRecord;
    }
}
