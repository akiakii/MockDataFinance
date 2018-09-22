package com.finance.mock.entity;

import java.math.BigDecimal;

/**
 * @Author: 快乐水 樱桃可乐
 * @Description:
 * @Date: Created in 15:13 2018/9/21
 * @Modified By:
 */
public class Deal {
    private long id;
    private long userID;
    private long compactId;
    private BigDecimal investment;
    private BigDecimal profit;
    private String dealingType;
    private long createdAt;
    private long updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getCompactId() {
        return compactId;
    }

    public void setCompactId(long compactId) {
        this.compactId = compactId;
    }

    public BigDecimal getInvestment() {
        return investment;
    }

    public void setInvestment(BigDecimal investment) {
        this.investment = investment;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public String getDealingType() {
        return dealingType;
    }

    public void setDealingType(String dealingType) {
        this.dealingType = dealingType;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Deal{" + "id=" + id + ", userID=" + userID + ", compactId=" + compactId + ", investment=" + investment + ", profit=" + profit + ", dealingType='" + dealingType + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}
