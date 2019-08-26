package com.example.demo.others.decorator.demo2;

/**
 * @author landing guy
 * @date 2019/8/18
 */
public class ThirdEncryption extends AbstractDecorator {
    public ThirdEncryption(Encryption encryption) {
        super(encryption);
    }

    @Override
    public void encrypt() {
        encode();
        super.encrypt();
    }

    public void encode() {
        System.out.println("第三次加密");
    }

}
