package com.design_pattern.建造者模式;

/**
 * Created by root on 2019/5/12.
 */
public interface Builder {

    /**
     * 打基础
     */
    public void  buildBasic();

    /**
     * 砌墙
     */
    public void  buildWalls();

    /**
     * 封顶
     */
    public void  roofed();

    /**
     * 造房子
     * @return
     */
    public Product buildProduct();

}
