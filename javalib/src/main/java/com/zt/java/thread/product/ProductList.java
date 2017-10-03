package com.zt.java.thread.product;


/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class ProductList {
    private int index=0;
    private Product[] productList=new Product[6];

    public synchronized void push(Product product){
        while (index==productList.length){
            try {
                System.out.println(product.getProducedBy()+" is waiting push");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productList[index]=product;
        index++;
        System.out.println(index +" "+ product.getProducedBy()+ " product:"+product);
        notifyAll();
        System.out.println(product.getProducedBy()+"  send notifyAll()");
    }

    public synchronized Product pop(String consumerName){
        while(index==0){
            try {
                System.out.println(consumerName+ " is waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        index--;
        Product product=productList[index];
        product.setConsumedBy(consumerName);
        System.out.println(index +" " +product.getConsumedBy() +" is Consumed:"+product);
        notifyAll();
        System.out.println(consumerName+" send notify all");
        return product;
    }

}
