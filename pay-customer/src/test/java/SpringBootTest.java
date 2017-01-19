import com.alibaba.fastjson.JSON;
import com.pay.api.domain.sys.HelloService;
import com.pay.customer.Application;
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

    @Resource
    Environment environment;

    @Test
    public void jdTest() throws ExecutionException, InterruptedException {
        LOGGER.info(JSON.toJSONString(helloService.hello()));
    }
}
