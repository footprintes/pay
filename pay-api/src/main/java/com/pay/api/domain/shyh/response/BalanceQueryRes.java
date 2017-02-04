package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>账户余额-响应</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 14:33
 */
public class BalanceQueryRes extends BaseRes{

    /**
     * 余额理财子账号
     */
    private String subAcctNo;

    /**
     * 可用余额= 子账户余额 + 可用基金份额
     */
    private String avaiBal;

    /**
     * 余额
     */
    private String workingBal;

    /**
     * 基金份额
     */
    private String fundShare;

    /**
     * 可用基金份额
     */
    private String avaiFundShare;

    /**
     * 昨日收益
     */
    private String earningsYesterday;

    public String getSubAcctNo() {
        return subAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo;
    }

    public String getAvaiBal() {
        return avaiBal;
    }

    public void setAvaiBal(String avaiBal) {
        this.avaiBal = avaiBal;
    }

    public String getWorkingBal() {
        return workingBal;
    }

    public void setWorkingBal(String workingBal) {
        this.workingBal = workingBal;
    }

    public String getFundShare() {
        return fundShare;
    }

    public void setFundShare(String fundShare) {
        this.fundShare = fundShare;
    }

    public String getAvaiFundShare() {
        return avaiFundShare;
    }

    public void setAvaiFundShare(String avaiFundShare) {
        this.avaiFundShare = avaiFundShare;
    }

    public String getEarningsYesterday() {
        return earningsYesterday;
    }

    public void setEarningsYesterday(String earningsYesterday) {
        this.earningsYesterday = earningsYesterday;
    }
}
