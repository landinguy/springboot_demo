package com.example.demo.others.decorator.demo1;

/**
 * @author landing guy
 * @date 2019/8/18
 *
 * 具体装饰器，增加滚动条功能
 */
public class ScrollBarDecorator extends ComponentDecorator {
    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        setScrollBar();
        super.display();
    }

    public void setScrollBar() {
        System.out.println("设置滚动条");
    }
}
