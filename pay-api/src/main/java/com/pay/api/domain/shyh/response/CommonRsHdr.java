package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/2/3 14:34
 */
public class CommonRsHdr implements Serializable {

    /**
     * 返回结果码
     */
    private String statusCode;

    /**
     * 返回结果信息
     */
    private String serverStatusCode;

    /**
     * 请求流水号
     */
    private String rqUID;

    /**
     * 主机流水号
     */
    private String sPRsUID;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getServerStatusCode() {
        return serverStatusCode;
    }

    public void setServerStatusCode(String serverStatusCode) {
        this.serverStatusCode = serverStatusCode;
    }

    public String getRqUID() {
        return rqUID;
    }

    public void setRqUID(String rqUID) {
        this.rqUID = rqUID;
    }

    public String getsPRsUID() {
        return sPRsUID;
    }

    public void setsPRsUID(String sPRsUID) {
        this.sPRsUID = sPRsUID;
    }
}
