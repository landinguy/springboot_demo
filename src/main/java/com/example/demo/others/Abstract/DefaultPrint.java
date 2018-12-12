package com.example.demo.others.Abstract;

/**
 * Created by xxf on 2018/9/30 0030.
 */
public class DefaultPrint extends AbstractPrint {
    @Override
    public void print(String str) {
        System.out.println("print: " + str);
    }

    public static void main(String[] args) {
        AbstractPrint ap = new DefaultPrint();
        ap.excutePrint("hello world");
    }
}
