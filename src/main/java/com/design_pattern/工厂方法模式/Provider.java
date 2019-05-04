package com.design_pattern.工厂方法模式;

/**
 * Created by root on 2019/4/26.
 */
public interface Provider {
    public Sender produce();
}

class SendMailFactory implements Provider {

    @Override
    public Sender produce(){
        return new MailSender();
    }
}

class SendSmsFactory implements Provider{

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}