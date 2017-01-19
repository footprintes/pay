package com.pay.api.domain.shyh.request;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>账户信息查询-请求</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 15:34
 */
public class AccountInfoQueryReq extends BaseReq{

    /**
     * E账户主账户号
     */
    private String eacctNo;

    /**
     * 客户身份证
     */
    private String idNo;

    /**
     * 产品参数
     */
    private String productParam;

    /**
     * 子账户
     */
    private String subAcctNo;

    public String getEacctNo() {
        return eacctNo;
    }

    @XmlAttribute(name = "EacctNo")
    public void setEacctNo(String eacctNo) {
        this.eacctNo = eacctNo;
    }

    public String getIdNo() {
        return idNo;
    }

    @XmlAttribute(name = "IdNo")
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getProductParam() {
        return productParam;
    }

    @XmlAttribute(name = "ProductParam")
    public void setProductParam(String productParam) {
        this.productParam = productParam;
    }

    public String getSubAcctNo() {
        return subAcctNo;
    }

    @XmlAttribute(name = "SubAcctNo")
    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo;
    }
}
