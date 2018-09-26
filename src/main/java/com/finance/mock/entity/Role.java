package com.finance.mock.entity;

/**
 * @Author: 快乐水 樱桃可乐
 * @Description:
 * @Date: Created in 20:29 2018/9/21
 * @Modified By:
 */
public class Role {
    private long id;
    private String serialId;
    private String roleName;
    private String updatedBy;
    private String createdBy;
    private long createdAt;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
        return "Role{" + "id=" + id + ", serialId='" + serialId + '\'' + ", roleName='" + roleName + '\'' + ", updatedBy='" + updatedBy + '\'' + ", createdBy='" + createdBy + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}
