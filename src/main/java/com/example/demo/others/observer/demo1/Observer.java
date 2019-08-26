package com.example.demo.others.observer.demo1;

/**
 * @author landing guy
 * @date 2019/8/22
 * <p>
 * 抽象观察类
 */
public interface Observer {
    void setName(String name);

    String getName();

    //支援
    void help();

    //被袭击
    void attacked(AbstractControlCenter center);
}
