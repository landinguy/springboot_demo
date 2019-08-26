package com.example.demo.others.strategy.demo2;

/**
 * @author landing guy
 * @date 2019/8/20
 */
public class AirPlane implements Plane {

    private final String name = "客机";

    @Override
    public String takeOff() {
        return "长距离起飞";
    }

    @Override
    public String fly() {
        return "亚音速飞行";
    }

    @Override
    public String getName() {
        return name;
    }
}
