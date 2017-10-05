package com.zt.java.net.manyconversation;

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

public class ManyServer {
    public static void main(String[] args){
        ServerSocket serverSocket=null;
        boolean flag=true;
        try {
            ExecutorService pool= Executors.newFixedThreadPool(10);
            serverSocket=new ServerSocket(12345);
            InetAddress serverAddress=serverSocket.getInetAddress();
            System.out.println(serverAddress);
            System.out.println("---start server----");
            while (flag){
                Socket accept=serverSocket.accept();
                ServerThread serverThread=new ServerThread(accept);
                pool.execute(serverThread);
            }
            pool.shutdown();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ServerThread implements Runnable{

        private Socket accept;

        public ServerThread(Socket accept) {
            this.accept = accept;
        }

        @Override
        public void run() {
            try {
                System.out.println("client connection:"+accept.getInetAddress()+":"+accept.getLocalPort());
                BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in=new BufferedReader(new InputStreamReader(accept.getInputStream()));
                PrintWriter os=new PrintWriter(accept.getOutputStream());
                String receiveLine;
                while ((receiveLine=in.readLine())!=null){
                    System.out.println(accept.getInetAddress().getHostAddress()+":"+accept.getLocalPort()+" client:");
                    System.out.println(receiveLine+"\t"+new Date());
                    if(receiveLine.equals("bye")){
                        break;
                    }else{
                        //reply message
                        String replyLine;
                        replyLine=sin.readLine();
                        os.println(replyLine);
                        os.flush();
                    }
                    System.out.println("------------------");
                }
                os.close();
                sin.close();
                in.close();
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
