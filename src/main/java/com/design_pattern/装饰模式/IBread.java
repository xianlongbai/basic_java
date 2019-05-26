package com.design_pattern.装饰模式;

/**
 * Created by root on 2019/5/15.
 * 统一接口，也是装饰类和被装饰类的基本类型
 */
public interface IBread  {

    public void prepair();

    public void kneadFlour();

    public void steamed();

    public void process();
}
