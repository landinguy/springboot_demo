package com.example.demo.others.chain_of_responsibility;

/**
 * @author landing guy
 * @date 2019/8/25
 * <p>
 * 职责链模式
 */
public class Test {
    public static void main(String[] args) {
        Approver a1, a2, a3, a4;

        a1 = new Director("Jack");
        a2 = new VicePresident("Lucy");
        a3 = new President("landing guy");
        a4 = new Congress("董事会");

        //创建职责链
        a1.setApprover(a2);
        a2.setApprover(a3);
        a3.setApprover(a4);

        //创建采购单
        PurchaseRequest pr1 = new PurchaseRequest(45000, 10001, "购买倚天剑");
        a1.process(pr1);
        PurchaseRequest pr2 = new PurchaseRequest(60000, 10002, "购买《葵花宝典》");
        a1.process(pr2);
        PurchaseRequest pr3 = new PurchaseRequest(160000, 10003, "购买《金刚经》");
        a1.process(pr3);
        PurchaseRequest pr4 = new PurchaseRequest(800000, 10004, "购买桃花岛");
        a1.process(pr4);

    }
}
