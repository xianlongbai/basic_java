package com.design_pattern.桥接模式;

/**
 * Created by root on 2019/5/26.
 */
public class MyBridge extends Bridge {
    @Override
    public void method(){
        getSource().method();
    }
}
