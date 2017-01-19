package com.pay.core.controller.jd;


import com.jd.jr.pay.gate.signature.util.BASE64;
import com.jd.jr.pay.gate.signature.util.SignUtil;
import com.jd.jr.pay.gate.signature.util.ThreeDesUtil;
import com.pay.api.domain.jd.JdPayOrder;
import com.pay.api.service.jd.JdPayOrderService;
import com.pay.comm.basic.BaseController;
import com.pay.comm.util.CertUtil;
import com.pay.comm.util.DateUtil;
import com.pay.comm.util.StringEscape;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>创建支付订单</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2016/11/30 14:28
 */
@Controller
public class PayOrderController extends BaseController {

//    http://127.0.0.1:8081/showPayPage.htm?version=V2.0&merchant=22294531&device=111&tradeNum=1480485392860&tradeName=商品1111&tradeDesc=交易描述&tradeTime=20161213103532&amount=1&currency=CNY&note=备注&callbackUrl=http://localhost:8080/success.htm&notifyUrl=http://localhost:8080/asynNotify.htm&orderType=1&tradeType=0
//   {"amount":"1","callbackUrl":"http://localhost:8080/success.htm","currency":"CNY","device":"111","ip":"10.45.251.153","merchant":"22294531","note":"备注","notifyUrl":"http://localhost:8080/asynNotify.htm","orderType":"1","tradeDesc":"交易描述","tradeName":"商品1111","tradeNum":"1480485392869","tradeTime":"20161130135632","version":"V2.0"}

    private static Logger LOGGER = LoggerFactory.getLogger(PayOrderController.class);

    @Resource
    private JdPayOrderService jdPayOrderService;

    @Resource
    private Environment environment;

    /**
     * @param mav
     * @param jdPayOrder
     * @return
     */
    @RequestMapping(value = "/showPayPage")
    public ModelAndView showPayPage(ModelAndView mav, JdPayOrder jdPayOrder) {
        //交易商户
        jdPayOrder.setMerchant(environment.getProperty("wepay.merchant.num"));
        //交易时间
        jdPayOrder.setTradeTime(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
        //交易流水号
        String tradeNum = UUID.randomUUID().toString();
        tradeNum = tradeNum.replaceAll("-", "");
        jdPayOrder.setTradeNum(tradeNum);
        mav.addObject("jdPayOrder", jdPayOrder);
        mav.setViewName("jd/payStart");
        return mav;
    }

    /**
     * 自动创建并显示订单
     *
     * @param mav
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/clientOrder", method = RequestMethod.POST)
    public ModelAndView pay(ModelAndView mav, HttpServletRequest request) throws Exception {
        JdPayOrder jdPayOrder = getJdPayOrder(request);
        filterCharProcess(jdPayOrder);
        //新增京东支付订单记录
        jdPayOrderService.insertSelective(jdPayOrder);
        String priKey = environment.getProperty("wepay.merchant.rsaPrivateKey");
        String desKey = environment.getProperty("wepay.merchant.desKey");
        String cert = CertUtil.getCert();
        // 有证书则证书验证模式、无则配置模式
        if (cert != null && !cert.equals("")) {
            jdPayOrder.setCert(cert);
        }
        List<String> unSignedKeyList = new ArrayList<String>();
        unSignedKeyList.add("sign");
        jdPayOrder.setSign(SignUtil.signRemoveSelectedKeys(jdPayOrder, priKey, unSignedKeyList));
        byte[] key = BASE64.decode(desKey);
        //数据转换
        jdPayOrder = encrypt2HexStr(key, jdPayOrder);

        mav.addObject("payOrderInfo", jdPayOrder);
        mav.addObject("payUrl", environment.getProperty("jd.pay.url"));
        mav.setViewName("jd/autoSubmit");
        return mav;
    }

    /**
     * 获取参数对象
     *
     * @param request
     * @return
     */
    private JdPayOrder getJdPayOrder(HttpServletRequest request) {
        JdPayOrder jdPayOrder = new JdPayOrder();
        jdPayOrder.setVersion(request.getParameter("version"));
        jdPayOrder.setMerchant(request.getParameter("merchant"));
        jdPayOrder.setDevice(request.getParameter("device"));
        jdPayOrder.setTradeNum(request.getParameter("tradeNum"));
        jdPayOrder.setTradeName(request.getParameter("tradeName"));
        jdPayOrder.setTradeDesc(request.getParameter("tradeDesc"));
        jdPayOrder.setTradeTime(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
        jdPayOrder.setAmount(request.getParameter("amount"));
        jdPayOrder.setCurrency(request.getParameter("currency"));
        jdPayOrder.setNote(request.getParameter("note"));
        jdPayOrder.setCallbackUrl(request.getParameter("callbackUrl"));
        jdPayOrder.setNotifyUrl(request.getParameter("notifyUrl"));
//        jdPayOrder.setIp(request.getParameter("ip"));
        jdPayOrder.setIp(request.getRemoteAddr());
        jdPayOrder.setUserType(request.getParameter("userType"));
        jdPayOrder.setUserId(request.getParameter("userId"));
        jdPayOrder.setExpireTime(request.getParameter("expireTime"));
        jdPayOrder.setOrderType(request.getParameter("orderType"));
        jdPayOrder.setIndustryCategoryCode(request.getParameter("industryCategoryCode"));
        jdPayOrder.setSpecCardNo(request.getParameter("specCardNo"));
        jdPayOrder.setSpecId(request.getParameter("specId"));
        jdPayOrder.setSpecName(request.getParameter("specName"));

        jdPayOrder.setVendorId(request.getParameter("vendorId"));
        jdPayOrder.setGoodsInfo(request.getParameter("goodsInfo"));
        jdPayOrder.setOrderGoodsNum(request.getParameter("orderGoodsNum"));
        jdPayOrder.setTermInfo(request.getParameter("termInfo"));
        jdPayOrder.setReceiverInfo(request.getParameter("receiverInfo"));
        return jdPayOrder;
    }

    /**
     * 数据转换
     *
     * @param key
     * @param jdPayOrder
     * @return
     */
    private JdPayOrder encrypt2HexStr(byte[] key, JdPayOrder jdPayOrder) {
        if (StringUtils.isNotBlank(jdPayOrder.getDevice())) {
            jdPayOrder.setDevice(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getDevice()));
        }
        jdPayOrder.setTradeNum(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getTradeNum()));
        if (StringUtils.isNotBlank(jdPayOrder.getTradeName())) {
            jdPayOrder.setTradeName(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getTradeName()));
        }
        if (StringUtils.isNotBlank(jdPayOrder.getTradeDesc())) {
            jdPayOrder.setTradeDesc(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getTradeDesc()));
        }
        jdPayOrder.setTradeTime(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getTradeTime()));
        jdPayOrder.setAmount(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getAmount()));
        jdPayOrder.setCurrency(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getCurrency()));
        if (StringUtils.isNotBlank(jdPayOrder.getNote())) {
            jdPayOrder.setNote(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getNote()));
        }
        jdPayOrder.setCallbackUrl(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getCallbackUrl()));
        jdPayOrder.setNotifyUrl(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getNotifyUrl()));
        jdPayOrder.setIp(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getIp()));
        if (StringUtils.isNotBlank(jdPayOrder.getUserType())) {
            jdPayOrder.setUserType(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getUserType()));
        }
        if (StringUtils.isNotBlank(jdPayOrder.getUserId())) {
            jdPayOrder.setUserId(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getUserId()));
        }
        if (StringUtils.isNotBlank(jdPayOrder.getExpireTime())) {
            jdPayOrder.setExpireTime(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getExpireTime()));
        }
        if (StringUtils.isNotBlank(jdPayOrder.getOrderType())) {
            jdPayOrder.setOrderType(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getOrderType()));
        }
        if (StringUtils.isNotBlank(jdPayOrder.getIndustryCategoryCode())) {
            jdPayOrder
                    .setIndustryCategoryCode(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getIndustryCategoryCode()));
        }

        if (StringUtils.isNotBlank(jdPayOrder.getSpecCardNo())) {
            jdPayOrder.setSpecCardNo(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getSpecCardNo()));
        }
        if (StringUtils.isNotBlank(jdPayOrder.getSpecId())) {
            jdPayOrder.setSpecId(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getSpecId()));
        }
        if (StringUtils.isNotBlank(jdPayOrder.getSpecName())) {
            jdPayOrder.setSpecName(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getSpecName()));
        }
        if (StringUtils.isNotBlank(jdPayOrder.getVendorId())) {
            jdPayOrder.setVendorId(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getVendorId()));
        }
        if (StringUtils.isNotBlank(jdPayOrder.getGoodsInfo())) {
            jdPayOrder.setGoodsInfo(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getGoodsInfo()));
        }
        if (StringUtils.isNotBlank(jdPayOrder.getOrderGoodsNum())) {
            jdPayOrder.setOrderGoodsNum(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getOrderGoodsNum()));
        }
        if (StringUtils.isNotBlank(jdPayOrder.getTermInfo())) {
            jdPayOrder.setTermInfo(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getTermInfo()));
        }
        if (StringUtils.isNotBlank(jdPayOrder.getReceiverInfo())) {
            jdPayOrder.setReceiverInfo(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getReceiverInfo()));
        }

        if (StringUtils.isNotBlank(jdPayOrder.getCert())) {
            jdPayOrder.setCert(ThreeDesUtil.encrypt2HexStr(key, jdPayOrder.getCert()));
        }
        return jdPayOrder;
    }

    /**
     * 特殊字符处理
     *
     * @param jdPayOrder
     */
    private void filterCharProcess(JdPayOrder jdPayOrder) {
        jdPayOrder.setVersion(doFilterCharProcess(jdPayOrder.getVersion()));
        jdPayOrder.setMerchant(doFilterCharProcess(jdPayOrder.getMerchant()));
        jdPayOrder.setDevice(doFilterCharProcess(jdPayOrder.getDevice()));
        jdPayOrder.setTradeNum(doFilterCharProcess(jdPayOrder.getTradeNum()));
        jdPayOrder.setTradeName(doFilterCharProcess(jdPayOrder.getTradeName()));
        jdPayOrder.setTradeDesc(doFilterCharProcess(jdPayOrder.getTradeDesc()));
        jdPayOrder.setTradeTime(doFilterCharProcess(jdPayOrder.getTradeTime()));
        jdPayOrder.setAmount(doFilterCharProcess(jdPayOrder.getAmount()));
        jdPayOrder.setCurrency(doFilterCharProcess(jdPayOrder.getCurrency()));
        jdPayOrder.setNote(doFilterCharProcess(jdPayOrder.getNote()));
        jdPayOrder.setCallbackUrl(doFilterCharProcess(jdPayOrder.getCallbackUrl()));
        jdPayOrder.setNotifyUrl(doFilterCharProcess(jdPayOrder.getNotifyUrl()));
        jdPayOrder.setIp(doFilterCharProcess(jdPayOrder.getIp()));
        jdPayOrder.setUserType(doFilterCharProcess(jdPayOrder.getUserType()));
        jdPayOrder.setUserId(doFilterCharProcess(jdPayOrder.getUserId()));
        jdPayOrder.setExpireTime(doFilterCharProcess(jdPayOrder.getExpireTime()));
        jdPayOrder.setOrderType(doFilterCharProcess(jdPayOrder.getOrderType()));
        jdPayOrder.setIndustryCategoryCode(doFilterCharProcess(jdPayOrder.getIndustryCategoryCode()));
        jdPayOrder.setSpecCardNo(doFilterCharProcess(jdPayOrder.getSpecCardNo()));
        jdPayOrder.setSpecId(doFilterCharProcess(jdPayOrder.getSpecId()));
        jdPayOrder.setSpecName(doFilterCharProcess(jdPayOrder.getSpecName()));

        jdPayOrder.setVendorId(doFilterCharProcess(jdPayOrder.getVendorId()));
        jdPayOrder.setGoodsInfo(doFilterCharProcess(jdPayOrder.getGoodsInfo()));
        jdPayOrder.setOrderGoodsNum(doFilterCharProcess(jdPayOrder.getOrderGoodsNum()));
        jdPayOrder.setTermInfo(doFilterCharProcess(jdPayOrder.getTermInfo()));
        jdPayOrder.setReceiverInfo(doFilterCharProcess(jdPayOrder.getReceiverInfo()));
    }

    /**
     * 执行特殊字符处理
     *
     * @param param
     * @return
     */
    private String doFilterCharProcess(String param) {
        if (param == null || param.equals("")) {
            return param;
        } else {
            return StringEscape.htmlSecurityEscape(param);
        }
    }

    @RequestMapping("test.htm")
    public void test() {
        JdPayOrder jdPayOrder = new JdPayOrder();
        jdPayOrder.setVersion("V2.0");
        jdPayOrder.setMerchant("123123");
        jdPayOrder.setTradeNum("12312312321");
        jdPayOrder.setTradeName("交易名称");
        jdPayOrder.setTradeDesc("交易描述");
        jdPayOrder.setTradeTime(DateUtil.date2String(new Date(), DateUtil.DATETIMENOSPLITFORMAT));
        jdPayOrder.setAmount("100");
        jdPayOrder.setOrderType("1");
        jdPayOrder.setCurrency("CNY");
        jdPayOrder.setCallbackUrl("支付成功后跳转的URL");
        jdPayOrder.setNotifyUrl("支付完成后，异步通知商户服务相关支付结果");
        jdPayOrder.setIp("127.0.0.1");
        jdPayOrderService.insertSelective(jdPayOrder);
    }
}
