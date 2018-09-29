package com.finance.mock.entity;

import java.math.BigDecimal;

/**
 * @Author: huangdongjiang
 * @Description: 快乐水 原味可乐
 * @Date: Created in 2018/9/21 22:24
 * @Modified By:
 */
public class Compacting {
	//合同id
	private long id;
	//合同序列id
	private String serialId;
	//用户id
	private long userId;
	//产品id
	private long productId;
	//合同失效时间
	private long expiredTime;
	//合同状态0表示首次 1表示续投
	private int status;
	private BigDecimal amount;
	private BigDecimal profit;
	private int financialTime;
	private long createdAt;
	private long updatedAt;

	@Override
	public String toString() {
		return "Compacting{" +
				"id=" + id +
				", serialId='" + serialId + '\'' +
				", userId=" + userId +
				", productId=" + productId +
				", expiredTime=" + expiredTime +
				", status=" + status +
				", amount=" + amount +
				", profit=" + profit +
				", financialTime=" + financialTime +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				'}'+"\n";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(long expiredTime) {
		this.expiredTime = expiredTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public int getFinancialTime() {
		return financialTime;
	}

	public void setFinancialTime(int financialTime) {
		this.financialTime = financialTime;
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
}
