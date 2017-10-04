package com.zt.java.net.oneconversation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class OneServer {
    //1.建立ServerSocket对象
    //2.循环监听客户端连接
    //3.连接后建立输入输出流对象
    //4.应答客户端信息
    //5.finally关闭对象
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            InetAddress address = InetAddress.getByName("192.168.56.1");
            serverSocket = new ServerSocket(12345, 20, address);
            InetAddress serverAddress = serverSocket.getInetAddress();
            System.out.println("server start:" + serverAddress + ":" + serverSocket.getLocalPort());
            while (true) {
                Socket accept = serverSocket.accept();
                InetAddress clientAddress = accept.getInetAddress();
                int clientPort = accept.getLocalPort();
                System.out.println("client login:" + clientAddress + ":" + clientPort);

                //server 输入
                BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                PrintWriter pw = new PrintWriter(accept.getOutputStream());
                //循环处理客户端输入

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("receive client:" + line);
                    if (line.equals("bye")) {
                        break;
                    } else {

                        String replyString = sin.readLine();
                        pw.println("server :" + replyString);
                        pw.flush();
                    }

                }

                //                while (accept.isConnected()){
                //                    String line;
                //                    if((line=in.readLine())!=null){
                //                        System.out.println("receive client:"+line);
                //                    }
                //
                //                    String re;
                //                    if((re=sin.readLine())!=null){
                //                        pw.println("server:"+re);
                //                        pw.flush();
                //                    }
                //
                //                }

                System.out.println("why?");

                //关闭连接
                in.close();
                pw.close();
                accept.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
