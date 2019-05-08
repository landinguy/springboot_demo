package com.example.demo.others.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock、Condition的使用
 */
public class Demo7 {

    public static void main(String[] args) throws InterruptedException {
        // Service service = new Service();
        // new Thread(() -> service.waitMethod()).start();
        // Thread.sleep(3000);
        // service.signalMethod();

        /*** 唤醒指定condition下的线程 ***/
        // Service service = new Service();
        // new Thread(() -> service.waitA(), "A").start();
        // new Thread(() -> service.waitB(), "B").start();
        // Thread.sleep(3000);
        // service.signalA();

        /*** 20个线程，10个打印A，10个打印B，交替执行 ***/
        Print print = new Print();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> print.printA()).start();
            new Thread(() -> print.printB()).start();
        }
    }

    static class Service {
        private ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();

        public void waitMethod() {
            try {
                lock.lock();
                System.out.println("A");
                System.out.println("await时间：" + System.currentTimeMillis());
                condition.await();
                System.out.println("signal时间：" + System.currentTimeMillis());
                System.out.println("B");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("锁释放了");
            }
        }

        public void waitA() {
            try {
                lock.lock();
                System.out.println("begin awaitA---threadName=" + Thread.currentThread().getName());
                conditionA.await();
                System.out.println("end awaitA---threadName=" + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void waitB() {
            try {
                lock.lock();
                System.out.println("begin awaitB---threadName=" + Thread.currentThread().getName());
                conditionB.await();
                System.out.println("end awaitB---threadName=" + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void signalMethod() {
            try {
                lock.lock();
                condition.signal();
            } finally {
                lock.unlock();
            }
        }

        /*** 唤醒所有A类线程 ***/
        public void signalA() {
            try {
                lock.lock();
                System.out.println("signalA---threadName=" + Thread.currentThread().getName());
                conditionA.signalAll();
            } finally {
                lock.unlock();
            }
        }

        /*** 唤醒所有B类线程 ***/
        public void signalB() {
            try {
                lock.lock();
                System.out.println("signalB---threadName=" + Thread.currentThread().getName());
                conditionB.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    /*** 交替打印 ***/
    static class Print {
        private ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private volatile boolean flagA = false;

        public void printA() {
            try {
                lock.lock();
                while (flagA) {
                    condition.await();
                }
                System.out.println("A----");
                flagA = true;
                condition.signalAll();//signalAll(),防止出现假死
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        public void printB() {
            try {
                lock.lock();
                while (!flagA) {
                    condition.await();
                }
                System.out.println("B------");
                flagA = false;
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}