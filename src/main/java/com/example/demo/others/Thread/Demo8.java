package com.example.demo.others.Thread;

/**
 * 两条线程，一条打印元音字母aeiou，一条打印其他字母。按字母表顺序打印
 */
public class Demo8 {
    public static void main(String[] args) {
        Job job = new Job();
        new Thread(() -> job.printYY()).start();
        new Thread(() -> job.printFY()).start();
    }

    static class Job {
        private static String str = "aeiou";
        private char current = 'a';

        /*** 判断是否是元音 ***/
        public boolean isYy(char s) {
            return str.indexOf(s) != -1;
        }

        /*** 打印元音字母 ***/
        public synchronized void printYY() {
            while (true) {
                try {
                    if (isYy(current)) {
                        System.out.println("currentThreadName:" + Thread.currentThread().getName() + ", current:" + current);
                        Thread.sleep(1000);

                        notifyAll();
                        if (current < 'z') {
                            current++;
                            if (current > 'u') return;
                        }
                    } else {
                        wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        /*** 打印辅音字母 ***/
        public synchronized void printFY() {
            while (true) {
                try {
                    if (!isYy(current)) {
                        System.out.println("currentThreadName:" + Thread.currentThread().getName() + ", current:" + current);
                        Thread.sleep(1000);

                        notifyAll();
                        if (current < 'z') {
                            current++;
                            if (current == 'z') {
                                System.out.println("currentThreadName:" + Thread.currentThread().getName() + ", current:" + current);
                                return;
                            }
                        }
                    } else {
                        wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
