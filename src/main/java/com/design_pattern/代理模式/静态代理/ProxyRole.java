package com.design_pattern.代理模式.静态代理;

/**
 * Created by root on 2019/5/23.
 */
public class ProxyRole implements Proxy {

    // 持有代理角色的引用
    private Proxy realityRole;

    public ProxyRole() {

    }

    //传入一个真实角色
    public ProxyRole(Proxy role) {
        realityRole = role;
    }
    @Override
    public void todo() {
        //在真实角色功能运行之前，代理角色做准备工作
        doBefore();
        //执行真实角色的功能
        realityRole.todo();
        //代理角色的收尾工作
        doAfter();
    }
    private void doBefore() {
        System.out.println("准备工作");
    }
    private void doAfter() {
        System.out.println("收尾工作");
    }
}
