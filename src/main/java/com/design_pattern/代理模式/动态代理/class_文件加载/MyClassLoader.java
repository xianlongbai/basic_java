package com.design_pattern.代理模式.动态代理.class_文件加载;

/**
 * Created by root on 2018/8/1.
 * 自定义类加载器
 */
public class MyClassLoader extends ClassLoader{

    public Class<?> defineMyClass( byte[] b, int off, int len)
    {
        return super.defineClass(b, off, len);
    }
}
