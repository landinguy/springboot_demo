package com.example.demo.others.decorator.demo2;

/**
 * @author landing guy
 * @date 2019/8/18
 * <p>
 * 装饰器模式
 */
public class Test {
    public static void main(String[] args) {
        Encryption e1, e2, e3, e4;
        e1 = new Encryption();

        e4 = new ThirdEncryption(e1);
        e3 = new SecondEncryption(e4);
        e2 = new FirstEncryption(e3);


//        e1.encrypt();
        e2.encrypt();//加密三次
//        e3.encrypt();
//        e4.encrypt();
    }
}
