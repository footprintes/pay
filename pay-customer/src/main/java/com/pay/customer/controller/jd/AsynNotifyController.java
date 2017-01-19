package com.pay.customer.controller.jd;

import com.jd.jr.pay.gate.signature.util.JdPayUtil;
import com.pay.api.domain.jd.AsynNotifyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>异步通知受理类</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2016/12/2 10:50
 */
@Controller
public class AsynNotifyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsynNotifyController.class);

//    @Resource
//    private HttpServletRequest request;

    @Resource
    private Environment environment;

    /**
     * 异步通知受理
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/asynNotify.htm", method = RequestMethod.POST)
    public String execute(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));
            String line = null;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            LOGGER.info("异步通知原始数据:" + sb);
        } catch (IOException e) {
            LOGGER.error("异步通知原始数据异常:" + e);
            return "fail";
        }

        String deskey = environment.getProperty("wepay.merchant.desKey");
        String pubKey = environment.getProperty("wepay.jd.rsaPublicKey");
        try {
            AsynNotifyResponse anRes = JdPayUtil.parseResp(pubKey, deskey, sb.toString(), AsynNotifyResponse.class);
            LOGGER.info("异步通知解析数据:" + anRes);
            LOGGER.info("异步通知订单号：" + anRes.getTradeNum() + ",状态：" + anRes.getStatus() + "成功!!!!");

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return "fail";
        }
        return "ok";
    }
}
