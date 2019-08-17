package com.example.demo.others.composite;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author landing guy
 * @date 2019/8/17
 */
@Data
@AllArgsConstructor
public class ImageFile implements File {

    private String name;

    @Override
    public void killVirus() {
        System.out.println("对图像文件进行杀毒，filename#" + name);
    }
}
