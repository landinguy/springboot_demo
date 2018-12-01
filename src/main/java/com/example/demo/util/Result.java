package com.example.demo.util;

import lombok.Builder;
import lombok.Data;

/**
 * Created by xxf on 2018/12/1 0001.
 */
@Data
@Builder
public class Result {
    private int code = 0;
    private String msg;
    private Object data;
}
