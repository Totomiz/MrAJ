package com.zt.java.net.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class TestUrl {

    public static void main(String[] args){
        try {
            URL url=new URL("http://www.sohu.com/a/196124134_115479?_f=index_news_6");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getDefaultPort());
            System.out.println(url.getPath());
            System.out.println(url.getFile());
            URLConnection conn = url.openConnection();
            //打开连接
            conn.connect();
            System.out.println(conn.getContentLength());
            System.out.println(conn.getContentType());
            System.out.println(conn.getDate());
            System.out.println(conn.getExpiration());
            System.out.println(conn.getLastModified());
            int c;
            InputStream is = conn.getInputStream();
            while ((c=is.read())!=-1){
                System.out.print((char)c);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
