package com.design_pattern.装饰模式;

/**
 * Created by root on 2019/5/15.
 * 装饰者模式中的4个角色
     (1)被装饰者抽象Component:是一个接口或者抽象类,定义最核心的对象,这个类是装饰者的基类,例如IBread接口
     (2)被装饰者具体实现ConcreteComponent:这是Component接口或抽象类的实现,例如本例中的NormalBread
     (3)装饰者Decorator:一般是抽象类,实现Component,它里面必然有一个指向Component的引用,例如本例中AbstractBread
     (4)装饰者实现ConcreteDecorator1和ConcreteDecorator2:用来装饰最基本的类,如本例中的CornDecorator,

 使用场合
     1.需要为某个现有对象添加一个新的功能或职责时,可以考虑使用装饰者模式
     2.某个对象的职责经常发生变化或经常需要动态添加职责,避免为了适应这种变化造成的继承扩展方式

 要实现装饰者模式,注意一下几点内容:
     1.装饰者类要实现真实类同样的接口
     2.装饰者类内有一个真实对象的引用(可以通过装饰者类的构造器传入)
     3.装饰类对象在主类中接受请求,将请求发送给真实的对象(相当于已经将引用传递到了装饰类的真实对象)
     4.装饰者可以在传入真实对象后,增加一些附加功能(因为装饰对象和真实对象都有同样的方法,装饰对象可以添加一定操作在调用真实对象的方法,或者先调用真实对象的方法,再添加自己的方法)
     5.不用继承,
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("=======开始装饰馒头");
        IBread normalBread = new NormalBread();
        normalBread = new SweetDecorator(normalBread);
        normalBread = new CornDecorator(normalBread);
        normalBread.process();
        System.out.println("=======装饰馒头结束");
    }
}
