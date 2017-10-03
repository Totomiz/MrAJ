package com.zt.java.thread.bank;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class BankCard {
    private int sum=0;
    public synchronized void saveMoney(String name,int money){
        while (sum>5000){
            try {
                System.out.println(name +" :"+ "over 5000!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.sum+=money;
        System.out.println(name+" : "+"save $ "+money +" ,balance "+sum);
        notifyAll();
    }

    public synchronized void costMoney(String name,int money){
        while (sum<money){
            try {
                System.out.println(name +" :"+ "bank card has no money!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        this.sum-=money;
        System.out.println(name+":"+"Cost $"+money+" ,balance"+sum);
        notifyAll();
    }

}
