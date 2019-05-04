package com.design_pattern.单例模式;

/**
 * Created by root on 2019/4/26.
 *
 *
 */

//饿汉式（静态常量）[线程安全]

/**
 * 1、饿汉式（线程安全）[可用]
 *    在类装载的时候，就实例化了类对象，没有达到Lazy Loading的效果，会造成内存的浪费
  */
public class Singleton {

    private final static Singleton INSTANCE = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args){
        //直接调用类的静态方法获得类对象
        Singleton instance = Singleton.getInstance();
    }
}


/**
 * 2、懒汉式(线程不安全)[不可用]
 *    起到了Lazy Loading的效果，但是只能在单线程下使用
 *    解决线程不安全的办法：getInstance()方法改为同步方法，加synchronized关键字，但是效率太低了，不推荐
 *
 */
class Singleton_2 {

    private static Singleton_2 singleton;

    private Singleton_2() {}

    public static Singleton_2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton_2();
        }
        return singleton;
    }
}

/**
 * 3、懒汉模式 双重检查（线程安全）[推荐用]
 *      线程安全；延迟加载；效率较高
 */
class Singleton_3 {

    private static volatile Singleton_3 singleton;

    private Singleton_3() {}

    public static Singleton_3 getInstance() {
        if (singleton == null) {
            synchronized (Singleton_3.class) {
                if (singleton == null) {
                    singleton = new Singleton_3();
                }
            }
        }
        return singleton;
    }
}


/**
 * 静态内部类[推荐用]
 * 避免了线程不安全，延迟加载，效率高
 */
class Singleton_4 {

    private Singleton_4() {}

    private static class SingletonInstance {
        private static final Singleton_4 INSTANCE = new Singleton_4();
    }

    public static Singleton_4 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
