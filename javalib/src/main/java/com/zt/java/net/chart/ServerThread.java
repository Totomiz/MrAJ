package com.zt.java.net.chart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class ServerThread extends Thread{
    private BufferedReader in;
    private PrintWriter pw;
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
        System.out.println("login:"+socket);
        try {
            in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw=new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String msg;
        try {
            while ((msg=in.readLine())!=null){
                System.out.println(msg);
                if(msg.equals("bye")){
                    break;
                }
            }
            close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendMessage(String msg){
        pw.println(msg);
        pw.flush();
    }

    public void close(){
        try {
            in.close();
            pw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
