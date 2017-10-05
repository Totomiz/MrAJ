package com.zt.java.net.manyconversation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class ManyClient {
    public static void main(String[] args){
        Socket socket=null;
        try {
            socket=new Socket("localhost",12345);
            System.out.println(socket.getInetAddress());
            System.out.println("------client start:-------");
            BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os=new PrintWriter(socket.getOutputStream());
            String inputLine;
            while ((inputLine=sin.readLine())!=null){
                System.out.println("------------");
                os.println(inputLine);
                os.flush();
                String receiveLine;
                receiveLine=in.readLine();
                System.out.println("server:"+receiveLine+"\t"+new Date());
            }

            in.close();
            os.close();
            sin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){
                try {
                    socket.close();
                    System.exit(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
