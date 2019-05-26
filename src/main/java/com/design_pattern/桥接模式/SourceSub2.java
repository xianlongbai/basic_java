package com.design_pattern.桥接模式;

/**
 * Created by root on 2019/5/26.
 */
public class SourceSub2 implements Sourceable{

    @Override
    public void method() {
        System.out.println("this is the second sub!");
    }

}
