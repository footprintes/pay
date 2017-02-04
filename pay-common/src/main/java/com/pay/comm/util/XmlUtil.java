package com.pay.comm.util;

import com.pay.api.domain.shyh.response.CommonRsHdr;
import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/2/3 15:04
 */
public class XmlUtil {

    /**
     * 解析XML
     *
     * @param content
     * @param obj
     * @param itfName
     * @throws Exception
     */
    public static void parseXml(String content, Object obj, String itfName) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new ByteArrayInputStream(content.getBytes("UTF-8")));
        // 获取根元素
        Element root = document.getRootElement();

        // 获取名字为指定名称的第一个子元素
        Element element = root.element(itfName + "Rs");
        List<Element> list = element.elements();
        if (list != null && !list.isEmpty()) {
            for (Element element1 : list) {
                String fieldName = element1.getName().substring(0, 1).toLowerCase() + element1.getName().substring(1, element1.getName().length());
                if ("CommonRsHdr".equals(element1.getName())) {
                    //处理报文头
                    parseHeader(element1, obj);
                } else if ("TxnInfo".equals(element1.getName())) {
                    //组装多条信息
                    parseTxnInfo(element1, obj, itfName);
                } else {
                    BeanUtils.setProperty(obj, fieldName, element1.getText());
                }
            }
        }
    }

    /**
     * 解析报文头部
     *
     * @param element
     * @param obj
     */
    private static void parseHeader(Element element, Object obj) throws Exception {
        List<Element> list = element.elements();
        if (list != null && !list.isEmpty()) {
            CommonRsHdr commonRsHdr = new CommonRsHdr();
            for (Element element1 : list) {
                String fieldName = element1.getName().substring(0, 1).toLowerCase() + element1.getName().substring(1, element1.getName().length());
                BeanUtils.setProperty(commonRsHdr, fieldName, element1.getText());
            }
            BeanUtils.setProperty(obj, "commonRsHdr", commonRsHdr);
        }
    }

    /**
     * 组装多条信息
     *
     * @param element
     * @param obj
     * @param itfName
     * @throws Exception
     */
    private static void parseTxnInfo(Element element, Object obj, String itfName) throws Exception {
        System.out.println(element.getStringValue());
    }
}
