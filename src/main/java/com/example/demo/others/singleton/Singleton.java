package com.example.demo.others.singleton;

import lombok.Data;

/**
 * 单例模式（高效、线程安全）
 */
@Data
public class Singleton {

    private static Singleton singleton;
    private int field1, field2;

    private Singleton(int field1, int field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            // System.out.println("等待获取对象锁，threadName#" + Thread.currentThread().getName());
            // Thread.sleep(2000);
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static Singleton getInstance(int field1, int field2) {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton(field1, field2);
                }
            }
        }
        return singleton;
    }

    /*** 通过静态内部类实现单例 ***/
    private static class SingletonHandler {
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstanceByHandler() {
        return SingletonHandler.singleton;
    }

    /*** 通过枚举类实现单例 ***/
    private enum MyEnumSingleton {
        factory;
        private Singleton singleton;

        private MyEnumSingleton() {
            singleton = new Singleton();
        }

        public Singleton getSingleton() {
            return singleton;
        }
    }

    public static Singleton getInstanceByEnum() {
        return MyEnumSingleton.factory.getSingleton();
    }

}
