package com.design_pattern.工厂方法模式;

/**
 * Created by root on 2019/4/26.
 *
 * 其实这个模式的好处就是，如果你现在想增加一个功能：发及时信息，则只需做一个实现类，实现Sender接口，
 * 同时做一个工厂类，实现Provider接口，就OK了，无需去改动现成的代码。这样做，拓展性较好！
 * 说白了就是动态的增加接口的实现类
 *
 * 对比简单工厂：工厂类接口化，通过实现接口来动态扩展工厂实现
 */
public class Test {

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
}
