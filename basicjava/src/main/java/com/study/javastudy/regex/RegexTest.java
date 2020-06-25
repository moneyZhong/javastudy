package com.study.javastudy.regex;



import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONObject;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
@Slf4j
public class RegexTest {
//    private final static String  appkey = "6d5cc2f8672e3801";
//    private final static String appSecret = "130ffe2528923f331de6b76be1551dd0";

   private final static String  appkey = "06fba392ce0df544";
    private final static String appSecret = "3cd9c71a341979f07d9f26f154c4293d";
    public static void main(String[] args) {
        String content = "【阳光运贷】尊敬的客户fasdfa哈达大师法是否 ，您于#申请日期，#期数，式：xx月xx日#到期，为还金额#本息合计，格式xx.xx# 元划转至【户名:广州惠金小额贷款有限公司；账号:110926412410806；开户行:招商银行北京分行朝阳公园支行】，欢迎登陆【手机管车app】查看详情，如遇问题，请致电【客服电话】咨询。";
        String pattern = "【阳光运贷】尊敬的客户([\\s\\S]*) ，您于#申请日期，格式xxxx年xx月xx日#申请的#放款金额，格式xx.xx#元的借款的第#期数，阿拉伯数字#期将于#当期还款日，格式：xx月xx日#到期，为了不影响您企业及个人的征信，请在还款日前及时将待还金额#本息合计，格式xx.xx# 元划转至【户名:广州惠金小额贷款有限公司；账号:110926412410806；开户行:招商银行北京分行朝阳公园支行】，欢迎登陆【手机管车app】查看详情，如遇问题，请致电【客服电话】咨询。";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println(isMatch);
        TreeMap<String, Object> map = new TreeMap<>();
        map.put("a","haha");
        map.put("c","heehehe");
        map.put("b","ooooo");
        System.out.println(new JSONObject(map).toString());
        /**
         * 签名算法:
         * 将所有的请求参数(包括token,method,appkey)+signTime(签名时间)+appSecret做完数组, 然后根据key进行升序排列.将排列后的结果数组转换为json字符串,再进行MD5加密.得到最好的sign值
         *
         * 将得到的sign和signTime一起作为请求参数传到服务端.
         */
        String url = createRequestParam("external.message.sendMessage",
                "method","external.message.sendMessage",
                "appkey",appkey,
                "signTime",System.currentTimeMillis()/1000,
                "appSecret",appSecret,
                "orgcodes","201ZS3",
                "message", "14",//推广消息(0)、系统消息(1)
                "title","放款消息通知",
                "description",content,
                "linkurl","https://donglibao-finance.huoyunren.com/#/sunshine",
                "linktype","2",
                "linktext","查看详情"
                );
        System.out.println(url);


        String jsonStr = "{\"appSecret\":\"130ffe2528923f331de6b76be1551dd0\",\"appkey\":\"6d5cc2f8672e3801\",\"description\":\"\\u4eca\\u665a\\u6709\\u7a7a\\uff0c\\u8be5\\u6765\\u501f\\u6b3e\\u4e86\",\"linktext\":\"\\u67e5\\u770b\",\"linktype\":\"5\",\"linkurl\":\"http:\\/\\/www.baidu.com\",\"message\":\"0\",\"method\":\"external.message.sendMessage\",\"orgcodes\":\"201LFL\",\"signTime\":1590741337,\"title\":\"\\u6d88\\u606f\\u6d4b\\u8bd5\"}";
        System.out.println(MD5.create().digestHex(jsonStr));
    }

    /**
     * 1	外部链接
     * 用于显示公司各业务服务器之外的外部链接，提供基本的native方法供页面调用。不提供用户身份消息。
     *
     * 2	第三方链接	即在App中接入的各个业务应用，而服务不在手机管车的服务器里面。提供业务相关的原生功能支持，提供用户身份信息。
     * 3	应用协议	客户端将根据url跳转native页面。目前只支持ETC和违章查询。
     * 4	插件链接	特殊的第三方业务，作为App中功能的扩展模块，嵌入App比较深，具有比第三方业务页面更多的和App内部页面交互、跳转等特殊功能。
     * 5	内部链接	App内部功能模块，采用HTML5页面方式实现的部分
     * @param method
     * @param params
     * @return
     */


    public static String createRequestParam(String method, Object... params) {
        final String FORMAT = "utf-8";
        TreeMap<String, Object> map = new TreeMap<>();


        for (int i = 0; i < params.length; i += 2) {
            map.put((String)params[i], params[i + 1]);
        }
//        JSONObject data = JSONObject.fromObject(map);
//        String sign = MD5Util.MD5(data.toString());

//        String sigStr =new JSONObject(map).toString() ;
//        System.out.println(sigStr);

        String sigStr =  new Gson().toJson(map);
        System.out.println(sigStr);
        String sign = MD5.create().digestHex(sigStr);
        System.out.println(sign);

        map.put("sign",sign);
        map.remove("appSecret");
        //String apiURL = getExternalUrl(method);
//        String apiUR = "http://test.truckmanager.g7s.chinawayltd.com/external.php";
        String apiUR = "http://truckmanager.g7s.huoyunren.com/external.php";
        StringBuilder param = new StringBuilder();
        Boolean flag = true;
        String simgble = "";
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if(flag){
                simgble = "?";
            }else{
                simgble = "&";
            }
            flag = false;
            if (value != null) {
                try {
                    value = URLEncoder.encode(String.valueOf(value), FORMAT);
                    param.append(simgble).append(key).append("=").append(value);
                } catch (UnsupportedEncodingException e) {
                    log.error ( "UnsupportedEncodingException: " + e ) ;
                }
            }
        }
        return apiUR + param.toString();
    }
}
