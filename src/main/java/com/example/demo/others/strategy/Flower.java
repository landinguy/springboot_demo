package com.example.demo.others.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by xxf on 2018/12/26 0026.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flower {
    private Color color;
    private ColorInterface colorInterface;

    public String getMsg() {
        return colorInterface.getMsg();
    }
}
