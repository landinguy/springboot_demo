package com.example.demo.others.composite;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author landing guy
 * @date 2019/8/17
 */
@Data
public class Folder implements File {
    private String name;
    private List<File> list = new ArrayList<>();

    Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(File file) {
        list.add(file);
    }

    @Override
    public void remove(File file) {
        list.remove(file);
    }

    @Override
    public File getChild(int i) {
        return list.get(i);
    }

    @Override
    public void killVirus() {
        System.out.println("对文件夹进行杀毒，folder name#" + name);
        for (File file : list) {
            file.killVirus();
        }
    }
}
