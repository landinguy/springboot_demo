package com.example.demo.others.Thread;

/**
 * 两种方法解决以下出现的多线程问题
 * 1.将add方法改为同步方法
 * 2.将count改为AtomicInteger类型
 */
public class Demo5 {
    public static void main(String[] args) {
        Thread[] arr = new Thread[50];
        CountService countService = new CountService();
        for (int i = 0; i < 50; i++) {
            arr[i] = new Thread(() -> countService.add());
        }
        for (int i = 0; i < 50; i++) {
            arr[i].start();
        }
        // try {
        //     Thread.sleep(3000);
        //     System.out.println("最终count=" + countService.getCount());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

    }
}

class CountService {
    private int count = 0;
    // private AtomicInteger count = new AtomicInteger(0);

    public void add() {
        for (int i = 0; i < 200; i++) {
            count++;
            // count.incrementAndGet();
        }
        System.out.println("count=" + count);
        // System.out.println("count=" + count.get());
    }

    // public int getCount() {
    //     return count.get();
    // }

}