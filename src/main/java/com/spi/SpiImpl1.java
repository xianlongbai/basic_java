package com.spi;

public class SpiImpl1 implements SPIService {
    @Override
    public void execute() {
        System.out.println("process oracle jdbc ...");
    }

    @Override
    public String getType() {
        return "oracle";
    }
}
