package com.example.demo.others.Thread;

/**
 * @author landinguy
 * <p>
 * Created on 2018/12/17 0017.
 */
public class JoinTest implements Runnable {
    private String str;
    private int n = 0;

    public JoinTest(String str) {
        this.str = str;
    }

    public static void main(String[] args) throws Exception {
        JoinTest a = new JoinTest("a");
        Thread t1 = new Thread(a);
        t1.start();

        JoinTest b = new JoinTest("b");
        Thread t2 = new Thread(b);
        t2.start();
        t2.join();//只会影响到join方法后的代码，表示t2线程结束后，t3才能开始运行

        JoinTest c = new JoinTest("c");
        Thread t3 = new Thread(c);
        t3.start();
    }

    @Override
    public void run() {
        while (n < 10) {
            System.out.println(str + "--------------" + n++);
        }
    }
}
