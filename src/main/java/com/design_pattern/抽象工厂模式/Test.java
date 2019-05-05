package com.design_pattern.抽象工厂模式;

/**
 * Created by root on 2019/5/4.
 * 工厂方法模式和抽象工厂模式区别如下：
 *   工厂方法模式：
 *      一个抽象产品类，可以派生出多个具体产品类。
 *      一个抽象工厂类，可以派生出多个具体工厂类。
 *      每个具体工厂类只能创建一个具体产品类的实例。
 *
 *   抽象工厂模式：
 *      多个抽象产品类，每个抽象产品类可以派生出多个具体产品类。
 *      一个抽象工厂类，可以派生出多个具体工厂类。
 *      每个具体工厂类可以创建多个具体产品类的实例，也就是创建的是一个产品线下的多个产品。
 *
 */
public class Test {

    public static void main(String[] args){

        Factory factoryA = new SendMailFactory();
        Sender produceA = factoryA.produce();
        Postage collectA = factoryA.collect();
        produceA.Send();;
        collectA.collect();


    }

}



