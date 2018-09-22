package com.finance.mock.entity;


/**
 * @Author: 快乐水 樱桃可乐
 * @Description:
 * @Date: Created in 10:03 2018/9/21
 * @Modified By:
 */
public class Bank {
    private long id;
    private long userId;
    private String card;
    private String type;
    private long createAt;
    private long updateAt;

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

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Bank{" + "id=" + id + ", userId=" + userId + ", card='" + card + '\'' + ", type='" + type + '\'' + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }
}
