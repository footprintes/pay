package com.pay.api.domain.shyh.request;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * <p>交易状态查询-请求</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 15:24
 */
public class TradStatusQueryReq implements Serializable {

    /**
     * 原交易流水号
     */
    private String oriRqUID;

    public String getOriRqUID() {
        return oriRqUID;
    }

    public void setOriRqUID(String oriRqUID) {
        this.oriRqUID = oriRqUID;
    }
}
