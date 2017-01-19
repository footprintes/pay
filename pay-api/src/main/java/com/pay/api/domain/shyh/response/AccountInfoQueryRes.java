package com.pay.api.domain.shyh.response;

import com.pay.api.domain.shyh.request.BaseReq;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * <p>账户信息查询-响应</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 15:34
 */
public class AccountInfoQueryRes extends BaseReq {

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

    @XmlAttribute(name = "IdNo")
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getEacctNo() {
        return eacctNo;
    }

    @XmlAttribute(name = "EacctNo")
    public void setEacctNo(String eacctNo) {
        this.eacctNo = eacctNo;
    }

    public String getCustName() {
        return custName;
    }

    @XmlAttribute(name = "CustName")
    public void setCustName(String custName) {
        this.custName = custName;
    }

    public List<FundAccountInfo> getTxnInfo() {
        return txnInfo;
    }

    @XmlElement(name = "TxnInfo")
    public void setTxnInfo(List<FundAccountInfo> txnInfo) {
        this.txnInfo = txnInfo;
    }
}

