package com.example.demo.others.composite;

/**
 * @author landing guy
 * @date 2019/8/17
 */
public interface File {

    default void add(File file) {
        System.out.println("对不起，不支持该方法");
    }

    default void remove(File file) {
        System.out.println("对不起，不支持该方法");
    }

    default File getChild(int i) {
        System.out.println("对不起，不支持该方法");
        return null;
    }

    void killVirus();
}
