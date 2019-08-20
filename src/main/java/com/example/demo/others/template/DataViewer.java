package com.example.demo.others.template;

/**
 * @author landing guy
 * @date 2019/8/20
 */
public abstract class DataViewer {

    //抽象方法：获取数据
    public abstract void getData();

    //具体方法：转换数据
    public void convertData() {
        System.out.println("将数据转换成xml格式");
    }

    //抽象方法：显示数据
    public abstract void display();

    //钩子方法：判断是否为XML格式的数据
    public boolean isNotXmlData() {
        return true;
    }

    //模板方法
    public void process() {
        getData();
        if (isNotXmlData()) {
            convertData();
        }
        display();
    }
}
