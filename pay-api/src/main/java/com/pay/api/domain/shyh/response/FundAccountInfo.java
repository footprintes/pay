package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * <p>基金账户信息-响应</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 15:54
 */
public class FundAccountInfo implements Serializable {

    /**
     * 产品参数
     */
    private String productParam;

    /**
     * 子账户
     */
    private String subAcctNo;

    /**
     * 子账户开户手机号
     */
    private String mobllePhone;

    /**
     * 绑定银行卡号
     */
    private String bindCardNo;

    /**
     * 基金代码
     */
    private String fundCode;

    /**
     * 基金账户
     */
    private String fundAcct;

    /**
     * 基金交易账号
     */
    private String fundTxnAcct;

    public String getProductParam() {
        return productParam;
    }

    public void setProductParam(String productParam) {
        this.productParam = productParam;
    }

    public String getSubAcctNo() {
        return subAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo;
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

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundAcct() {
        return fundAcct;
    }

    public void setFundAcct(String fundAcct) {
        this.fundAcct = fundAcct;
    }

    public String getFundTxnAcct() {
        return fundTxnAcct;
    }

    public void setFundTxnAcct(String fundTxnAcct) {
        this.fundTxnAcct = fundTxnAcct;
    }
}
