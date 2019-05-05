package com.design_pattern.抽象工厂模式;

/**
 * Created by root on 2019/5/4.
 */
public interface Postage {
    public void collect();
}

class MailPostage implements Postage {
    @Override
    public void collect() {
        System.out.println("mail message is 5$");
    }
}

class SmsPostage implements Postage {
    @Override
    public void collect() {
        System.out.println("mail message is 10$");
    }
}