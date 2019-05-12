package com.design_pattern.建造者模式;

/**
 * Created by root on 2019/5/12.
 * 建造者
 */
public class Director {

    public Product constructProduct(ConcreteBuilder concreteBuilder){
        concreteBuilder.buildBasic();
        concreteBuilder.buildWalls();
        concreteBuilder.roofed();
        return concreteBuilder.buildProduct();
    }

}
