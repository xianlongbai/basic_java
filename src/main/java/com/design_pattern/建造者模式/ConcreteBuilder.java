package com.design_pattern.建造者模式;

/**
 * Created by root on 2019/5/12.
 * 具体的建造
 */
public class ConcreteBuilder implements Builder {

    private Product product;

    public ConcreteBuilder(){
        product=new Product();
    }

    @Override
    public void buildBasic() {
        product.setBasic("打好基础");
    }

    @Override
    public void buildWalls() {
        product.setWall("砌墙");
    }

    @Override
    public void roofed() {
        product.setRoofed("封顶大吉");
    }

    @Override
    public Product buildProduct() {
        return product;
    }
}
