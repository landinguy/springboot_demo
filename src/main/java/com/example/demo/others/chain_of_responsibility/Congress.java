package com.example.demo.others.chain_of_responsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * @author landing guy
 * @date 2019/8/25
 * <p>
 * 董事会类：具体处理者
 */
@Slf4j
public class Congress extends Approver {

    public Congress(String name) {
        super(name);
    }

    @Override
    public void process(PurchaseRequest request) {
        log.info("召开董事会审批采购单#{}", request);
    }
}
