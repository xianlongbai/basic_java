package com.design_pattern.简单工厂模式;

/**
 * Created by root on 2019/4/26.
 */
public interface Sender {
    public void Send();
}


class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }
}

class SmsSender implements Sender {

    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
}