package com.example.demo.others.decorator.demo1;

/**
 * @author landing guy
 * @date 2019/8/18
 * <p>
 * 装饰器模式
 */
public class Test {
    public static void main(String[] args) {
        Component c1, c2, c3;
        c1 = new Window();
        c2 = new ScrollBarDecorator(c1);
        c3 = new BlackBorderDecorator(c2);

//        c1.display();
//        c2.display();
        c3.display();
    }
}
