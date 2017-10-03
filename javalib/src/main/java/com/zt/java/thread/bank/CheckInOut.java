package com.zt.java.thread.bank;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 * description: 爸爸妈妈爷爷存钱，两个女儿及儿子取钱
 */

public class CheckInOut {
    public static void main(String[] args){
        BankCard bankCard=new BankCard();
        Parents dad=new Parents("dady",1500,bankCard,500);
        Parents mom=new Parents("mom",1200,bankCard,800);
        Parents grandpa=new Parents("grandpa",800,bankCard,1000);
        Children sister=new Children("sister1",400,bankCard,600);
        Children little_sister=new Children("little_sister",300,bankCard,600);
        Children son=new Children("son",500,bankCard,600);
        new Thread(dad).start();
        new Thread(mom).start();
        new Thread(grandpa).start();
        new Thread(sister).start();
        new Thread(little_sister).start();
        new Thread(son).start();
    }
}
