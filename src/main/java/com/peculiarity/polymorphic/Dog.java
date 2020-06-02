package com.peculiarity.polymorphic;

/**
 * Created by root on 2019/11/1.
 */
public class Dog implements Animal {
    @Override
    public void eat(String food) {
        System.out.println("the dog like eat " + food);
    }

    @Override
    public void run() {
        System.out.println("ths dog is running!");
    }
}
