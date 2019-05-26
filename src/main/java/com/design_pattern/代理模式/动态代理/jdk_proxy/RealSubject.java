package com.design_pattern.代理模式.动态代理.jdk_proxy;

/**
 * Created by root on 2018/7/31.
 */
public class RealSubject implements Subject {

    @Override
    public void rent()
    {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str)
    {
        System.out.println("hello: " + str);
    }

}
