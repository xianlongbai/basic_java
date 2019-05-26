package com.design_pattern.代理模式.动态代理.jdk_proxy_test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by root on 2019/5/25.
 */
public class ProxyObj implements InvocationHandler{

    private Object object;

    public ProxyObj(Object object) {
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("methad before ...");
        method.invoke(object,args);
        System.out.println("methad after ...");
        return null;
    }



}
