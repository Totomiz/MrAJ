package com.zt.java.thread;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class TestThreadGroup {
    public static void main(String[] args){
        ThreadGroup group1=new ThreadGroup("GROUP1");
        ThreadGroup group2=new ThreadGroup(group1, "GROUP2");
        Thread thread1=new Thread(group1,new TestThread("aaa",1000));
        Thread thread2=new Thread(group2,new TestThread("BBB",1100));
        Thread thread3=new Thread(group2,new TestThread("CCC",800));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
