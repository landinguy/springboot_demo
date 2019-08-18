package com.example.demo.others.decorator.demo1;

/**
 * @author landing guy
 * @date 2019/8/18
 * <p>
 * 抽象装饰器
 */
public class ComponentDecorator implements Component {
    private Component component;

    public ComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}
