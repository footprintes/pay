package com.pay.core.controller.jd;

import com.jd.jr.pay.gate.signature.util.JdPayUtil;
import com.pay.api.domain.jd.RefundResponse;
import com.pay.api.domain.jd.TradeRefundReqDto;
import com.pay.comm.basic.ResultResponse;
import com.pay.comm.util.CertUtil;
import com.pay.comm.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>发起退款</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2016/11/30 14:31
 */
@Controller
public class RefundOrderController {

    //    http://127.0.0.1:8081/queryOrder.htm?version=V2.0&merchant=22294531&tradeNum=1480485392861&oTradeNum=1480485392860&tradeTime=20161130135632&amount=1&currency=CNY&notifyUrl=http://localhost:8080/asynNotify.htm&note=交易备注&tradeType=0

    private static final Logger LOGGER = LoggerFactory.getLogger(RefundOrderController.class);

    @Resource
    private Environment environment;

    /**
     * 订单退款
     *
     * @param tradeRefundReqDto
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/refundOrder.htm", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse paySign(TradeRefundReqDto tradeRefundReqDto, HttpServletRequest httpServletRequest) {
        ResultResponse resultResponse = new ResultResponse();
        LOGGER.info("TradeRefundReqDto:" + tradeRefundReqDto);
        String deskey = environment.getProperty("wepay.merchant.desKey");
        String priKey = environment.getProperty("wepay.merchant.rsaPrivateKey");
        String pubKey = environment.getProperty("wepay.jd.rsaPublicKey");
        String cert = CertUtil.getCert();
        // 有证书则证书验证模式、无则配置模式
        if (cert != null && !cert.equals("")) {
            tradeRefundReqDto.setCert(cert);
        }

        try {
            String tradeXml = JdPayUtil.genReqXml(tradeRefundReqDto, priKey, deskey);
            LOGGER.info("tradeXml:" + tradeXml);
            String refundUrl = environment.getProperty("wepay.server.refund.url");

            String resultJsonData = HttpClientUtil.sendRequest(refundUrl, tradeXml, "application/xml");
            LOGGER.info("resultJsonData:" + resultJsonData);

            RefundResponse refundResponse = JdPayUtil.parseResp(pubKey, deskey, resultJsonData, RefundResponse.class);
            LOGGER.info("refundResponse:" + refundResponse);

            resultResponse.setData(refundResponse);
            resultResponse.setSuccess(true);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return resultResponse;
    }
}
