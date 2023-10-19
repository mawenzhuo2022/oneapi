package com.wzm.oneapiinterface.controller;

import cn.hutool.http.HttpUtil;
import com.wzm.oneapiclientsdk.model.User;
import com.wzm.oneapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 名称 API
 *
 * @author wzm
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name, HttpServletRequest request) {
        //http://localhost:8123/api/name/get?name=wzm
        System.out.println(request.getHeader("yupi"));
        return "GET your name is " + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "POST your name is" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        System.out.println("accessKey:"+accessKey);
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        // todo 实际情况应该是去数据库中查是否已分配给用户
//        if (!accessKey.equals("yupi")) {
//            throw new RuntimeException("无权限");
//        }
        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限");
        }
        // todo 时间和当前时间不能超过 5 分钟
//        if (timestamp) {
//
//        }
        // todo 实际情况中是从数据库中查出 secretKey
//        String serverSign = SignUtils.genSign(body, "abcdefgh");
//        if (!sign.equals(serverSign)) {
//            throw new RuntimeException("无权限");
//        }
        // todo 调用次数 + 1 invokeCount
        String result = "POST your name is " + user.getUsername();
        return result;
    }

    private static final String  AK = "tbD8GFlMj9m05QASnPTq";
    @GetMapping("/getWorldTimeByCity")
    public String getWorldTimeByCity(String city, HttpServletRequest request) {
        //http://api.liangmlk.cn?ak=tbD8GFlMj9m05QASnPTq&appid=42&city_en=new-york
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("ak", AK);
        paramMap.put("appid", 42);
        paramMap.put("city_en", city);
        String result = HttpUtil.get("http://api.liangmlk.cn", paramMap);
        System.out.println(result);
        return result;
    }

    @GetMapping("/Xchanger")
    public String Xchanger(String[] params){
        //'https://api.liangmlk.cn?ak=xxxx&appid=44&scur=usd&tcur=cny'
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("ak", AK);
        paramMap.put("appid", 44);
        paramMap.put("scur", params[0]);
        paramMap.put("tcur", params[1]);
        System.out.println(params[0]);
        System.out.println(params[1]);
        String result = HttpUtil.get("http://api.liangmlk.cn", paramMap);
        System.out.println(result);
        return result;
    }
    @GetMapping("/getMotivationalQuote")
    public String getMotivationalQuote(){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("ak", AK);
        paramMap.put("appid", 687);
        String result = HttpUtil.get("http://api.liangmlk.cn", paramMap);
        System.out.println(result);
        return result;
    }
    @GetMapping("/getIPLocation")
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
