package com.zt.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

public class OneServer {
    public static void main(String[] args){
        boolean flag=true;
        try {
            //创建容量为10 的线程池
            ExecutorService pool= Executors.newFixedThreadPool(10);
            InetAddress inetAddress=InetAddress.getByName("192.168.1.106");
            //启动服务器
            ServerSocket serverSocket=new ServerSocket(12345,20,inetAddress);
            System.out.println("start listener");

            while (flag){
                //接受客户端连接
                Socket accept = serverSocket.accept();
                InetAddress inetAddrss = accept.getInetAddress();
                System.out.println("aaaa-"+inetAddrss);
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
                BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));

                //客户端输入输出流
                BufferedReader is=new BufferedReader(new InputStreamReader(accept.getInputStream()));
                PrintWriter os=new PrintWriter(accept.getOutputStream());
                //读取客户端输入
                String line;
                while ((line=is.readLine())!=null){
                    System.out.println("receive:"+line +new Date());
                    //如果客户端输入“bye”命令，挂壁客户端连接
                    if(line.equals("bye")){
                        break;
                    }
//                    else{
//                        //读取键盘输入并回复
//                        os.write(sin.readLine());
//                        os.flush();
//                    }
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
