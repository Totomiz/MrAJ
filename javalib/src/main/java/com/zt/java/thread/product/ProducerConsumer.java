package com.zt.java.thread.product;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class ProducerConsumer {

    public static void main(String[] args){
        ProductList productList=new ProductList();
        Producer producer1=new Producer("producer1",productList,1000);
        Producer producer2=new Producer("producer2",productList,1000);
        Consumer consumer1=new Consumer("consumerA",productList,2000);
        Consumer consumer2=new Consumer("consumerB",productList,2000);
        Consumer consumer3=new Consumer("consumerC",productList,2000);
        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();
    }
}
