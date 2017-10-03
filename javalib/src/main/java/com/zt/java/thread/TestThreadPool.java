package com.zt.java.thread;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class TestThreadPool {
    //创建一个容量为10的线程池
    //创建一个serversocket服务端监听程序，端口为12345
    //使用while开始监听客户端的连接，如果收到客户端的连接accept(),则根据对客户端对象socket创建一个独立线程来处理该客户端的事物，该线程从线程池中创建
    //对于每一个客户端的处理线程，需要开发一个独立的serverTHread，我们把他作为子类创建。
    //由于要使用线程池，因此该类必须是线程类，实现runnable接口即可
    //在他的构造函数中设置线程类处理的客户端socket对象
    //在run（）中，建立客户端的输入输出流连接，使用while读取客户端的输入行，并回复给客户端，如果客户端输入bye命令，则关闭该客户端的连接
    //

    public static void main(String[] args){
        boolean flag=true;
        try {
            //创建容量为10 的线程池
            ExecutorService pool= Executors.newFixedThreadPool(10);
            InetAddress inetAddress=InetAddress.getLocalHost();
            //启动服务器
            //localhost
            ServerSocket serverSocket=new ServerSocket(12345,20,inetAddress);
            //127.0.0.1
            //ServerSocket serverSocket=new ServerSocket(12345,20,inetAddress);
            System.out.println("start listener");

            while (flag){
                //接受客户端连接
                Socket accept = serverSocket.accept();
                InetAddress clientAddrss = accept.getInetAddress();
                System.out.println("client InetAddress: "+clientAddrss);
                //为客户端创建独立的连接
                pool.execute(new ServiceThread(accept));
            }
            serverSocket.close();
            pool.shutdown();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ServiceThread implements Runnable {
        private Socket accept=null;
        public ServiceThread(Socket accept) {
            this.accept=accept;
        }

        @Override
        public void run() {
            try {
                //客户端输入输出流
                DataInputStream is=new DataInputStream(new BufferedInputStream(accept.getInputStream()));
                OutputStream os=accept.getOutputStream();
                //读取客户端输入
                String inputLine;
                while ((inputLine=is.readLine())!=null){
                    //如果客户端输入“bye”命令，挂壁客户端连接
                    if(inputLine.equals("bye")){
                        System.out.println("client say goodbye!!! "+"\t"+new Date());
                        break;
                    }else{
                        System.out.println("client message:"+inputLine+"\t"+new Date());
                        os.write(("server reply: "+inputLine+"\t"+new Date()+"\r\n").getBytes());
                    }
                }
                is.close();
                os.close();
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
