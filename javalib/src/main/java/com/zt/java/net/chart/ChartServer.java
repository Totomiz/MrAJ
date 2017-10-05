package com.zt.java.net.chart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class ChartServer {

    public static void main(String[] args){
        ServerSocket sever=null;
        try {
            sever=new ServerSocket(12345);
            System.out.println("Start:"+sever);
            while (true){
                Socket socket=sever.accept();
                ServerThread serverThread=new ServerThread(socket);
                serverThread.start();
                BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
                try {
                    String msg;
                    while ((msg=sin.readLine())!=null){
                        if(serverThread.isAlive()){
                            System.out.println("send");
                            serverThread.sendMessage(msg);
                        }else{
                            serverThread=null;
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sever != null) {
                try {
                    sever.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
