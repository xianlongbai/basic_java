package com.design_pattern.抽象工厂模式;



/**
 * Created by root on 2019/5/4.
 */
public interface Factory {
    public Sender produce();
    public Postage collect();
}


class SendMailFactory implements Factory {

    @Override
    public Sender produce() {
        return new MailSender();
    }

    @Override
    public Postage collect() {
        return new MailPostage();
    }
}

class SendSmsFactory implements Factory {

    @Override
    public Sender produce() {
        return new SmsSender();
    }

    @Override
    public Postage collect() {
        return new SmsPostage();
    }
}