package com.zt.java.net.chart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class ChartClient {
    public static void main(String[] args){
        int random = (int) (Math.random()*10);
        ClientThread clientThread=new ClientThread("user"+random);
        clientThread.start();
        BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));

        try {
            String msg;
            while ((msg=sin.readLine())!=null){
                clientThread.sendMessage(msg);
                if(msg.equals("bye")){
                    clientThread.close();
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
