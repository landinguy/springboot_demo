package com.example.demo.others.Thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * java几种线程池用法比较
 */
@Slf4j
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //固定大小的线程池，输出效果：每隔2s打印两个数字
        // ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        // for (int i = 0; i < 10; i++) {
        //     fixedThreadPool.execute(new MyThread(i));
        // }

        //缓存线程池，为每一个任务创建一个线程，输出效果：几乎同时打印0-9
        // ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        // for (int i = 0; i < 10; i++) {
        //     cachedThreadPool.execute(new MyThread(i));
        // }

        //单线程线程池，只有一个线程。输出效果：每隔2s打印一个数字
        // ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        // for (int i = 0; i < 10; i++) {
        //     singleThreadExecutor.execute(new MyThread(i));
        // }

        //可调度线程池，可创建定时任务。
        // ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        //只执行一次的任务
        // scheduledExecutorService.schedule(() -> log.info("time#{}", System.currentTimeMillis()), 0, TimeUnit.SECONDS);
        // scheduledExecutorService.shutdown();
        //指定周期执行的任务
        // scheduledExecutorService.scheduleAtFixedRate(() -> log.info("time#{}", System.currentTimeMillis()), 0, 1, TimeUnit.SECONDS);

        //Callable取得线程执行结果
        // ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        // List<Future<String>> list = new ArrayList<>();
        // for (int i = 0; i < 10; i++) {
        //     Future<String> result = fixedThreadPool.submit(new MyCallable(i));
        //     list.add(result);
        // }
        //
        // for (Future<String> f : list) {
        //     try {
        //         log.info(f.get());
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     } catch (ExecutionException e) {
        //         e.printStackTrace();
        //     }
        // }


        //FutureTask可作为一个线程被执行，还可记录下该线程执行结果
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.info("开始计算...");
            Thread.sleep(2000);
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return sum + "";
        });
        new Thread(futureTask).start();
        try {
            log.info("计算结果#{}", futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class MyThread implements Runnable {
        private int i;

        public MyThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                log.info("i#{}", i);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //也可用于创建线程，与Runnable区别是有返回结果
    static class MyCallable implements Callable<String> {
        private int i;

        public MyCallable(int i) {
            this.i = i;
        }

        @Override
        public String call() {
            log.info("threadName#{},i#{}", Thread.currentThread().getName(), i);
            return i + "的平方=" + i * i;
        }
    }

}
