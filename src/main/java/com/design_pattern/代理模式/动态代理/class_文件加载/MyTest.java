package com.design_pattern.代理模式.动态代理.class_文件加载;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by root on 2018/8/1.
 *
 * 演示手动加载 class文件字节码到系统内，转换成class对象，然后再实例化的过程
 *
 * 通过ams生成的.class文件 D:\tmp\Programmer.class
 */
public class MyTest  {

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        //读取本地的class文件内的字节码，转换成字节码数组
        File file = new File(".");
        System.out.println(file.getCanonicalPath()); // D:\idea_repository\basic_java
        String file1 = file.getCanonicalPath()+"\\target\\classes\\com\\design_pattern\\代理模式\\动态代理\\class_文件加载\\Programmer.class";
        //在代码里生成字节码file2，并动态地加载成class对象、创建实例是完全可以实现的。
        //String file2 = "D:\\tmp\\Programmer.class";
        String file3 = "D:\\tmp\\com\\samples\\Programmer.class";
        InputStream input = new FileInputStream(file3);
        byte[] result = new byte[1024];

        int count = input.read(result);
        // 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
        MyClassLoader loader = new MyClassLoader();
        Class clazz = loader.defineMyClass( result, 0, count);
        //测试加载是否成功，打印class 对象的名称
        System.out.println(clazz.getCanonicalName());

        //实例化一个Programmer对象
        Object o= clazz.newInstance();
        try {
            //调用Programmer的code方法
            clazz.getMethod("code", null).invoke(o, null);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
