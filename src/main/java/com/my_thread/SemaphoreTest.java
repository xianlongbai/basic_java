package com.my_thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by root on 2019/4/18.
 *
 * 信号量的使用：信号量(Semaphore)，有时被称为信号灯，是在多线程环境下使用的一种设施, 它负责协调各个线程, 以保证它们能够正确、合理的使用公共资源。
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        System.out.println("系统线程数："+Runtime.getRuntime().availableProcessors());
        ExecutorService pool =  Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(4,true);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();//获取信号灯许可
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("Thread "+Thread.currentThread().getName()+" 进入" +"当前系统的并发数是："+(4-semaphore.availablePermits()));
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("Thread "+Thread.currentThread().getName()+" 即将离开");
                    semaphore.release();//释放信号灯
                    System.out.println("Thread "+Thread.currentThread().getName()+" 已经离开，当前系统的并发数是："+(4-semaphore.availablePermits()));
                }
            };
            pool.execute(runnable);

        }
    }



}
