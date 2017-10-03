package com.zt.java.proxy.realize;


import com.zt.java.proxy.Iinterface.IHello;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class World implements IHello {
    @Override
    public String say() {
        System.out.println("this is hello world");
        return "world";
    }
}
