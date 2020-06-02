package com.my_thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;


/**
 * Created by root on 2019/9/25.
 */
public class AtomicDemo {

    private static AtomicReference r = new AtomicReference(new Object());
    private static AtomicInteger i = new AtomicInteger(5);
    private static AtomicLong il = new AtomicLong(5L);

    public static void main(String[] args){

        int a = i.addAndGet(1);
        int b = i.addAndGet(1);
        int c = i.getAndIncrement();
        int d = i.incrementAndGet();
        i.compareAndSet(9, 100);
        System.out.println(i);

        LongAdder la = new LongAdder();
        la.add(9);
        la.increment();
        System.out.println(la);



    }


}
