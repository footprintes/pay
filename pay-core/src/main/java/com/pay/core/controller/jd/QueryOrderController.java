package com.pay.core.controller.jd;

import com.jd.jr.pay.gate.signature.util.JdPayUtil;
import com.pay.api.domain.jd.PaymentTradeResponse;
import com.pay.api.domain.jd.QueryRefundResponse;
import com.pay.api.domain.jd.TradeQueryInner;
import com.pay.api.domain.jd.TradeQueryReqDto;
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
 * <p>交易查询-消费、退款</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2016/11/30 14:31
 */
@Controller
public class QueryOrderController {

//    http://127.0.0.1:8081/queryOrder.htm?version=V2.0&merchant=22294531&tradeNum=1480485392860&tradeType=0

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryOrderController.class);

    @Resource
    private Environment environment ;

    /**
     * 订单查询
     *
     * @param tradeQueryReqDto
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/queryOrder.htm", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse paySign(TradeQueryReqDto tradeQueryReqDto, HttpServletRequest httpServletRequest) {
        ResultResponse resultResponse = new ResultResponse();
        String tradeType = tradeQueryReqDto.getTradeType();

        String deskey = environment.getProperty("wepay.merchant.desKey");
        String priKey = environment.getProperty("wepay.merchant.rsaPrivateKey");
        String pubKey = environment.getProperty("wepay.jd.rsaPublicKey");
        String cert = CertUtil.getCert();

        TradeQueryInner queryTradeDTO = new TradeQueryInner();
        queryTradeDTO.setVersion(tradeQueryReqDto.getVersion());
        queryTradeDTO.setMerchant(tradeQueryReqDto.getMerchantNum());
        queryTradeDTO.setoTradeNum(tradeQueryReqDto.getoTradeNum());
        queryTradeDTO.setTradeNum(tradeQueryReqDto.getTradeNum());
        queryTradeDTO.setTradeType(tradeType); // 0:消费 1：退款
        // 有证书则证书验证模式、无则配置模式
        if (cert != null && !cert.equals("")) {
            queryTradeDTO.setCert(cert);
        }
        try {
            String xml = JdPayUtil.genReqXml(queryTradeDTO, priKey, deskey);
            LOGGER.info("query xml:" + xml);
            String queryUrl = environment.getProperty("wepay.server.query.url");
            String rs = HttpClientUtil.sendRequest(queryUrl, xml, "application/xml");
            LOGGER.info("result:" + rs);

            if (tradeType.equals("0")) {// 解析消费报文
                PaymentTradeResponse paymentTradeResponse = JdPayUtil.parseResp(pubKey, deskey, rs, PaymentTradeResponse.class);
                paymentTradeResponse.setSign(null);
                LOGGER.info("PaymentTradeResponse:" + paymentTradeResponse);
                resultResponse.setData(paymentTradeResponse);
            } else { // 解析退款报文
                QueryRefundResponse queryRefundResponse = JdPayUtil.parseResp(pubKey, deskey, rs, QueryRefundResponse.class);
                queryRefundResponse.setSign(null);
                LOGGER.info("QueryRefundResponse:" + queryRefundResponse);
                resultResponse.setData(queryRefundResponse);
            }
            resultResponse.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultResponse;
    }
}
