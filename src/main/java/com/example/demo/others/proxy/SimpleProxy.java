package com.example.demo.others.proxy;

/**
 * Created by xxf on 2018/3/6 0006.
 */
public class SimpleProxy implements Interface {

    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String str) {
        System.out.println("SimpleProxy somethingElse " +str);
        proxied.somethingElse(str);
    }
}
