package com.example.demo.others.strategy.demo2;

/**
 * @author landing guy
 * @date 2019/8/20
 * <p>
 * 策略模式
 */
public class Test {
    public static void main(String[] args) {
        Plane plane;

//        plane = new Helicopter();
        plane = new AirPlane();

        SimulationSystem system = new SimulationSystem(plane);
        system.simulate();
    }
}
