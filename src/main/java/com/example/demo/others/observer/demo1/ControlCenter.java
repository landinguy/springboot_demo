package com.example.demo.others.observer.demo1;

/**
 * @author landing guy
 * @date 2019/8/22
 * <p>
 * 具体战队控制中心类：具体目标类
 */
public class ControlCenter extends AbstractControlCenter {

    public ControlCenter(String name) {
        super(name);
    }

    @Override
    public void notifyObserver(String name) {
        System.out.println(this.name + "战队紧急通知，队员" + name + "遭到攻击！请求支援");
        for (Observer o : list) {
            if (!o.getName().equalsIgnoreCase(name)) {
                o.help();
            }
        }
    }
}
