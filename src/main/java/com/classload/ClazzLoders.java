package com.classload;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by root on 2018/4/12.
 * 类加载顺序  bootstrap class loader---> 扩展类加载 ---> 系统类加载
 *
 */
public class ClazzLoders {

   // private static Student s = new Student();

    public static void main(String[] args){

        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println("*******************************************************************************");


        URL[] urLs = ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs();
        System.out.println("系统类加载");
        for (int i = 0; i < urLs.length; i++) {
            System.out.println(urLs[i]);
        }
        //System.getProperty("com.classload.ClazzLoders");
        System.out.println("*******************************************************************************");
        URL[] extURLs = ((URLClassLoader) ClassLoader.getSystemClassLoader().getParent()).getURLs();
        System.out.println("扩展类加载");
        for (int i = 0; i < extURLs.length; i++) {
            System.out.println(extURLs[i]);
        }
        System.out.println("*******************************************************************************");
        //引导类：由于引导类加载器涉及到虚拟机本地实现细节，开发者无法直接获取到启动类加载器的引用，所以不允许直接通过引用进行操作。
//        URL[] exts = ((URLClassLoader) ClassLoader.getSystemClassLoader().getParent().getParent()).getURLs();
//        System.out.println("引导类加载");
//        for (int i = 0; i < exts.length; i++) {
//            System.out.println(exts[i]);
//        }

        //查看当前系统类路径中包含的路径条目
        System.out.println(System.getProperty("java.class.path"));

    }
}
