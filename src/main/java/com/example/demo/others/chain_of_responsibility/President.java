package com.example.demo.others.chain_of_responsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * @author landing guy
 * @date 2019/8/25
 * <p>
 * 董事长类：具体处理者
 */
@Slf4j
public class President extends Approver {

    public President(String name) {
        super(name);
    }

    @Override
    public void process(PurchaseRequest request) {
        if (request.getAmount() < 500000) {
            log.info("董事长#{}审批采购单#{}", this.name, request);
        } else {
            this.approver.process(request);
        }
    }
}
