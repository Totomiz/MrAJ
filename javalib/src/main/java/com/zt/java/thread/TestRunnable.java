package com.zt.java.thread;

import java.util.Date;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class TestRunnable implements Runnable {
    private String user;
    private long time;

    public TestRunnable(String user, long time) {
        this.user = user;
        this.time = time;
    }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(user + "take rest " + time + " ms:" + new Date());
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestRunnable user1 = new TestRunnable("tony1", 1000);
        TestRunnable user2 = new TestRunnable("tony2", 1000);
        new Thread(user1).start();
        new Thread(user2).start();
    }
}
