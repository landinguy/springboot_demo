package com.example.demo.others.prototype;

import lombok.Data;

/**
 * @author landing guy
 * @date 2019/8/16
 */
@Data
public class Student implements Cloneable {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}
