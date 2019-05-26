package com.design_pattern.代理模式.动态代理.jdk_proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Created by root on 2018/7/31.
 *
 * 场景：班长代理学生交班费
 *
 * 在java的java.lang.reflect包下提供了一个Proxy类和一个InvocationHandler接口，
 * 通过这个类和这个接口可以生成JDK动态代理类和动态代理对象。
 */
public class Client {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //我们要代理的真实对象
        Subject realSubject = new RealSubject();

        //ProxyUtils.generateClassFile(realSubject.getClass(),"DynamicProxy");
        //我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        //1、创建一个与代理对象相关联的InvocationHandler
        InvocationHandler handler = new DynamicProxy(realSubject);

        /**
         * 方式一：（常用）
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
//        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject
//                .getClass().getInterfaces(), handler);

        /**
         * 方式二：（不常用）
         * 2、3、4 步骤可以通过方式一进行简化
         */
        //2、使用Proxy类的getProxyClass静态方法生成一个动态代理类proxyClass
        Class<?> proxyClass = Proxy.getProxyClass(handler.getClass().getClassLoader(), new Class<?>[]{Subject.class});
        //3、获得proxyClass中一个带InvocationHandler参数的构造器constructor
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        //4、通过构造器constructor来创建一个动态实例subject
        Subject subject = (Subject) constructor.newInstance(handler);

        /**
         * subject.getClass().getName()的到的是$Proxy0
         * 通过 Proxy.newProxyInstance 创建的代理对象是在jvm运行时动态生成的一个对象，它并不是我们的InvocationHandler类型，
         * 也不是我们定义的那组接口的类型，而是在运行是动态生成的一个对象，并且命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号。
         */
        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.hello("world");
    }

}
