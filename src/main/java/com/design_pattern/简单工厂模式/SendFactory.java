package com.design_pattern.简单工厂模式;

/**
 * Created by root on 2019/4/26.
 * 简单工厂一般分为：普通简单工厂、多方法简单工厂、静态方法简单工厂
 *      大多数情况下，我们会选用第三种——静态工厂方法模式
 */

//工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可
public class SendFactory {

    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }

    public static void main(String[] args){
        Sender sender = SendFactory.produceMail();
        sender.Send();
    }

}
