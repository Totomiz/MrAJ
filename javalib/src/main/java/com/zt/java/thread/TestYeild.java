package com.zt.java.thread;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class TestYeild extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i==5){
                Thread.yield();
            }
            System.out.println("name "+Thread.currentThread().getName()+" "+i);
        }


    }

    public static void main(String[] args){
        TestYeild t1=new TestYeild();
        TestYeild t2=new TestYeild();
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();



    }
}
