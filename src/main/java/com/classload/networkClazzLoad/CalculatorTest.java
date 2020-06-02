package com.classload.networkClazzLoad;

/**
 * Created by root on 2018/4/13.
 */
public class CalculatorTest {
    public static void main(String[] args) {
        String url = "http://localhost:8080/ClassloaderTest/classes";
        NetworkClassLoader ncl = new NetworkClassLoader(url);
        String basicClassName = "com.example.CalculatorBasic";
        String advancedClassName = "com.example.CalculatorAdvanced";
        try {
            Class<?> clazz = ncl.loadClass(basicClassName);  // 加载一个版本的类
            ICalculator calculator = (ICalculator) clazz.newInstance();  // 创建对象
            System.out.println(calculator.getVersion());
            clazz = ncl.loadClass(advancedClassName);  // 加载另一个版本的类
            calculator = (ICalculator) clazz.newInstance();
            System.out.println(calculator.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
