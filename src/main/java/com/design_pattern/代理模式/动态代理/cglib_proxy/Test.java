package com.design_pattern.代理模式.动态代理.cglib_proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by root on 2019/5/26.
 *
 * 底层使用了asm生成.class文件
 *
 * cglib通过继承。因为如果Proxy 继承自RealSubject，这样Proxy则拥有了RealSubject的功能，
 * Proxy还可以通过重写RealSubject中的方法，来实现多态
 *
 * cglib 创建某个类A的动态代理类的模式是：
     1. 查找A上的所有非final 的public类型的方法定义；
     2. 将这些方法的定义转换成字节码；
     3. 将组成的字节码转换成相应的代理的class对象；
     4. 实现 MethodInterceptor接口，用来处理 对代理类上所有方法的请求（这个接口和JDK动态代理InvocationHandler的功能和角色是一样的)
 *
 */
public class Test {

    public static void main(String[] args){
        //代理类class文件存入本地磁盘
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        //创建加强器，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        enhancer.setSuperclass(PersonService.class);
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(new CglibProxyIntercepter());
        //创建动态代理类对象并调用方法
        PersonService proxy= (PersonService)  enhancer.create();
        proxy.setPerson();
        proxy.getPerson("路巨人");
    }

}
