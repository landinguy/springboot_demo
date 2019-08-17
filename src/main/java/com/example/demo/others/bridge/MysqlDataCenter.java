package com.example.demo.others.bridge;

/**
 * @author landing guy
 * @date 2019/8/17
 */
public class MysqlDataCenter implements DataCenter {
    @Override
    public void getData() {
        System.out.println("从mysql获取数据");
    }
}
