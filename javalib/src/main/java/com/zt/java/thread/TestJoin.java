package com.zt.java.thread;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class TestJoin extends Thread{
    int count;
    public static void main(String[] args){
        String name = Thread.currentThread().getName();
        System.out.println("current thread:"+name);
        TestJoin testJoin = new TestJoin();
        testJoin.start();//start要先在join前调用
        //加入join count=100，不加随机
        try {
            testJoin.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count:"+testJoin.count);
        System.out.println("end");
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            count++;
        }
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
