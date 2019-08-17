package com.example.demo.others.composite;

/**
 * @author landing guy
 * @date 2019/8/17
 * <p>
 * 组合模式
 */
public class Test {
    public static void main(String[] args) {
        File f1, f2, f3, f4, f5, f6, f7, f8;

        f1 = new Folder("landing guy的资料");
        f2 = new Folder("文本库");
        f3 = new Folder("图片库");
        f4 = new Folder("视频库");

        f5 = new ImageFile("大海.jpg");
        f6 = new ImageFile("张家界.png");
        f7 = new TxtFile("程序员的自我修养.pdf");
        f8 = new VideoFile("亲爱的，热爱的第1集.mp4");

        f2.add(f7);
        f3.add(f5);
        f3.add(f6);
        f4.add(f8);
        f1.add(f2);
        f1.add(f3);
        f1.add(f4);

        f1.killVirus();
    }
}
