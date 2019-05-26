package com.design_pattern.代理模式.动态代理.cglib_proxy;

/**
 * Created by root on 2019/5/26.
 * JDK代理要求被代理的类必须实现接口，有很强的局限性。而CGLIB动态代理则没有此类强制性要求。
 * 简单的说，CGLIB会让生成的代理类继承被代理类，并在代理类中对代理方法进行强化处理(前置处理、后置处理等)。
 * 在CGLIB底层，其实是借助了ASM这个非常强大的Java字节码生成框架。

 */
public class PersonService {

    public PersonService() {
        System.out.println("PersonService构造");
    }

    //该方法不能被子类覆盖
    final public String getPerson(String code) {
        System.out.println("PersonService:getPerson>>"+code);
        return null;
    }

    public void setPerson() {
        System.out.println("PersonService:setPerson");
    }
}
