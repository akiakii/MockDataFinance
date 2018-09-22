package com.finance.mock.entity;

/**
 * @Author: 快乐水 青柠可乐
 * @Description:
 * @Date: Created in 下午9:36 2018/9/21
 * @Modified By:
 */
public class Idea {
    private long id;
    private long userId;
    private String content;
    private boolean status;
    private long createdAt;
    private long updatedAt;

    @Override
    public String toString() {
        return "Idea{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", status=" + status +
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
