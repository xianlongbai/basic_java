package com.classload.networkClazzLoad;

/**
 * Created by root on 2018/4/13.
 * 网络版本类（服务器上）
 */
public class CalculatorBasic implements ICalculator {

    @Override
    public String calculate(String expression) {
        return expression;
    }

    @Override
    public String getVersion() {
        return "1.0";
    }
}
