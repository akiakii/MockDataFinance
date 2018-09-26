package com.finance.mock.entity;

import java.util.List;

/**
 * @Author: huangdongjiang
 * @Description: 快乐水 原味可乐
 * @Date: Created in 2018/9/21 21:47
 * @Modified By:
 */
public class Manager {
	//管理者id
	private long id;
	//管理者状态
	private boolean Locked;
	//管理者账号
	private String account;
	//管理者密码
	private String password;
	//加密盐
	private String salt;
	//创建时间
	private long createAt;
	//更新时间
	private long updateAt;
	//序列ID
	private String serialId;
	//创建人姓名
	private String createdBy;
	//更新人姓名
	private String updatedBy;
	//创建时间
	private long createdAt;
	//更新时间
	private long updatedAt;
	//角色列表
	private List<Role> roles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isLocked() {
		return Locked;
	}

	public void setLocked(boolean locked) {
		Locked = locked;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public long getCreateAt() {
		return createAt;
	}

	public void setCreateAt(long createAt) {
		this.createAt = createAt;
	}

	public long getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(long updateAt) {
		this.updateAt = updateAt;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Manager{" + "id=" + id + ", Locked=" + Locked + ", account='" + account + '\'' + ", password='" + password + '\'' + ", salt='" + salt + '\'' + ", createAt=" + createAt + ", updateAt=" + updateAt + ", serialId='" + serialId + '\'' + ", createdBy='" + createdBy + '\'' + ", updatedBy='" + updatedBy + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", roles=" + roles + '}';
	}
}
