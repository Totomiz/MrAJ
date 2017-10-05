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

public class ClientThread extends Thread {
    public Socket accept;
    private BufferedReader in;
    private PrintWriter os;
    private String userName;
    private static final int port = 12345;
    private static final String host = "localhost";

    public ClientThread(String userName) {
        this.userName = userName;
        try {
            accept = new Socket(host, port);
            System.out.println("client info:"+accept);
            in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            os = new PrintWriter(accept.getOutputStream());
            os.println(userName);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //read server message by cycle
        try {
            String message;
            while ((message=in.readLine())!=null){
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * send message to server
     *
     * @param msg message
     */
    public void sendMessage(String msg) {
        os.println(msg);
        os.flush();
    }

    public void close() {
        try {
            in.close();
            os.close();
            accept.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
