package com.pay.customer.controller.jd;

import com.pay.api.service.sys.HelloService;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import org.springframework.beans.factory.annotation.Value;
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

    @Resource
    private Environment environment;

//    @Value("${comTest}")
//    private String comTest;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() throws Exception {
        return helloService.hello();
    }

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public String test(){
//        return comTest;
//    }
}
