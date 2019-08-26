package com.example.demo.others.bridge;

import lombok.Data;

/**
 * @author landing guy
 * @date 2019/8/17
 */
@Data
public abstract class AbstractConverter {
    protected DataCenter dataCenter;

    public abstract void convert();

}
