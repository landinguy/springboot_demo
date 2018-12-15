package com.example.demo.others.Thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xxf on 2018/12/16 0016.
 * <p>
 * Java多线程面试题：假如有Thread1、Thread2、Thread3、Thread4四条线程分别统计C、D、E、F四个盘的大小，
 * 所有线程都统计完毕交给Thread5线程去做汇总，应当如何实现？
 */
@Slf4j
public class Demo1 {

    public static void main(String[] args) {
        //创建一个能容纳4个线程的减数器
        final CountDownLatch count = new CountDownLatch(4);
        //创建一个固定大小的线程池
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(() -> {
            try {
                Thread.sleep(3000);
                log.info("统计c盘");
                count.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                Thread.sleep(3000);
                log.info("统计d盘");
                count.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                Thread.sleep(3000);
                log.info("统计e盘");
                count.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                Thread.sleep(3000);
                log.info("统计f盘");
                count.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            count.await();//主线程，即第5线程等待
            log.info("合计C,D,E,F");
            service.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
