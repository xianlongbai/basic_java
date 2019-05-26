package com.design_pattern.代理模式.动态代理.class_文件生成;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

/**
 * Created by root on 2018/8/4.
 *
 * javassist是jboss的一个子项目，其主要的优点，在于简单，而且快速。直接使用java编码的形式，
 * 而不需要了解虚拟机指令，就能动态改变类的结构，或者动态生成类。
 */
public class MyGenerator2 {

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        //创建Programmer类
        CtClass cc= pool.makeClass("com.samples.Programmer");
        //定义code方法
        CtMethod method = CtNewMethod.make("public void code(){}", cc);
        //插入方法代码
        method.insertBefore("System.out.println(\"I'm a Programmer,Just Coding.....\");");
        cc.addMethod(method);
        //保存生成的字节码
        cc.writeFile("D:\\tmp");
        System.out.println("class文件生成成功！！！");
    }

}
