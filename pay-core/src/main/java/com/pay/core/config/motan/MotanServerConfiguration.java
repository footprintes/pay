package com.pay.core.config.motan;

import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.BasicServiceConfigBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * <p>motan服务端配置</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/16 13:33
 */
@Configuration
public class MotanServerConfiguration {

    @Resource
    private Environment environment;

    @Bean
    public AnnotationBean motanAnnotationBean() {
        AnnotationBean motanAnnotationBean = new AnnotationBean();
        motanAnnotationBean.setPackage("com.pay.core.service");
        return motanAnnotationBean;
    }

    @Bean(name = "motan")
    public ProtocolConfigBean protocolConfig1() {
        ProtocolConfigBean config = new ProtocolConfigBean();
        config.setDefault(true);
        config.setName("motan");
        config.setMaxContentLength(5048576);
        return config;
    }

    @Bean(name = "registry")
    public RegistryConfigBean registryConfig() {
        RegistryConfigBean config = new RegistryConfigBean();
        config.setRegProtocol("zookeeper");
        config.setAddress("127.0.0.1:2181");
//        config.setConnectTimeout(200000);
        return config;
    }

    @Bean
    public BasicServiceConfigBean baseServiceConfig() {
        BasicServiceConfigBean config = new BasicServiceConfigBean();
        config.setExport("motan:8003");
        config.setRegistry("registry");
        config.setAccessLog(false);
        config.setShareChannel(true);
        config.setRequestTimeout(200000);
        config.setUsegz(true);
        return config;
    }
}
