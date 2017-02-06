package com.pay.core.service.sys;

import com.pay.api.service.sys.HelloService;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import com.xtr.api.service.sys.SysSerialNumberService;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/16 13:40
 */
@MotanService
public class HelloServiceImpl implements HelloService {

    @MotanReferer(basicReferer = "basicRefererConfig")
    private SysSerialNumberService sysSerialNumberService;

    public String hello() {
        return "hello ";
    }

    public String generateSerialNumberByModelCode(String moduleCode){
        return sysSerialNumberService.generateSerialNumberByModelCode(moduleCode);
    }
}
