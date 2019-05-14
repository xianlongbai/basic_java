package com.design_pattern.适配器模式.类的适配器模式;

/**
 * Created by root on 2019/5/13.
 * 类适配器
 */
public class Adapter extends Usber implements Ps2 {

    @Override
    public void isPs2() {
        isUsb();
    }

//    @Override
//    public void test() {
//        super.test();
//    }
}
