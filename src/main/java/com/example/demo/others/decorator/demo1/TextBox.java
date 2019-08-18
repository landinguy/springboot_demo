package com.example.demo.others.decorator.demo1;

/**
 * @author landing guy
 * @date 2019/8/18
 */
public class TextBox implements Component {
    @Override
    public void display() {
        System.out.println("显示文本框");
    }
}
