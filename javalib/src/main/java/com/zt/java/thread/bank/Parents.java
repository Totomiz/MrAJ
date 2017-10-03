package com.zt.java.thread.bank;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 * description
 */

public class Parents implements Runnable{
    private String name;
    private int money;
    private BankCard bankCard;
    private long frequency;

    public Parents(String name, int money, BankCard bankCard, long frequency) {
        this.name = name;
        this.money = money;
        this.bankCard = bankCard;
        this.frequency = frequency;
    }


    @Override
    public void run() {
        while (true){
            bankCard.saveMoney(name,money);
            try {
                Thread.sleep(frequency);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
