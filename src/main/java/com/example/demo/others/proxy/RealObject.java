package com.example.demo.others.proxy;

/**
 * Created by xxf on 2018/3/6 0006.
 */
public class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String str) {
        System.out.println("somethingElse " + str);
    }

}
