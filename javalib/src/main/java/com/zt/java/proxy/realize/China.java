package com.zt.java.proxy.realize;


import com.zt.java.proxy.Iinterface.IHello;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class China implements IHello {
    @Override
    public String say() {
        System.out.println("hello china");
        return "China";
    }
}
