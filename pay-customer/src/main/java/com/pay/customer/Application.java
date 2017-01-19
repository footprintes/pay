package com.pay.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * <p>服务启动类</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2016/10/28 10:16
 */
@RefreshScope
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
