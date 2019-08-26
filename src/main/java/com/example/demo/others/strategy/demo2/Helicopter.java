package com.example.demo.others.strategy.demo2;

/**
 * @author landing guy
 * @date 2019/8/20
 */
public class Helicopter implements Plane {

    private final String name = "直升机";

    @Override
    public String takeOff() {
        return "垂直起飞";
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
