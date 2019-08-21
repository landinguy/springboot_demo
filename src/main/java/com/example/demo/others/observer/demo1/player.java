package com.example.demo.others.observer.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author landing guy
 * @date 2019/8/22
 * <p>
 * 战队成员类：具体观察者类
 */
@Data
@AllArgsConstructor
public class player implements Observer {
    private String name;

    @Override
    public void help() {
        System.out.println("队友" + name + "正前往支援~~");
    }

    @Override
    public void attacked(AbstractControlCenter center) {
        System.out.println(name + "被袭击");
        center.notifyObserver(name);
    }
}
