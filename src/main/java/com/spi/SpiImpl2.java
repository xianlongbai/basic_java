package com.spi;

public class SpiImpl2 implements SPIService {
    @Override
    public void execute() {
        System.out.println("process mysql jdbc ...");
    }

    @Override
    public String getType() {
        return "mysql";
    }
}
