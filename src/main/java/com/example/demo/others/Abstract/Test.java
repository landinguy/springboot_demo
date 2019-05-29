package com.example.demo.others.Abstract;

/**
 * 模板方法模式
 */
public class Test {
    public static void main(String[] args) {
        AbstractPrint ap = new DefaultPrint();
        ap.execute("execute方法执行了");
    }
}
