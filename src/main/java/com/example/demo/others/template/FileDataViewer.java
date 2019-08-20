package com.example.demo.others.template;

/**
 * @author landing guy
 * @date 2019/8/20
 */
public class FileDataViewer extends DataViewer {
    @Override
    public void getData() {
        System.out.println("从文件中获取数据");
    }

    @Override
    public void display() {
        System.out.println("以折线图显示数据");
    }
}
