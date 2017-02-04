package com.pay.comm.constant;

/**
 * <p>上海银行常量类</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/2/3 15:22
 */
public interface ShBankConstant {

    /**
     * 消息类型
     */
    String CONTENT_TYPE = "text/plain; charset=utf-8";

    /**
     * 联机开户
     */
    String XTR0001 = "XTR0001";

    /**
     * 绑定卡变更
     */
    String XTR0002 = "XTR0002";

    /**
     * 联机提现
     */
    String XTR0011 = "XTR0011";

    /**
     * 资产查询-账户余额
     */
    String XTR0101 = "XTR0101";

    /**
     * 交易明细查询
     */
    String XTR0102 = "XTR0102";

    /**
     * 交易状态查询
     */
    String XTR0103 = "XTR0103";

    /**
     * 账户信息查询
     */
    String XTR0104 = "XTR0104";

    /**
     * 流水打印申请
     */
    String XTR0105 = "XTR0105";
}
