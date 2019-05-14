package com.design_pattern.适配器模式.类的适配器模式;

/**
 * Created by root on 2019/5/13.
 * 适配者接口实现类
 */
public class Usber implements Usb{

    @Override
    public void isUsb() {
        System.out.println("适配USB口");
    }

    public void test() {
        System.out.println("test");
    }
}
