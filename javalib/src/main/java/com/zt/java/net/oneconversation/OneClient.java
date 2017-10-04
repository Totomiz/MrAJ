package com.zt.java.net.oneconversation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class OneClient {
    //1.创建socket窗口
    //2.建立客户端所需要的输入输出流，客户端从键盘读取
    //3.循环读取键盘输入
    //4.while循环外关闭socket对象

    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.56.1");
            Socket socket = new Socket(inetAddress, 12345);
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter ow = new PrintWriter(socket.getOutputStream());
            //读取键盘输入
            String line;
            while ((line = sin.readLine()) != null) {
                System.out.println("-----------");
                ow.println(line);
                ow.flush();
                String responseLine = in.readLine();
                System.out.println("receive reply " + responseLine);
            }

            //            while (socket.isConnected()){
            //
            //                String responseLine;
            //                if((responseLine=in.readLine())!=null){
            //                    System.out.println("receive reply "+responseLine);
            //                }
            //
            //                String line;
            //                if((line=sin.readLine())!=null){
            //                    System.out.println("-----------");
            //                    ow.println(line);
            //                    ow.flush();
            //                }
            //
            //            }

            //关闭输入输出流
            in.close();
            ow.close();
            //关闭客户端
            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
