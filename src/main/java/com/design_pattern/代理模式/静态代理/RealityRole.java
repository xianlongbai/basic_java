package com.design_pattern.代理模式.静态代理;

/**
 * Created by root on 2019/5/23.
 */
public class RealityRole implements Proxy {
    @Override
    public void todo() {
        System.out.println("真实角色的功能");
    }
}
