package com.example.demo.others.bridge;

/**
 * @author landing guy
 * @date 2019/8/17
 */
public class TxtConverter extends AbstractConverter {
    @Override
    public void convert() {
        dataCenter.getData();
        System.out.println("将数据转换成txt格式");
    }
}
