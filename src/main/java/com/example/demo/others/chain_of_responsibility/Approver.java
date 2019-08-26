package com.example.demo.others.chain_of_responsibility;

/**
 * @author landing guy
 * @date 2019/8/25
 * <p>
 * 审批者类：抽象处理者
 */
public abstract class Approver {
    protected Approver approver;
    protected String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void process(PurchaseRequest request);
}
