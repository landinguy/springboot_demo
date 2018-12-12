package com.example.demo.others.builder;

/**
 * Created by xxf on 2018/9/29 0029.
 */
public class Test {
    public static void main(String[] args) {
        Student stu = Student.builder().name("jack").age(18).sex("man").build();
        System.out.println(stu);
    }
}
