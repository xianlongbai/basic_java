package com.design_pattern.适配器模式.对象适配器模式;

/**
 * Created by root on 2019/5/14.
 * 德国插座
 */
public class DBSocket implements DBSocketInterface {

    @Override
    public void powerWithTwoRound() {
        System.out.println("使用两项圆头的插孔供电");
    }

}
