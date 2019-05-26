package com.design_pattern.代理模式.动态代理.jdk_proxy_test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Created by root on 2019/5/25.
 *
 * jdk为我们的生成了一个叫$Proxy0（这个名字后面的0是编号，有多个代理类会一次递增）的代理类，
 * 这个类文件时放在内存中的，我们在创建代理对象时，就是通过反射获得这个类的构造方法，然后创建的代理实例。
 * 通过对这个生成的代理类源码的查看，我们很容易能看出，动态代理实现的具体过程。

 * 我们可以对InvocationHandler看做一个中介类，中介类持有一个被代理对象，在invoke方法中调用了被代理对象的相应方法。
 * 通过聚合方式持有被代理对象的引用，把外部对invoke的调用最终都转为对被代理对象的调用。

 * 代理类调用自己方法时，通过自身持有的中介类对象来调用中介类对象的invoke方法，从而达到代理执行被代理对象的方法。
 * 也就是说，动态代理通过中介类实现了具体的代理功能。
 */
public class Client {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        House house = new HouseImpl();

        InvocationHandler handler = new ProxyObj(house);
        //设置这个值，可以把生成的代理类，输出出来(路径：com.sun.proxy.$Proxy0)
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //得到一个动态实例代理对象,类加载器、接口、InvocationHandler
        House proxyHouse = (House) Proxy.newProxyInstance(handler.getClass().getClassLoader(), house.getClass().getInterfaces(), handler);

        //方式二：
        //得到一个动态代理对象
        //Class<?> proxyClass = Proxy.getProxyClass(handler.getClass().getClassLoader(), house.getClass().getInterfaces());
        //获得proxyClass中一个带InvocationHandler参数的构造器constructor
        //Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        //House proxyHouse = (House) constructor.newInstance(handler);

        proxyHouse.find();
        proxyHouse.lease();
        proxyHouse.money(2000);


    }






}
