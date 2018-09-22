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
    private String updateName;
    private long createAt;
    private long updateAt;

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

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
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
        return "Role{" + "id=" + id + ", serialId='" + serialId + '\'' + ", roleName='" + roleName + '\'' + ", updateName='" + updateName + '\'' + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }
}
