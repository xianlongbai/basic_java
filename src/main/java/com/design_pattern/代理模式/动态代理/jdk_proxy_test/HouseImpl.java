package com.design_pattern.代理模式.动态代理.jdk_proxy_test;

/**
 * Created by root on 2019/5/25.
 */
public class HouseImpl implements House{


    @Override
    public void find() {
        System.out.println("找房了。。。");
    }

    @Override
    public void lease() {
        System.out.println("租房子。。。");
    }

    @Override
    public void money(int money) {
        System.out.println("租房价格是："+money);
    }
}
