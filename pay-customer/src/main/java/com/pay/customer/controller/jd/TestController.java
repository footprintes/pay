package com.pay.customer.controller.jd;

import com.alibaba.fastjson.JSON;
import com.pay.api.domain.shyh.request.OnlineAccountReq;
import com.pay.api.service.shyh.ShBankService;
import com.pay.api.service.sys.HelloService;
import com.pay.api.service.sys.SysSerialNumberService;
import com.pay.comm.constant.ShBankConstant;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public void onlineAccount() {
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
        try {
            System.out.println(JSON.toJSONString(shBankService.onlineAccount(onlineAccountReq)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
