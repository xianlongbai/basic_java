package com.my_thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangeTest {

    public static void main(String[] args) {
        final ExecutorService service = Executors.newCachedThreadPool();
        final Exchanger<String> changer = new Exchanger<String>();
        service.submit(new Runnable(){
            public void run(){
                try{
                    String data1 = "北京老冰棍";
                    System.out.println("线程 "+Thread.currentThread().getName()+" 正在把 "+data1+" 拿出来");
                    String data2 = changer.exchange(data1);
                    System.out.println("线程 "+Thread.currentThread().getName()+"用 "+data1+" 换来了"+data2);
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    service.shutdown();
                    System.out.println(Thread.currentThread().getName()+"交易完毕，撤！");
                }
            }
        });
        service.submit(new Runnable(){
            public void run(){
                try{
                    String data1 = "100元";
                    System.out.println("线程 "+Thread.currentThread().getName()+" 正在把钱 "+data1+" 拿出来");
                    String data2 = changer.exchange(data1);
                    System.out.println("线程 "+Thread.currentThread().getName()+"用 "+data1+"换来了"+data2);
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    service.shutdown();
                    System.out.println(Thread.currentThread().getName()+"交易完毕，撤！");
                }
            }
        });
    }

}
