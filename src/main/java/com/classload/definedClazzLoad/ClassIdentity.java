package com.classload.definedClazzLoad;

import java.lang.reflect.Method;

/**
 * Created by root on 2018/4/12.
 */
public class ClassIdentity {

    public static void main(String[] args) {
        new ClassIdentity().testClassIdentity();
    }

    public void testClassIdentity() {
        String classDataRootPath = "D:\\github_space\\basic_java\\target\\classes";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
        System.out.println("类加载器比较：" + (fscl1==fscl2));
        String className = "com.classload.definedClazzLoad.Sample";
        try {
            Class<?> class1 = fscl1.loadClass(className);  // 加载Sample类
            Class<?> class2 = fscl2.loadClass(className);  // 加载Sample类
            System.out.println("类对象比较：" + (class1==class2));
            Object obj1 = class1.newInstance();  // 创建对象
            Method setSampleMethod = class1.getMethod("setSample", String.class);
            setSampleMethod.invoke(obj1, "test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
