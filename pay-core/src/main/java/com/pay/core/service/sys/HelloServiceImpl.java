package com.pay.core.service.sys;

import com.pay.api.domain.sys.HelloService;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/16 13:40
 */
@MotanService
public class HelloServiceImpl implements HelloService {

    public String hello() {
        return "hello ";
    }
}
