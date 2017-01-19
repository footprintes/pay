package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>流水打印申请-响应</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 16:05
 */
public class WaterPrintRes extends BaseRes {

    /**
     * 渠道
     */
    private String channelId;

    public String getChannelId() {
        return channelId;
    }

    @XmlAttribute(name = "ChannelId")
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
