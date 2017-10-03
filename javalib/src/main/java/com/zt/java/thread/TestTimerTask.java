package com.zt.java.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class TestTimerTask extends TimerTask {
    private Timer timer;
    public TestTimerTask(Timer timer){
        this.timer=timer;
    }
    @Override
    public void run() {
        System.out.println(new Date());
        if(timer!=null){
            timer.cancel();
        }
    }
    public static void main(String[] args){
        Timer timer=new Timer();
        TestTimerTask testTimerTask = new TestTimerTask(timer);
        timer.schedule(testTimerTask,5000);
        long l = testTimerTask.scheduledExecutionTime();
        System.out.println("main"+l);
    }
}
