package com.pay.api.domain.shyh.request;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * <p>资产查询-账户余额-请求</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 14:29
 */
public class BalanceQueryReq implements Serializable {

    /**
     * 余额理财子账号
     */
    private String subAcctNo;

    public String getSubAcctNo() {
        return subAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo;
    }
}
