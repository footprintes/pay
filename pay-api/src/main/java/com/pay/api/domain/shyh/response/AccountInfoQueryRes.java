package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * <p>账户信息查询-响应</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 15:34
 */
public class AccountInfoQueryRes extends BaseRes {

    /**
     * 客户身份证
     */
    private String idNo;

    /**
     * E账户主账户号
     */
    private String eacctNo;

    /**
     * 户名
     */
    private String custName;

    /**
     * 基金账户信息
     */
    private List<FundAccountInfo> txnInfo;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getEacctNo() {
        return eacctNo;
    }

    public void setEacctNo(String eacctNo) {
        this.eacctNo = eacctNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public List<FundAccountInfo> getTxnInfo() {
        return txnInfo;
    }

    public void setTxnInfo(List<FundAccountInfo> txnInfo) {
        this.txnInfo = txnInfo;
    }
}

