package com.design_pattern.装饰模式;

/**
 * Created by root on 2019/5/15.
 * 具体装饰类
 */
public class CornDecorator  extends AbstractBread{


    public CornDecorator(IBread bread) {

        super(bread);
    }

    public void paint(){

        System.out.println("添加柠檬黄的着色剂");
    }
    @Override
    public void kneadFlour() {
        //添加着色剂后和面
        this.paint();
        super.kneadFlour();
    }

}
