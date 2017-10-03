package com.zt.java.proxy;


import com.zt.java.proxy.Iinterface.IHello;
import com.zt.java.proxy.realize.China;
import com.zt.java.proxy.realize.World;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 */

public class MainPort {
    public static void main(String[] args){
        IHello china=new China();
        IHello world=new World();
        //代理调用World
        InvocationHandler worldHandler=new HelloHandler(world);
        IHello proxy1= (IHello) Proxy.newProxyInstance(world.getClass().getClassLoader(),world.getClass().getInterfaces(),worldHandler);
        proxy1.say();
        //代理调用China
        InvocationHandler chinaHandler=new HelloHandler(china);
        IHello proxy2= (IHello) Proxy.newProxyInstance(world.getClass().getClassLoader(),world.getClass().getInterfaces(),chinaHandler);
        proxy2.say();
    }
}
