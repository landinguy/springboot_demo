package com.example.demo.others.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author landinguy
 * @date 2019/4/10 0010
 */
public class VolatileTest {
    private static volatile int race = 0;
    private static final int THREADS_COUNT = 10;
    private static ExecutorService service = Executors.newFixedThreadPool(10);

    private static void increase() {
        race++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < THREADS_COUNT; i++) {
            service.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            });
        }
        //等待所有线程累加结束
        while (Thread.activeCount() > 1) {
            System.out.println("activeCount: " + Thread.activeCount());
            System.out.println("race: " + race);
            Thread.yield();
        }

        System.out.println("race: " + race);
    }


}
