package com.example.demo.others.Timer;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer的使用
 */
@Slf4j
public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // timer.schedule(new MyTask(), 2000);
        timer.schedule(new MyTask(), 0, 2000);
        log.info("time#{}", System.currentTimeMillis());
    }

    static class MyTask extends TimerTask {
        @Override
        public void run() {
            log.info("任务被执行了，time#{}", System.currentTimeMillis());
        }
    }
}
