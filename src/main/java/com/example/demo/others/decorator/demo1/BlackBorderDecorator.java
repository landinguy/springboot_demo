package com.example.demo.others.decorator.demo1;

/**
 * @author landing guy
 * @date 2019/8/18
 * <p>
 * 具体装饰器，增加黑色边框
 */
public class BlackBorderDecorator extends ComponentDecorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        setBlackBorder();
        super.display();
    }

    public void setBlackBorder() {
        System.out.println("设置黑色边框");
    }
}
