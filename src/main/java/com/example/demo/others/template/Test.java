package com.example.demo.others.template;

/**
 * @author landing guy
 * @date 2019/8/20
 * <p>
 * 模板方法模式
 */
public class Test {
    public static void main(String[] args) {
        DataViewer v1, v2;

        v1 = new XmlDataViewer();
        v2 = new FileDataViewer();

        v1.process();
        System.out.println("----------");
        v2.process();
    }
}
