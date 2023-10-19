package com.wzm.project.provider;


import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * 示例服务实现类
 *
 * @author wzm
 */
@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        System.out.println("Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name;
    }


    @Override
    public String sayHello2(String name) {
        return "yupi";
    }


}
