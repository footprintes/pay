import com.koalii.svs.SvsSign;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class HttpUtil {

    public static String http(String url, Map<String, String> params) {
        URL u = null;
        HttpURLConnection con = null;
        // 构建请求参数  
        StringBuffer sb = new StringBuffer();
        if (params != null) {
            for (Entry<String, String> e : params.entrySet()) {
                sb.append(e.getKey());
                sb.append("=");
                sb.append(e.getValue());
                sb.append("&");
            }
            sb.substring(0, sb.length() - 1);
        }
//        sb.append("?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<BOSFXII xmlns=\"http://www.bankofshanghai.com/BOSFX/2010/08\">\n" +
//                "\t<XTR0001Rq>\n" +
//                "\t\t<CommonRqHdr>\n" +
//                "\t\t\t<SPName>CBIB</SPName>\n" +
//                "\t\t\t<RqUID>2016122009592668518832</RqUID>\n" +
//                "\t\t\t<ClearDate>20161220</ClearDate>\n" +
//                "\t\t\t<TranDate>20161220</TranDate>\n" +
//                "\t\t\t<TranTime>095926</TranTime>\n" +
//                "\t\t\t<ChannelId>XTR</ChannelId>\n" +
//                "\t\t</CommonRqHdr>\n" +
//                "\t\t<Occupation/>\n" +
//                "\t\t<HomeAddr/>\n" +
//                "\t\t<Email/>\n" +
//                "\t\t<FundCode>000359</FundCode>\n" +
//                "\t\t<Sign>Y</Sign>\n" +
//                "\t\t<ReservedPhone>13564610082</ReservedPhone>\n" +
//                "\t\t<BindCardNo>6228481098503995145</BindCardNo>\n" +
//                "\t\t<MobllePhone>13564610082</MobllePhone>\n" +
//                "\t\t<ExpDay>20201212</ExpDay>\n" +
//                "\t\t<IdNo>222121198512282918</IdNo>\n" +
//                "\t\t<CustName>test</CustName>\n" +
//                "\t\t<ProductCd>xtrBalFinancing</ProductCd>\n" +
//                "\t\t<CoopCustNo>842112345678901</CoopCustNo>\n" +
//                "\t\t<KoalB64Cert>MIID3TCCAsWgAwIBAgIQEAAAAAAAAAAAAAAgFgWEAjANBgkqhkiG9w0BAQUFADBZMQswCQYDVQQG\n" +
//                "\t\t\tEwJDTjEwMC4GA1UEChMnQ2hpbmEgRmluYW5jaWFsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MRgw\n" +
//                "\t\t\tFgYDVQQDEw9DRkNBIFRFU1QgT0NBMTEwHhcNMTYwNzE0MDg0ODA3WhcNMTcwNzEzMTYwMDAwWjCB\n" +
//                "\t\t\tqDELMAkGA1UEBhMCQ04xFTATBgNVBAoTDENGQ0EgVEVTVCBDQTENMAsGA1UECxMES09BTDESMBAG\n" +
//                "\t\t\tA1UECxMJQ3VzdG9tZXJzMV8wXQYDVQQDDFYwNDFAWjIwMTYwNzE0MTAwOTA0M0BtMTEwMzEwMDE4\n" +
//                "\t\t\tMDAwMDExJOa3seWcs+W4gumjnuaziemHkeiejeacjeWKoeaciemZkOWFrOWPuEAwMDAwMDAwMjCB\n" +
//                "\t\t\tnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA1zt9RuKyrLgnQCWFkq/BpBCZTcc4hjHLvd2oulOC\n" +
//                "\t\t\tpdQvstCWG4tlo0RBLR6+oT2i1HfYZj/ohBvPceMltGVZ4EHcgyZptQZvbVMwM3yglDFu5IDm2Kyb\n" +
//                "\t\t\tEyzF9YbtyZK9hwSeb7YjO9vHqrGbbTFC0tX3R2e/gPf0X6IXaYxCjXsCAwEAAaOB1DCB0TAfBgNV\n" +
//                "\t\t\tHSMEGDAWgBT8C7xEmg4xoYOpgYcnHgVCxr9W+DAJBgNVHRMEAjAAMDoGA1UdHwQzMDEwL6AtoCuG\n" +
//                "\t\t\tKWh0dHA6Ly8yMTAuNzQuNDIuMy9PQ0ExMS9SU0EvY3JsMTQ4ODMuY3JsMAsGA1UdDwQEAwIFoDAd\n" +
//                "\t\t\tBgNVHQ4EFgQU7WLa0CwRVJPQo1Hv8aux9j0v5+swOwYDVR0lBDQwMgYIKwYBBQUHAwIGCCsGAQUF\n" +
//                "\t\t\tBwMDBggrBgEFBQcDBAYIKwYBBQUHAwEGCCsGAQUFBwMIMA0GCSqGSIb3DQEBBQUAA4IBAQBvE02e\n" +
//                "\t\t\tV4QSuGhHtEPwjEWMImd6LPlWVM3i/yPCiM10+JuhXGGQwBuf6hrK5y1NfLTl2CxMDDqWKxvHqCPM\n" +
//                "\t\t\tWMhP2OxILoPEZYrCeV0nfOBck2Nt2uKtutwgox4hO0nrXbZIlQ4yvrrc34FZt/t89eNNlGTxm8RL\n" +
//                "\t\t\txSdPGsuZzA2UglW/FrQ7LWs+BqvPAGSkHqI6z5xpSZbTooaGvUhSFesjlqAFEEdaEKd5zgOtmUpU\n" +
//                "\t\t\t/XDBkua9fyaK56cT5DSYGJklmiU5OedngDuNPKwpfm8zi9O4Z+4WxU21pCBcfV4ssn5zSIYWJvcm\n" +
//                "\t\t8f6rksAU+vlDwcdJ1ZqAGb4rdaEZeDO3</KoalB64Cert>\n" +
//                "\t\t<Signature>xCaBhJrMlHzvUU+OstjWCSCitdKy3WUkHbPX/XJtgfkHnzl7JJfXTB5wgNpzqpvKzFZEWd2UKnX0\n" +
//                "\t\t\t62UqWABcgYhvtqnYrBWa6X54oghGDVUB/kyctKldumN659vrYjjLduIjTFfksujjTRuF7XNTGAkD\n" +
//                "\t\tEmjhkM3XvZDGKc4CqLY=</Signature>\n" +
//                "\t</XTR0001Rq>\n" +
//                "</BOSFXII>");
        System.out.println("send_url:" + url);
        System.out.println("send_data:" + sb.toString());
        // 读取返回内容
        StringBuffer buffer = new StringBuffer();
        // 尝试发送请求  
        try {
            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();
            //// POST 只能为大写，严格限制，post会不识别  
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "ext/plain; charset=utf-8");
            con.setRequestProperty("Content-Length", sb.toString().length() + "");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            osw.write(sb.toString());
            osw.flush();
            osw.close();

            //一定要有返回值，否则无法把请求发送给server端。
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        return buffer.toString();
    }

    @Test
    public void test3() throws Exception {
        Map parames = new HashMap<String, String>();
        //合作方客户号
        parames.put("CoopCustNo", UUID.randomUUID().toString());
        //理财产品参数
        parames.put("ProductCd", "xtrBalFinancing");
        //姓名
        parames.put("CustName", "张峰");
        //身份证号
        parames.put("IdNo", "430421199003192752");
        //证件到期日
        parames.put("ExpDay", "20211220");
        //手机号
        parames.put("MobllePhone", "17775649963");
        //绑定银行卡号
        parames.put("BindCardNo", "6226200203289005");
        //银行卡预留手机号
        parames.put("ReservedPhone", "17775649963");
        //是否开通余额理财功能
        parames.put("Sign", "N");
        //基金代码
        parames.put("FundCode", "");
        //邮箱
        parames.put("Email", "zfvip_it@163.com");
        //家庭住址
        parames.put("HomeAddr", "");
        //职业
        parames.put("Occupation", "");
        // 如果地址栏中有aaa这个参数，则默认选择地址栏的，如果没有则选择添加的参数
//        parames.put("aaa", "aaa_value");
        System.out.println(HttpUtil.http("https://203.156.238.218:30150/ib-rest/gateway/XTR0001", getSignature(parames)));
    }

    /**
     * 获取签名
     *
     * @param params
     * @return
     */
    public static Map<String, String> getSignature(Map<String, String> params) throws Exception {
        // 构建请求参数
        StringBuffer sb = new StringBuffer();
        if (params != null) {
            for (Entry<String, String> e : params.entrySet()) {
                sb.append(e.getKey());
                sb.append("=");
                sb.append(e.getValue());
                sb.append("&");
            }
            sb.substring(0, sb.length() - 1);
        }
        SvsSign signer = new SvsSign();
//        HttpUtil.class.getResource("/");
        signer.initSignCertAndKey("E:\\workspace\\pay\\pay-core\\src\\main\\resources\\cert\\shyh\\110310018000011.pfx", "123456");
        String signData = signer.signData(sb.toString().getBytes("GBK"));//获取签名密文 signDataStr为签名明文
        String szCert = signer.getEncodedSignCert(); //获取base64的公钥
        //签名
        params.put("Signature", signData);
        //证书代码
        params.put("KoalB64Cert", szCert);

        return params;
    }

}  