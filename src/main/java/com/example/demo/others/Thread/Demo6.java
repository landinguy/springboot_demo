package com.example.demo.others.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建20个线程，10个线程将数据备份到A数据库，10个线程将数据备份到数据库B
 * 并且A，B交叉进行
 */
public class Demo6 {
    public static void main(String[] args) {
        // DBTool dbTool = new DBTool();
        // for (int i = 0; i < 10; i++) {
        //     new Thread(() -> dbTool.backupA()).start();
        //     new Thread(() -> dbTool.backupB()).start();
        // }


        /*** 使用ReentrantLock实现 ***/
        DBTool2 dbTool2 = new DBTool2();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> dbTool2.backupA()).start();
            new Thread(() -> dbTool2.backupB()).start();
        }
    }

    /*** 使用ReentrantLock实现 ***/
    static class DBTool2 {
        private volatile boolean isA = false;
        private ReentrantLock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();

        public void backupA() {
            try {
                lock.lock();
                while (isA) {
                    conditionA.await();
                }
                System.out.println("A****");
                isA = true;
                conditionB.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void backupB() {
            try {
                lock.lock();
                while (!isA) {
                    conditionB.await();
                }
                System.out.println("B******");
                isA = false;
                conditionA.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

class DBTool {
    //使用volatile保证变量在多个线程间的可见性
    private volatile boolean isA = false;

    public synchronized void backupA() {
        try {
            /**
             * 注意这里一定要用while才能保证A，B交替备份。
             * 因为当notifyAll唤醒多个A类线程时，
             * 如果是if，那接下来这几个A类线程可能连续执行backupA方法，导致不能保证A，B交替备份
             * 而while的话，唤醒的A类线程继续执行的话，会再次判断下isA，
             * 如果上一次备份的是A，由于isA为true，故该A类线程进入阻塞状态。
             *
             **/
            // if (isA) {
            //     wait();
            // }

            while (isA) {
                wait();
            }
            System.out.println("A****");
            isA = true;
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void backupB() {
        try {

            // if (!isA) {
            //     wait();
            // }

            while (!isA) {
                wait();
            }
            System.out.println("B******");
            isA = false;
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}