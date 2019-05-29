package com.example.demo.others.Abstract;

/**
 * Created by xxf on 2018/9/30 0030.
 */
public class DefaultPrint extends AbstractPrint {

    @Override
    public void beforePrint() {
        System.out.println("execute执行前的操作");
    }

    @Override
    public void afterPrint() {
        System.out.println("execute执行后的操作");
    }
}
