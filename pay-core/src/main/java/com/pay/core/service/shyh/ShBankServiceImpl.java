package com.pay.core.service.shyh;

import com.pay.api.domain.shyh.request.*;
import com.pay.api.domain.shyh.response.*;
import com.pay.api.service.shyh.ShBankService;
import com.pay.api.service.sys.SysSerialNumberService;
import com.pay.comm.constant.ShBankConstant;
import com.pay.comm.util.HttpClientUtil;
import com.pay.comm.util.XmlUtil;
import com.pay.core.util.VelocityUtil;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/2/3 15:18
 */
@MotanService
public class ShBankServiceImpl implements ShBankService {

    @Resource
    private Environment environment;

    @Resource
    private SysSerialNumberService sysSerialNumberService;

    /**
     * 联机开户
     *
     * @return
     */
    public OnlineAccountRes onlineAccount(OnlineAccountReq onlineAccountReq) throws Exception {
        //获取请求的xml字符串
        String reqXml = VelocityUtil.getReqXmlStr(onlineAccountReq, ShBankConstant.XTR0001, sysSerialNumberService.generateSerialNumberByModelCode(ShBankConstant.XTR0001));
        if (StringUtils.isNotBlank(reqXml)) {
            //发送请求
            String result = HttpClientUtil.sendRequest(environment.getProperty("shbank.itf.url"), reqXml, ShBankConstant.CONTENT_TYPE);
            if (StringUtils.isNotBlank(result)) {
                //解析返回数据
                OnlineAccountRes onlineAccountRes = new OnlineAccountRes();
                XmlUtil.parseXml(result, onlineAccountRes, ShBankConstant.XTR0001);
                return onlineAccountRes;
            }
        }
        return null;
    }

    /**
     * 绑定卡变更
     *
     * @param bindCardChangeReq
     * @return
     * @throws Exception
     */
    public BindCardChangeRes bindCardChange(BindCardChangeReq bindCardChangeReq) throws Exception {
        //获取请求的xml字符串
        String reqXml = VelocityUtil.getReqXmlStr(bindCardChangeReq, ShBankConstant.XTR0002, sysSerialNumberService.generateSerialNumberByModelCode(ShBankConstant.XTR0002));
        if (StringUtils.isNotBlank(reqXml)) {
            //发送请求
            String result = HttpClientUtil.sendRequest(environment.getProperty("shbank.itf.url"), reqXml, ShBankConstant.CONTENT_TYPE);
            if (StringUtils.isNotBlank(result)) {
                //解析返回数据
                BindCardChangeRes bindCardChangeRes = new BindCardChangeRes();
                XmlUtil.parseXml(result, bindCardChangeRes, ShBankConstant.XTR0002);
                return bindCardChangeRes;
            }
        }
        return null;
    }

    /**
     * 联机提现
     *
     * @param onlineWithdrawalReq
     * @return
     * @throws Exception
     */
    public OnlineWithdrawalRes onlineWithdrawal(OnlineWithdrawalReq onlineWithdrawalReq) throws Exception {
        //获取请求的xml字符串
        String reqXml = VelocityUtil.getReqXmlStr(onlineWithdrawalReq, ShBankConstant.XTR0011, sysSerialNumberService.generateSerialNumberByModelCode(ShBankConstant.XTR0011));
        if (StringUtils.isNotBlank(reqXml)) {
            //发送请求
            String result = HttpClientUtil.sendRequest(environment.getProperty("shbank.itf.url"), reqXml, ShBankConstant.CONTENT_TYPE);
            if (StringUtils.isNotBlank(result)) {
                //解析返回数据
                OnlineWithdrawalRes onlineWithdrawalRes = new OnlineWithdrawalRes();
                XmlUtil.parseXml(result, onlineWithdrawalRes, ShBankConstant.XTR0011);
                return onlineWithdrawalRes;
            }
        }
        return null;
    }

    /**
     * 资产查询-账户余额
     *
     * @param balanceQueryReq
     * @return
     * @throws Exception
     */
    public BalanceQueryRes balanceQuery(BalanceQueryReq balanceQueryReq) throws Exception {
        //获取请求的xml字符串
        String reqXml = VelocityUtil.getReqXmlStr(balanceQueryReq, ShBankConstant.XTR0101, sysSerialNumberService.generateSerialNumberByModelCode(ShBankConstant.XTR0101));
        if (StringUtils.isNotBlank(reqXml)) {
            //发送请求
            String result = HttpClientUtil.sendRequest(environment.getProperty("shbank.itf.url"), reqXml, ShBankConstant.CONTENT_TYPE);
            if (StringUtils.isNotBlank(result)) {
                //解析返回数据
                BalanceQueryRes balanceQueryRes = new BalanceQueryRes();
                XmlUtil.parseXml(result, balanceQueryRes, ShBankConstant.XTR0101);
                return balanceQueryRes;
            }
        }
        return null;
    }

    /**
     * 交易明细查询
     *
     * @param tradDetailQueryReq
     * @return
     * @throws Exception
     */
    public TradDetailQueryRes tradDetailQuery(TradDetailQueryReq tradDetailQueryReq) throws Exception {
        //获取请求的xml字符串
        String reqXml = VelocityUtil.getReqXmlStr(tradDetailQueryReq, ShBankConstant.XTR0102, sysSerialNumberService.generateSerialNumberByModelCode(ShBankConstant.XTR0102));
        if (StringUtils.isNotBlank(reqXml)) {
            //发送请求
            String result = HttpClientUtil.sendRequest(environment.getProperty("shbank.itf.url"), reqXml, ShBankConstant.CONTENT_TYPE);
            if (StringUtils.isNotBlank(result)) {
                //解析返回数据
                TradDetailQueryRes tradDetailQueryRes = new TradDetailQueryRes();
                XmlUtil.parseXml(result, tradDetailQueryRes, ShBankConstant.XTR0102);
                return tradDetailQueryRes;
            }
        }
        return null;
    }

    /**
     * 交易状态查询
     *
     * @param tradStatusQueryReq
     * @return
     * @throws Exception
     */
    public TradStatusQueryRes tradStatusQuery(TradStatusQueryReq tradStatusQueryReq) throws Exception {
        //获取请求的xml字符串
        String reqXml = VelocityUtil.getReqXmlStr(tradStatusQueryReq, ShBankConstant.XTR0103, sysSerialNumberService.generateSerialNumberByModelCode(ShBankConstant.XTR0103));
        if (StringUtils.isNotBlank(reqXml)) {
            //发送请求
            String result = HttpClientUtil.sendRequest(environment.getProperty("shbank.itf.url"), reqXml, ShBankConstant.CONTENT_TYPE);
            if (StringUtils.isNotBlank(result)) {
                //解析返回数据
                TradStatusQueryRes tradStatusQueryRes = new TradStatusQueryRes();
                XmlUtil.parseXml(result, tradStatusQueryRes, ShBankConstant.XTR0103);
                return tradStatusQueryRes;
            }
        }
        return null;
    }

    /**
     * 账户信息查询
     *
     * @param accountInfoQueryReq
     * @return
     * @throws Exception
     */
    public AccountInfoQueryRes accountInfoQuery(AccountInfoQueryReq accountInfoQueryReq) throws Exception {
        //获取请求的xml字符串
        String reqXml = VelocityUtil.getReqXmlStr(accountInfoQueryReq, ShBankConstant.XTR0104, sysSerialNumberService.generateSerialNumberByModelCode(ShBankConstant.XTR0104));
        if (StringUtils.isNotBlank(reqXml)) {
            //发送请求
            String result = HttpClientUtil.sendRequest(environment.getProperty("shbank.itf.url"), reqXml, ShBankConstant.CONTENT_TYPE);
            if (StringUtils.isNotBlank(result)) {
                //解析返回数据
                AccountInfoQueryRes accountInfoQueryRes = new AccountInfoQueryRes();
                XmlUtil.parseXml(result, accountInfoQueryRes, ShBankConstant.XTR0104);
                return accountInfoQueryRes;
            }
        }
        return null;
    }

    /**
     * 流水打印申请
     *
     * @param waterPrintReq
     * @return
     * @throws Exception
     */
    public WaterPrintRes waterPrint(WaterPrintReq waterPrintReq) throws Exception {
        //获取请求的xml字符串
        String reqXml = VelocityUtil.getReqXmlStr(waterPrintReq, ShBankConstant.XTR0105, sysSerialNumberService.generateSerialNumberByModelCode(ShBankConstant.XTR0105));
        if (StringUtils.isNotBlank(reqXml)) {
            //发送请求
            String result = HttpClientUtil.sendRequest(environment.getProperty("shbank.itf.url"), reqXml, ShBankConstant.CONTENT_TYPE);
            if (StringUtils.isNotBlank(result)) {
                //解析返回数据
                WaterPrintRes waterPrintRes = new WaterPrintRes();
                XmlUtil.parseXml(result, waterPrintRes, ShBankConstant.XTR0105);
                return waterPrintRes;
            }
        }
        return null;
    }
}
