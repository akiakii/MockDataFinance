package com.finance.mock.entity;

import java.math.BigDecimal;

/**
 * @Author: 快乐水 樱桃可乐
 * @Description:
 * @Date: Created in 14:25 2018/9/21
 * @Modified By:
 */
public class Product {
    private long id;
    private String serialId;
    private String productName;
    private short proProfit;
    private short investmentCycle;
    private BigDecimal minAmount;
    private BigDecimal minIncrement;
    private BigDecimal maxAmount;
    private String repaymentWay;
    private String creator;
    private boolean status;
    private String productIntro;
    private String moreInformation;
    private String slogan;
    private String advantage;
    private long createdAt;
    private long updatedAt;
}
