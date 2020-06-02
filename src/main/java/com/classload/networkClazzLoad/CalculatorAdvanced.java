package com.classload.networkClazzLoad;

/**
 * Created by root on 2018/4/13.
 * 服务器上实现
 */
public class CalculatorAdvanced implements ICalculator {

    @Override
    public String calculate(String expression) {
        return "Result is " + expression;
    }

    @Override
    public String getVersion() {
        return "2.0";
    }
}
