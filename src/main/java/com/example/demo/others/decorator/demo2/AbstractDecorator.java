package com.example.demo.others.decorator.demo2;

/**
 * @author landing guy
 * @date 2019/8/18
 */
public class AbstractDecorator extends Encryption {
    private Encryption encryption;

    public AbstractDecorator(Encryption encryption) {
        this.encryption = encryption;
    }

    @Override
    public void encrypt() {
        encryption.encrypt();
    }
}
