package com.zt.java.thread.product;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class Consumer implements Runnable{
    private String name;
    private ProductList productList=null;
    private long frequency;

    public Consumer(String name, ProductList productList, long frequency) {
        this.name = name;
        this.productList = productList;
        this.frequency = frequency;
    }


    @Override
    public void run() {
        while (true){
            try {
                productList.pop(name);
                Thread.sleep(frequency);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
