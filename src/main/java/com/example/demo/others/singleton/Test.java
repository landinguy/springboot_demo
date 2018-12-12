package com.example.demo.others.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance(1, 2);
        log.info("singleton#{}", singleton);
        log.info("singleton#{}", Singleton.getInstance());
    }
}
