package com.pay.core.util;

import com.koalii.svs.SvsSign;
import com.koalii.svs.SvsVerify;
import com.pay.api.domain.shyh.request.BalanceQueryReq;
import com.pay.comm.util.DateUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/20 13:49
 */
public class VelocityUtil {

    private static VelocityEngine ve = new VelocityEngine();

    private static SvsSign signer = new SvsSign();

    static {
        try {
            ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
            ve.setProperty(Velocity.FILE_RESOURCE_LOADER_CACHE, "true");
            ve.init();
            signer.initSignCertAndKey(getRootPath() + "/classes/cert/shyh/110310018000011.pfx", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取请求xml字符串
     *
     * @param obj     请求数据对象
     * @param itfName 接口名
     * @param rqUID   请求流水号
     * @return
     * @throws Exception
     */
    public static String getReqXmlStr(Object obj, String itfName, String rqUID) throws Exception {
        VelocityContext context = new VelocityContext();
        //报文头
        context.put("commonRqHdr", getCommonRqHdr(rqUID));
        //接口名称
        context.put("itfName", itfName);
        //证书代码
        context.put("koalB64Cert", getKoalB64Cert());
        //签名数据
        context.put("signature", getSignature(obj, rqUID));
        //对象属性值键值对
        context.put("fieldValueMap", getFieldValueMap(obj));
        Template template = ve.getTemplate("velocity/velocity.vm");
        StringWriter sw = new StringWriter();
        //模板合并，得到期望文件
        template.merge(context, sw);
        return sw.toString();
    }

    /**
     * 获取签名数据
     *
     * @param obj
     * @param rqUID @return
     */
    public static String getSignature(Object obj, String rqUID) throws Exception {
        //获取报文头
        TreeMap<String, String> treeMap = getCommonRqHdr(rqUID);
        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                String value = BeanUtils.getProperty(obj, field.getName());
                if (StringUtils.isNotBlank(value)) {
                    treeMap.put(field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1, field.getName().length()), value);
                }
            }
        }
        //数据转换
        String signature = transformation(treeMap);
        //签名
        return signer.signData(signature.getBytes("GBK"));
    }

    /**
     * 数据转换
     *
     * @param treeMap
     * @return
     */
    private static String transformation(TreeMap<String, String> treeMap) {
        StringBuffer sb = new StringBuffer();
        if (treeMap != null && !treeMap.isEmpty()) {
            for (Map.Entry<String, String> e : treeMap.entrySet()) {
                sb.append(e.getKey());
                sb.append("=");
                sb.append(e.getValue());
                sb.append("&");
            }
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * 获取base64的公钥;
     *
     * @return
     * @throws Exception
     */
    private static String getKoalB64Cert() throws Exception {
        return signer.getEncodedSignCert();
    }

    /**
     * 获取报文头
     *
     * @param rqUID
     * @return
     */
    private static TreeMap<String, String> getCommonRqHdr(String rqUID) {
        //指定排序器
        TreeMap<String, String> treeMap = new TreeMap(new Comparator<String>() {
            public int compare(String o1, String o2) {
                //指定排序器按照升序排列
                return o1.compareTo(o2);
            }
        });
        //服务提供者名称
        treeMap.put("SPName", "CBIB");
        //请求流水号
        treeMap.put("RqUID", rqUID);
        //清算日期
        treeMap.put("ClearDate", DateUtil.getCurrDate(DateUtil.DATESHORTFORMAT));
        //交易日期
        treeMap.put("TranDate", DateUtil.getCurrDate(DateUtil.DATESHORTFORMAT));
        //交易时间
        treeMap.put("TranTime", DateUtil.getCurrDate(DateUtil.TIMESHORTFORMAT));
        //发起渠道号
        treeMap.put("ChannelId", "XTR");
        return treeMap;
    }

    /**
     * 获取对象的属性值键值对
     *
     * @param obj
     * @return
     * @throws Exception
     */
    private static Map<String, Object> getFieldValueMap(Object obj) throws Exception {
        Map<String, Object> map = new HashMap();
        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                map.put(field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1, field.getName().length()), BeanUtils.getProperty(obj, field.getName()));
            }
        }
        return map;
    }

    /**
     * 获取项目的路径
     *
     * @return
     */
    public static String getRootPath() {
        String rootPath = "";
        try {
            File file = new File(VelocityUtil.class.getResource("/").getFile());
            rootPath = file.getParentFile() + "\\";
            rootPath = java.net.URLDecoder.decode(rootPath, "utf-8");
            //System.out.println(rootPath);
            return rootPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootPath;
    }


    public static void main(String args[]) throws Exception {

//        Template template = ve.getTemplate("velocity/velocity.vm");
//        StringWriter sw = new StringWriter();
//        //模板合并，得到期望文件
//        template.merge(null, sw);
//        System.out.println(sw.toString());
//        //指定排序器
//        TreeMap<String, String> treeMap2 = new TreeMap<String, String>(new Comparator<String>() {
//            public int compare(String o1, String o2) {
//                //指定排序器按照升序排列
//                return o1.compareTo(o2);
//            }
//        });
//        treeMap2.put("2", "1");
//        treeMap2.put("b", "1");
//        treeMap2.put("1", "1");
//        treeMap2.put("a", "1");
//        System.out.println("treeMap2=" + treeMap2);
        BalanceQueryReq balanceQueryReq = new BalanceQueryReq();
        balanceQueryReq.setSubAcctNo("11111111111111111111111111111");
        System.out.println(getReqXmlStr(balanceQueryReq, "XTR001", "222222222222222222"));
        System.out.println(getReqXmlStr(balanceQueryReq, "XTR001", "222222222222222222"));
        System.out.println(getReqXmlStr(balanceQueryReq, "XTR001", "222222222222222222"));
        System.out.println(getReqXmlStr(balanceQueryReq, "XTR001", "222222222222222222"));
        System.out.println(getReqXmlStr(balanceQueryReq, "XTR001", "222222222222222222"));
        System.out.println(getReqXmlStr(balanceQueryReq, "XTR001", "222222222222222222"));
    }


}
