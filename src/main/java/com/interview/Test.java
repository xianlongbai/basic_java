package com.interview;

import java.io.FileInputStream;

/**
 * Created by root on 2019/10/30.
 */
public class Test {

    public Test() {
        System.out.print("默认构造方法！");
    }

    {
        System.out.print("非静态代码块！");
    }

    static {
        System.out.print("静态代码块！");
    }

    public static void test() {
        {
            System.out.print("静态方法中的代码块！");
        }
        System.out.print("静态方法中的内容! ");
    }

    public static void main(String[] args) {
        Test test = new Test();
        Test.test();

    }


}
