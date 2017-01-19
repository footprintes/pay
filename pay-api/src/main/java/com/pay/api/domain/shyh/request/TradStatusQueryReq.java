package com.pay.api.domain.shyh.request;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>交易状态查询-请求</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 15:24
 */
public class TradStatusQueryReq extends BaseReq{

    /**
     * 原交易流水号
     */
    private String oriRqUID;

    public String getOriRqUID() {
        return oriRqUID;
    }

    @XmlAttribute(name = "OriRqUID")
    public void setOriRqUID(String oriRqUID) {
        this.oriRqUID = oriRqUID;
    }
}
