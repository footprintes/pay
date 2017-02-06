import com.alibaba.fastjson.JSON;
import com.pay.api.service.sys.HelloService;
import com.pay.core.Application;
import com.pay.core.mapper.writer.jd.JdPayOrderWriterMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

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

    @Resource
    Environment environment;

    @Resource(name = "writerJdbcTemplate")
    protected JdbcTemplate writerJdbcTemplate;

    @Resource
    private JdPayOrderWriterMapper jdPayOrderMapper;

    @Resource
    private RedisTemplate redisTemplate;

    //    @Resource
//    private SysSerialNumberService sysSerialNumberService;
    @Resource
    private HelloService helloService;

    private ExecutorService pool;

    @Test
    public void jdTest() throws ExecutionException, InterruptedException {
        redisTemplate.opsForValue().set("abcd", "你大爷");
        LOGGER.info(JSON.toJSONString(writerJdbcTemplate.queryForList("select * from jd_pay_order")));
        LOGGER.info("商户交易号" + environment.getProperty("wepay.merchant.num"));
        LOGGER.info(JSON.toJSONString(jdPayOrderMapper.selectAll()));
        LOGGER.info(helloService.generateSerialNumberByModelCode("CS"));
//        LOGGER.info(JSON.toJSONString(jdPayOrderMapper.selectAll().size()));
//        LOGGER.info(JSON.toJSONString(redisTemplate.opsForValue().get("abcd")));
//        LOGGER.info(sysSerialNumberService.generateSerialNumberByModelCode("CS"));
//        LOGGER.info(sysSerialNumberService.generateSerialNumberByModelCode("CS"));
//        LOGGER.info(sysSerialNumberService.generateSerialNumberByModelCode("CS"));
//        LOGGER.info(sysSerialNumberService.generateSerialNumberByModelCode("CS"));
//        LOGGER.info(sysSerialNumberService.generateSerialNumberByModelCode("CS"));
//        LOGGER.info(sysSerialNumberService.generateSerialNumberByModelCode("CS"));
//        LOGGER.info(sysSerialNumberService.generateSerialNumberByModelCode("CS"));
//        LOGGER.info(sysSerialNumberService.generateSerialNumberByModelCode("CS"));
//        LOGGER.info(JSON.toJSONString(sysSerialNumberService.generateSerialNumberByModelCode("CS").length()));
//        LOGGER.info(JSON.toJSONString(redisTemplate.opsForValue().get("CS" + SysSerialNumberServiceImpl.class.getName())));
//        LOGGER.info(JSON.toJSONString(sysSerialNumberService.updatePreMaxNum("DS",100)));
//        Long startTime = System.currentTimeMillis();
//        List<Future> rowResult = new CopyOnWriteArrayList<>();
//        pool = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 100000; i++) {
//            rowResult.add(pool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    LOGGER.info(sysSerialNumberService.generateSerialNumberByModelCode("CS"));
////                    LOGGER.info(sysSerialNumberService.generateSerialNumberByModelCode("DS"));
//                }
//            }));
//        }
//        //等待处理结果
//        for (Future f : rowResult) {
//            f.get();
//        }
//        //启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用
//        pool.shutdown();
//
//        LOGGER.info("执行时间：" + DateUtil.dateDiff(startTime, System.currentTimeMillis()));
    }
}
