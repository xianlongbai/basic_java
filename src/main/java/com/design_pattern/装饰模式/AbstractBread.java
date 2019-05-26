package com.design_pattern.装饰模式;

/**
 * Created by root on 2019/5/15.
 *
 * 装饰类
 */
public class AbstractBread implements IBread {

    private final IBread bread;

    public AbstractBread(IBread bread) {
        super();
        this.bread = bread;
    }
    @Override
    public void prepair() {
        this.bread.prepair();
    }
    @Override
    public void kneadFlour() {
        this.bread.kneadFlour();
    }
    @Override
    public void steamed() {
        this.bread.steamed();
    }

    @Override
    public void process() {
        prepair();
        kneadFlour();
        steamed();
    }
}
