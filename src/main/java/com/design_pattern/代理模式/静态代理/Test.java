package com.design_pattern.代理模式.静态代理;

/**
 * Created by root on 2019/5/23.
 * 优点：可以做到不对目标对象进行修改的前提下，对目标对象进行功能的扩展和拦截。
 * 缺点：因为代理对象，需要实现与目标对象一样的接口，会导致代理类十分繁多，不易维护，同时一旦接口增加方法，
 *      则目标对象和代理类都需要维护。
 */
public class Test {

    public static void main(String[] args){
        //创建真实角色对象
        Proxy realityRole = new RealityRole();
        //创建代理角色对象，并制定真实对象
        ProxyRole proxyRole = new ProxyRole(realityRole);
        //代理角色工作，本质调用的还是真实角色的功能
        proxyRole.todo();
    }

}
