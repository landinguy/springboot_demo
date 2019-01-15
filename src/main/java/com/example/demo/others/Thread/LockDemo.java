package com.example.demo.others.Thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author landinguy
 * @date 2019/1/16 0016
 * ReentrantLock的使用
 */
@Slf4j
public class LockDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread, "a").start();
        new Thread(myThread, "b").start();
    }


}

@Slf4j
class MyThread implements Runnable {
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            lock.lock();//加锁，防止多个线程一起调用
            for (int i = 0; i < 5; i++) {
                log.info(Thread.currentThread().getName() + ":" + i);
            }
        } finally {
            lock.unlock();// 别忘了执行unlock()方法释放锁
        }
    }
}
