package com.example.one.thread.bank;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class Children implements Runnable {
    private String name;
    private int money;
    private BankCard bankCard;
    private long frequency;

    public Children(String name, int money, BankCard bankCard, long frequency) {
        this.name = name;
        this.money = money;
        this.bankCard = bankCard;
        this.frequency = frequency;
    }

    @Override
    public void run() {
        while (true){
            bankCard.costMoney(name,money);
            try {
                Thread.sleep(frequency);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
