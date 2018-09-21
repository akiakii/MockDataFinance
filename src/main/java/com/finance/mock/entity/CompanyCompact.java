package com.finance.mock.entity;

/**
 * @Author: huangdongjiang
 * @Description: 快乐水 原味可乐
 * @Date: Created in 2018/9/21 22:38
 * @Modified By:
 */
public class CompanyCompact {
	//债务人id
	private long id;
	//债务人序列id
	private String serialId;
	//合同id
	private long compactId;
	//创建时间
	private long createdAt;
	//更新时间
	private long updatedAt;

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

	public long getCompactId() {
		return compactId;
	}

	public void setCompactId(long compactId) {
		this.compactId = compactId;
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
