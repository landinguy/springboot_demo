package com.example.demo.others.builder;

/**
 * Created by xxf on 2018/9/29 0029.
 * builder模式
 */
public class Student {
    private String name;
    private int age;
    private String sex;

    public Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "name:" + this.name + " ,age:" + this.age + " ,sex:" + this.sex;
    }

    public static final class Builder {
        String name, sex;
        int age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
