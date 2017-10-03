package com.zt.java.thread;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class TestSynchronized extends Thread{
    public  static int count=0;//不同线程对同一对象的操作

    public synchronized void funtion(){
        //保护函数
    }

    public void code(){
        synchronized (this){
            //保护代码块
        }
    }

    @Override
    public void run() {
        synchronized (this) {//加与不加的区别
            for (int i = 0; i < 10; i++) {
                count++;
                System.out.println(currentThread().getName() + " for loop " + count);
            }
        }

    }

    public static void main(String[] args){
        TestSynchronized t1=new TestSynchronized();
        TestSynchronized t2=new TestSynchronized();
        Thread thread1=new Thread(t1,"test1");
        Thread thread2=new Thread(t2,"test2");
        t1.start();
        t2.start();
    }
}
