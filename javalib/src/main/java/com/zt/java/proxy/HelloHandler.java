package com.zt.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 * 动态代理
 */

public class HelloHandler implements InvocationHandler{
    private Object proxyed;

    public HelloHandler(Object proxyed) {
        this.proxyed = proxyed;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("start to say");
        result=method.invoke(this.proxyed,args);
        System.out.println("end say!");
        return result;
    }
}
