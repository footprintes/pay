package com.pay.api.domain.shyh.request;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>流水打印申请-请求</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 16:05
 */
public class WaterPrintReq{

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
