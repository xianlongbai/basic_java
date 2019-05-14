package com.design_pattern.适配器模式.对象适配器模式;

/**
 * Created by root on 2019/5/14.
 * 中国插座
 */
public class GBSocket implements GBSocketInterface {

    @Override
    public void powerWithThreeFlat() {
        System.out.println("使用三项扁头插孔供电");
    }

}
