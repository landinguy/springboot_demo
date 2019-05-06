package com.example.demo.others.Thread;

/**
 *
 */
public class Demo4 {
    public static void main(String[] args) {
        //代码同步执行，因为两个线程获取的是同一个对象的锁
        // Service service = new Service();
        // new Thread(() -> service.printA(), "t1").start();
        // new Thread(() -> service.printB(), "t2").start();

        //代码异步执行，因为两个线程获取的是两个不同对象的锁
        // Service s1 = new Service();
        // Service s2 = new Service();
        // new Thread(() -> s1.printA(), "t1").start();
        // new Thread(() -> s2.printB(), "t2").start();

        //代码同步执行，由于同步方法是静态方法，因此获取的是Class锁，通过两个对象获取的Class锁是一样的，故同步执行
        Service s3 = new Service();
        Service s4 = new Service();
        new Thread(() -> s3.printA1(), "t1").start();
        new Thread(() -> s4.printB1(), "t2").start();
    }
}

class Service {

    public synchronized void printA() {
        try {
            System.out.println("begin,threadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("end,threadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void printB() {
        try {
            System.out.println("begin,threadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            System.out.println("end,threadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static void printA1() {
        try {
            System.out.println("begin,threadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("end,threadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static void printB1() {
        try {
            System.out.println("begin,threadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            System.out.println("end,threadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}