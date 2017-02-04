package com.pay.api.service.shyh;

import com.pay.api.domain.shyh.request.*;
import com.pay.api.domain.shyh.response.*;

/**
 * <p>上海银行接口</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/2/3 9:42
 */
public interface ShBankService {

    /**
     * 联机开户
     *
     * @return
     */
    OnlineAccountRes onlineAccount(OnlineAccountReq onlineAccountReq) throws Exception;

    /**
     * 绑定卡变更
     *
     * @param bindCardChangeReq
     * @return
     * @throws Exception
     */
    BindCardChangeRes bindCardChange(BindCardChangeReq bindCardChangeReq) throws Exception;

    /**
     * 联机提现
     *
     * @param onlineWithdrawalReq
     * @return
     * @throws Exception
     */
    OnlineWithdrawalRes onlineWithdrawal(OnlineWithdrawalReq onlineWithdrawalReq) throws Exception;

    /**
     * 资产查询-账户余额
     *
     * @param balanceQueryReq
     * @return
     * @throws Exception
     */
    BalanceQueryRes balanceQuery(BalanceQueryReq balanceQueryReq) throws Exception;

    /**
     * 交易明细查询
     *
     * @param tradDetailQueryReq
     * @return
     * @throws Exception
     */
    TradDetailQueryRes tradDetailQuery(TradDetailQueryReq tradDetailQueryReq) throws Exception;

    /**
     * 交易状态查询
     *
     * @param tradStatusQueryReq
     * @return
     * @throws Exception
     */
    TradStatusQueryRes tradStatusQuery(TradStatusQueryReq tradStatusQueryReq) throws Exception;

    /**
     * 账户信息查询
     *
     * @param accountInfoQueryReq
     * @return
     * @throws Exception
     */
    AccountInfoQueryRes accountInfoQuery(AccountInfoQueryReq accountInfoQueryReq) throws Exception;

    /**
     * 流水打印申请
     *
     * @param waterPrintReq
     * @return
     * @throws Exception
     */
    WaterPrintRes waterPrint(WaterPrintReq waterPrintReq) throws Exception;
}
