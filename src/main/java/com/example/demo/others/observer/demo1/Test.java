package com.example.demo.others.observer.demo1;

/**
 * @author landing guy
 * @date 2019/8/22
 * <p>
 * 观察者模式
 */
public class Test {
    public static void main(String[] args) {
        AbstractControlCenter center;
        Observer o1, o2, o3, o4, o5;

        center = new ControlCenter("K&K");
        o1 = new player("Demo");
        center.join(o1);
        o2 = new player("Grunt");
        center.join(o2);
        o3 = new player("九七");
        center.join(o3);
        o4 = new player("One");
        center.join(o4);
        o5 = new player("DT");
        center.join(o5);
//        center.quit(o4);

        o1.attacked(center);
    }
}
