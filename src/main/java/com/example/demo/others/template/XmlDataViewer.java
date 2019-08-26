package com.example.demo.others.template;

/**
 * @author landing guy
 * @date 2019/8/20
 */
public class XmlDataViewer extends DataViewer {
    @Override
    public void getData() {
        System.out.println("从xml中获取数据");
    }

    @Override
    public void display() {
        System.out.println("以柱状图显示数据");
    }

    @Override
    public boolean isNotXmlData() {
        return false;
    }
}
