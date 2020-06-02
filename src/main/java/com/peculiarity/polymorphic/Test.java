package com.peculiarity.polymorphic;

/**
 * Created by root on 2019/11/1.
 */
public class Test {

    public static void main(String[] args){
        Animal animal = new Dog();
        animal.eat("西瓜");
        animal.run();
    }

}
