package com.example.demo.others.composite;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author landing guy
 * @date 2019/8/17
 */
@Data
@AllArgsConstructor
public class VideoFile implements File {

    private String name;

    @Override
    public void killVirus() {
        System.out.println("对视频文件进行杀毒，filename#" + name);
    }
}
