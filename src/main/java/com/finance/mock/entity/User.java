package com.finance.mock.entity;

public class User {
    /**
     * id 自增id
     */
    private long id;
    /**
     * name 用户名字
     */
    private String name;

    /**
     * password 用户密码
     */
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
