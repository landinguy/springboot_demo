package com.example.demo.others.adapter;

/**
 * Created by xxf on 2018/9/20 0020.
 * <p>
 * 适配器模式
 */
public class Test {
    public static void main(String[] args) {
        Transfer t = new Adapter();
        t.op(110);
    }
}
