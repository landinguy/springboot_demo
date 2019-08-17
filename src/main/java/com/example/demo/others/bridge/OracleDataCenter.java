package com.example.demo.others.bridge;

/**
 * @author landing guy
 * @date 2019/8/17
 */
public class OracleDataCenter implements DataCenter {
    @Override
    public void getData() {
        System.out.println("从oracle获取数据");
    }
}
