package com.example.demo.others.chain_of_responsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author landing guy
 * @date 2019/8/25
 * <p>
 * 采购单：请求类
 */
@Data
@AllArgsConstructor
public class PurchaseRequest {
    private double amount;
    private int number;
    private String purpose;
}
