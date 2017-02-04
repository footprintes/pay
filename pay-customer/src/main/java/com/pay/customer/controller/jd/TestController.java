package com.pay.customer.controller.jd;

import com.pay.api.domain.shyh.request.AccountInfoQueryReq;
import com.pay.api.domain.shyh.request.BalanceQueryReq;
import com.pay.api.domain.shyh.request.BindCardChangeReq;
import com.pay.api.domain.shyh.request.OnlineAccountReq;
import com.pay.api.domain.shyh.response.AccountInfoQueryRes;
import com.pay.api.domain.shyh.response.BalanceQueryRes;
import com.pay.api.domain.shyh.response.BindCardChangeRes;
import com.pay.api.domain.shyh.response.OnlineAccountRes;
import com.pay.api.service.shyh.ShBankService;
import com.pay.api.service.sys.HelloService;
import com.pay.api.service.sys.SysSerialNumberService;
import com.pay.comm.constant.ShBankConstant;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/16 14:03
 */
@RefreshScope
@RestController
public class TestController {

    @MotanReferer(basicReferer = "basicRefererConfig")
    private HelloService helloService;

    @MotanReferer(basicReferer = "basicRefererConfig")
    private ShBankService shBankService;

    @MotanReferer(basicReferer = "basicRefererConfig")
    private SysSerialNumberService sysSerialNumberService;

    @Resource
    private Environment environment;

//    @Value("${comTest}")
//    private String comTest;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() throws Exception {
        return helloService.hello();
    }

    /**
     * 联机开户
     *
     * @return
     */
    @RequestMapping(value = "onlineAccount", method = RequestMethod.GET)
    @ResponseBody
    public OnlineAccountRes onlineAccount() throws Exception {
        OnlineAccountReq onlineAccountReq = new OnlineAccountReq();
        //合作方客户号
        onlineAccountReq.setCoopCustNo(sysSerialNumberService.generateSerialNumberByModelCode(ShBankConstant.XTR0001));
        //理财产品参数
        onlineAccountReq.setProductCd("xtrBalFinancing");
        //姓名
        onlineAccountReq.setCustName("张峰");
        //身份证号
        onlineAccountReq.setIdNo("430421199003192752");
        //证件到期日
        onlineAccountReq.setExpDay("20211220");
        //手机号
        onlineAccountReq.setMobllePhone("17775649963");
        //绑定银行卡号
        onlineAccountReq.setBindCardNo("6226200203289004");
        //银行卡预留手机号
        onlineAccountReq.setReservedPhone("17775649963");
        //是否开通余额理财功能
        onlineAccountReq.setSign("N");
        //基金代码
        onlineAccountReq.setFundCode("");
        //邮箱
        onlineAccountReq.setEmail("zfvip_it@163.com");
        //家庭住址
        onlineAccountReq.setHomeAddr("");
        //职业
        onlineAccountReq.setOccupation("");
        return shBankService.onlineAccount(onlineAccountReq);
    }

    /**
     * 绑定卡变更
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "bindCardChange", method = RequestMethod.GET)
    @ResponseBody
    public BindCardChangeRes bindCardChange() throws Exception {
        BindCardChangeReq bindCardChangeReq = new BindCardChangeReq();
        //子账号
        bindCardChangeReq.setSubAcctNo("623185009900000305");
        //产品参数
        bindCardChangeReq.setProductCd("xtrBalFinancing");
        //姓名
        bindCardChangeReq.setCustName("张峰");
        //身份证号
        bindCardChangeReq.setIdNo("430421199003192752");
        //原绑定银行卡号
        bindCardChangeReq.setBindCardNo("6226200203289004");
        //新绑定银行卡号
        bindCardChangeReq.setNewCardNo("6226200203289005");
        //银行卡预留手机号
        bindCardChangeReq.setReservedPhone("17775649963");
        //新银行卡预留手机号
        bindCardChangeReq.setNewReservedPhone("17775649963");
        //修改类型
        bindCardChangeReq.setModiType("00");
        return shBankService.bindCardChange(bindCardChangeReq);
    }

    /**
     * 资产查询-账户余额
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "balanceQuery", method = RequestMethod.GET)
    @ResponseBody
    public BalanceQueryRes balanceQuery() throws Exception{
        BalanceQueryReq balanceQueryReq = new BalanceQueryReq();
        //余额理财子账号
        balanceQueryReq.setSubAcctNo("623185009900000305");
        return shBankService.balanceQuery(balanceQueryReq);
    }

    /**
     * 账户信息查询
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "accountInfoQuery", method = RequestMethod.GET)
    @ResponseBody
    public AccountInfoQueryRes accountInfoQuery() throws Exception {
        AccountInfoQueryReq accountInfoQueryReq = new AccountInfoQueryReq();
        //E账户主账户号
        accountInfoQueryReq.setEacctNo("623185009000136058");
        //客户身份证
        accountInfoQueryReq.setIdNo("430421199003192752");
        //产品参数
        accountInfoQueryReq.setProductParam("");
        //子账户
        accountInfoQueryReq.setSubAcctNo("");
        return shBankService.accountInfoQuery(accountInfoQueryReq);
    }


}
