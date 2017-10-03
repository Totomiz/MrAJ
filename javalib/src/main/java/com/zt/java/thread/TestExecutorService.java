package com.zt.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class TestExecutorService extends Thread{
    @Override
    public void run() {
        ExecutorService service= Executors.newFixedThreadPool(2);
        for (int i = 0; i < 100; i++) {
            //定义一个内部类
            Runnable runnable=new Runnable() {
                @Override
                public void run() {

                    try {
                        long v = (long) (Math.random() * 1000);
                        System.out.println("休眠 "+v+" ms");
                        Thread.sleep(v);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
        //必须关闭线程池
        service.shutdown();
    }

    public static void main(String[] args){
        new TestExecutorService().start();
    }
}
