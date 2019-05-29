package com.example.demo.others.Abstract;

/**
 * Created by xxf on 2018/9/30 0030.
 */
public abstract class AbstractPrint {

    public abstract void beforePrint();

    public abstract void afterPrint();

    public void execute(String str) {
        beforePrint();
        System.out.println("str: " + str);
        afterPrint();
    }

}
