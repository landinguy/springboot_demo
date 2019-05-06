package com.example.demo.others.Thread;

/**
 * synchronized块中的代码同步执行，不在synchronized块中的代码异步执行
 */
public class Demo3 {
    public static void main(String[] args) {
        Task task = new Task();
        new Thread(() -> task.doLongTimeTask(), "t1").start();
        new Thread(() -> task.doLongTimeTask(), "t2").start();
    }
}

class Task {
    public void doLongTimeTask() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("not synchronized threadName=" + Thread.currentThread().getName() + " i=" + i);
        }
        synchronized (this) {
            for (int i = 1; i <= 50; i++) {
                System.out.println("synchronized threadName=" + Thread.currentThread().getName() + " i=" + i);
            }
        }
    }
}