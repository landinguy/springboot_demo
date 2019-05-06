package com.example.demo.others.Thread;

/**
 * 实例变量导致非线程安全问题
 */
public class Demo2 {
    public static void main(String[] args) {
        HasSelfPrivateNum HSPN = new HasSelfPrivateNum();
        new Thread(() -> HSPN.add("a")).start();
        new Thread(() -> HSPN.add("b")).start();
    }
}

class HasSelfPrivateNum {
    private int num = 0;

    /*** 将该方法改为同步方法即可保证多线程安全 ***/
    public void add(String name) {
        try {
            if (name.equals("a")) {
                num = 100;
                System.out.println("a set over");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over");
            }
            System.out.println(name + " num=" + num);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
