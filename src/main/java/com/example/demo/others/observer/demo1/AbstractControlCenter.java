package com.example.demo.others.observer.demo1;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author landing guy
 * @date 2019/8/22
 * <p>
 * 战队控制中心类：目标类
 */
@Data
public abstract class AbstractControlCenter {
    protected String name;
    protected List<Observer> list = new ArrayList<>();

    public AbstractControlCenter(String name) {
        System.out.println(name + "战队组建成功！！");
        System.out.println("**********");
        this.name = name;
    }

    public void join(Observer observer) {
        System.out.println(observer.getName() + "加入" + name + "战队！");
        list.add(observer);
    }

    public void quit(Observer observer) {
        System.out.println(observer.getName() + "离开" + name + "战队！");
        list.remove(observer);
    }

    public abstract void notifyObserver(String name);
}
