package com.classload.networkClazzLoad;

/**
 * Created by root on 2018/4/13.
 * 客户端接口
 */
public interface ICalculator  extends Versioned {

    String calculate(String expression);
}
