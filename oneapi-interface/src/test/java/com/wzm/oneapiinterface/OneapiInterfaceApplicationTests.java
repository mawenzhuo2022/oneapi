package com.wzm.oneapiinterface;

import com.wzm.oneapiclientsdk.client.OneApiClient;
import com.wzm.oneapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * test
 *
 * @author wzm
 */
@SpringBootTest
class OneapiInterfaceApplicationTests {

    @Resource
    private OneApiClient oneApiClient;

    @Test
    void contextLoads() {
//        String result = oneApiClient.getNameByGet("yupi");
//        User user = new User();
//        user.setUsername("yupi");
//        String usernameByPost = oneApiClient.getUsernameByPost(user);
//        System.out.println(result);
//        System.out.println(usernameByPost);

        //String result = oneApiClient.getWorldTimeByCity("new-york");
        String[] params = new String[2];
        params[0] = "usd";
        params[1] = "cny";
        String result = oneApiClient.Xchanger(params);
        System.out.println(result);
    }

}
