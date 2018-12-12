package com.example.demo.others.proxy;

/**
 * Created by xxf on 2018/3/6 0006.
 * 代理模式案例
 */
public class SimpleProxyDemo {

    public static void main(String[] args) {
//        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("xxf");
    }
}
