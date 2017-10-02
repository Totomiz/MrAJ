package com.zt.java.thread;

import java.util.Date;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class TestThread extends Thread{
    private String user;
    private long sleepTime;

    public TestThread(String name,long sleepTime){
        this.user=name;
        this.sleepTime=sleepTime;
    }


    public static void main(String[] args){
        TestThread t1=new TestThread("user1",1000);
        TestThread t2=new TestThread("user2",2000);
        TestThread t3=new TestThread("user3",1500);
        TestThread t4=new TestThread("user4",4000);
        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println(user+"休息"+sleepTime+"ms-"+new Date());
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
