package com.pay.comm.basic;

import java.io.Serializable;

/**
 * <p>服务响应实体对象</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2016/6/13 14:15
 */

public class ResultResponse implements Serializable {

    /**
     * 是否成功
     */
    private boolean isSuccess = false;

    /**
     * 备注
     */
    private String comment;

    /**
     * 消息code
     */
    private String msgCode;

    /**
     * 消息内容
     */
    private String message;

    /**
     * jsonpCallBack值。用于jsonp请求。
     * 如果jsonpCallBack不为空，会自动封装成jsonp格式，
     * 否则依然还是一般json格式数据
     */
    String jsonpCallBack;

    /**
     * 数据对象
     */
    private Object data;


    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getJsonpCallBack() {
        return jsonpCallBack;
    }

    public void setJsonpCallBack(String jsonpCallBack) {
        this.jsonpCallBack = jsonpCallBack;
    }

}
