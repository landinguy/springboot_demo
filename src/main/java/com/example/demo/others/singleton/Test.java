package com.example.demo.others.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {
    public static void main(String[] args) {
        // Singleton singleton = Singleton.getInstance(1, 2);
        // log.info("singleton#{}", singleton);
        // log.info("singleton#{}", Singleton.getInstance());

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // try {
                // log.info("hashcode#{}", Singleton.getInstance().hashCode());
                // log.info("hashcode#{}", Singleton.getInstanceByHandler().hashCode());
                log.info("hashcode#{}", Singleton.getInstanceByEnum().hashCode());
                // } catch (Exception e) {
                //     e.printStackTrace();
                // }
            }).start();
        }
    }
}
