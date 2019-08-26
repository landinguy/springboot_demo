package com.example.demo.others.chain_of_responsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * @author landing guy
 * @date 2019/8/25
 * <p>
 * 主任类：具体处理者
 */
@Slf4j
public class Director extends Approver {

    public Director(String name) {
        super(name);
    }

    @Override
    public void process(PurchaseRequest request) {
        if (request.getAmount() < 50000) {
            log.info("主任#{}审批采购单#{}", this.name, request);
        } else {
            this.approver.process(request);
        }
    }
}
