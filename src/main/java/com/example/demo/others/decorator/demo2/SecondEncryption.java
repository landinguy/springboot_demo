package com.example.demo.others.decorator.demo2;

/**
 * @author landing guy
 * @date 2019/8/18
 */
public class SecondEncryption extends AbstractDecorator {
    public SecondEncryption(Encryption encryption) {
        super(encryption);
    }

    @Override
    public void encrypt() {
        encode();
        super.encrypt();
    }

    public void encode() {
        System.out.println("第二次加密");
    }

}
