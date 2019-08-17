package com.example.demo.others.prototype;

import lombok.extern.slf4j.Slf4j;

/**
 * @author landing guy
 * @date 2019/8/16
 * <p>
 * 浅克隆（在浅克隆中，当对象被复制时只复制它本身和其中包含的值类型的成员变量，而引用类型的成员对象并没有复制）
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        try {
            Student lucy = new Student("lucy", 18);

            Student clone = lucy.clone();
            log.info("lucy equals clone ? {}", clone.equals(lucy));//true
            log.info("lucy == clone ? {}", clone == lucy);//false

            clone.setName("jenny");
            clone.setAge(16);
            log.info("lucy#{}", lucy);
            log.info("clone#{}", clone);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
