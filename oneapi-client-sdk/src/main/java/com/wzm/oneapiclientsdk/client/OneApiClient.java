package com.wzm.oneapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.wzm.oneapiclientsdk.model.User;


import java.util.HashMap;
import java.util.Map;

import static com.wzm.oneapiclientsdk.utils.SignUtils.genSign;

/**
 * Client calling third-party interface
 *
 * @author mzm
 *
 */
public class OneApiClient {

    //private static final String GATEWAY_HOST = "http://localhost:8123";
    private static final String GATEWAY_HOST = "http://124.220.97.228:8090";

    private String accessKey;

    private String secretKey;

    public OneApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        //can pass in the http parameters separately, so the parameters will be automatically URL-encoded and spliced ​​into the URL.
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name) {
        //can pass in the http parameters separately, so the parameters will be automatically URL-encoded and spliced ​​into the URL.
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.post(GATEWAY_HOST + "/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        // must not be sent directly
//        hashMap.put("secretKey", secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(body, secretKey));
        return hashMap;
    }

    public String getUsernameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    private static final String  AK = "tbD8GFlMj9m05QASnPTq";
    public String getWorldTimeByCity(String city){
        //http://api.liangmlk.cn?ak=tbD8GFlMj9m05QASnPTq&appid=42&city_en=new-york
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("ak", AK);
        paramMap.put("appid", 42);
        paramMap.put("city_en", city);
        String result = HttpUtil.get("http://api.liangmlk.cn", paramMap);
        System.out.println(result);
        return result;
    }


    public String Xchanger(String[] params){
        //'https://api.liangmlk.cn?ak=tbD8GFlMj9m05QASnPTq&appid=44&scur=usd&tcur=cny'
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("ak", AK);
        paramMap.put("appid", 44);
        paramMap.put("scur", params[0]);
        paramMap.put("tcur", params[1]);
        String result = HttpUtil.get("http://api.liangmlk.cn", paramMap);
        System.out.println(result);
        return result;
    }

    public String getMotivationalQuote(){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("ak", AK);
        paramMap.put("appid", 687);
        String result = HttpUtil.get("http://api.liangmlk.cn", paramMap);
        System.out.println(result);
        return result;
    }
    public String getIPLocation(String ip) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("ak", AK);
        paramMap.put("appid", 602);
        paramMap.put("ip", ip);
        String result = HttpUtil.get("http://api.liangmlk.cn", paramMap);
        System.out.println(result);
        return result;
    }
}
