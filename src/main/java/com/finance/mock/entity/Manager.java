package com.finance.mock.entity;

/**
 * @Author: huangdongjiang
 * @Description: 快乐水 原味可乐
 * @Date: Created in 2018/9/21 21:47
 * @Modified By:
 */
public class Manager {
	//管理者id
	private long id;
	//管理者昵称
	private String nickName;
	//管理者电话号码
	private String phoneNumber;
	//管理者状态，1为冻结，0为正常状态
	private int isLocked;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(int isLocked) {
		this.isLocked = isLocked;
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
}
