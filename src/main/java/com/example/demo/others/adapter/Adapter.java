package com.example.demo.others.adapter;

/**
 * Created by xxf on 2018/9/20 0020.
 * <p>
 * 适配器类
 */
public class Adapter extends Adaptee implements Transfer {
    @Override
    public void op(int origin) {
        System.out.println("初始电压：" + origin + "V");
        output(origin);
    }
}
