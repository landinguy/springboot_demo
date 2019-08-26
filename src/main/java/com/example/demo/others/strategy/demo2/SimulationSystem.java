package com.example.demo.others.strategy.demo2;

/**
 * @author landing guy
 * @date 2019/8/20
 */
public class SimulationSystem {
    private Plane plane;

    public SimulationSystem(Plane plane) {
        this.plane = plane;
    }

    public void simulate() {
        System.out.println("飞机种类：" + plane.getName());
        System.out.println("起飞特征：" + plane.takeOff());
        System.out.println("飞行特征：" + plane.fly());
    }

}
