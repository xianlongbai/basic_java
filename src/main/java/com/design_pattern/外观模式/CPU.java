package com.design_pattern.外观模式;

import java.util.logging.Logger;

/**
 * Created by root on 2019/5/26.
 */
public class CPU {

    public void startup(){
        System.out.println("cpu startup!");
    }

    public void shutdown(){
        System.out.println("cpu shutdown!");
    }
}
