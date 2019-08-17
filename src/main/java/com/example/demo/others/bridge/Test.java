package com.example.demo.others.bridge;

/**
 * @author landing guy
 * @date 2019/8/17
 * <p>
 * 桥接模式
 */
public class Test {
    public static void main(String[] args) {
        DataCenter dataCenter;
        AbstractConverter converter;

//        dataCenter = new MysqlDataCenter();
        dataCenter = new OracleDataCenter();
//        converter = new TxtConverter();
        converter = new PdfConverter();

        converter.setDataCenter(dataCenter);
        converter.convert();

    }
}
