package com.pay.customer;

import com.alibaba.fastjson.JSON;
import com.pay.api.domain.shyh.request.BindCardChangeReq;
import com.pay.api.domain.shyh.request.OnlineAccountReq;
import com.pay.api.service.sys.HelloService;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/12 14:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)// 指定spring-boot的启动类
public class SpringBootTest {

    private static Logger LOGGER = LoggerFactory.getLogger(SpringBootTest.class);

    @MotanReferer(basicReferer = "basicRefererConfig")
    private HelloService helloService;

//    @MotanReferer(basicReferer = "basicRefererConfig")
//    private ShBankService shBankService;
//
//    @MotanReferer(basicReferer = "basicRefererConfig")
//    private SysSerialNumberService sysSerialNumberService;

    @Resource
    Environment environment;

    @Test
    public void jdTest() throws ExecutionException, InterruptedException {
        LOGGER.info(JSON.toJSONString(helloService.hello()));
    }

    /**
     * 联机开户
     *
     * @return
     */
    @Test
    public void onlineAccount() {
        OnlineAccountReq onlineAccountReq = new OnlineAccountReq();
        //合作方客户号
//        onlineAccountReq.setCoopCustNo(sysSerialNumberService.generateSerialNumberByModelCode(ShBankConstant.XTR0001));
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
//            System.out.println(JSON.toJSONString(shBankService.onlineAccount(onlineAccountReq)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 绑定卡变更
     *
     * @return
     * @throws Exception
     */
    public void bindCardChange() {
        BindCardChangeReq bindCardChangeReq = new BindCardChangeReq();
    }
}
