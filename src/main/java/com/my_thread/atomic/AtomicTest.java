package com.my_thread.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by root on 2019/9/25.
 */
public class AtomicTest {

    private static AtomicInteger a = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch begin = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    a.getAndIncrement();
                    a.incrementAndGet();
                    begin.countDown();
                }
            }).start();
        }

        System.out.println("start ...");
        begin.await();
        System.out.println("result is :" + a.get());
    }



}
