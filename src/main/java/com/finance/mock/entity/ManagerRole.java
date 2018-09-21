package com.finance.mock.entity;

/**
 * @Author: huangdongjiang
 * @Description: 快乐水 原味可乐
 * @Date: Created in 2018/9/21 22:17
 * @Modified By:
 */
public class ManagerRole {
	//管理者-角色映射id
	private long id;
	//用户id
	private long userId;
	//角色id
	private long roleId;
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
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
