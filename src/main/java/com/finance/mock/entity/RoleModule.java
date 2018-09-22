package com.finance.mock.entity;

/**
 * @Author: 快乐水 樱桃可乐
 * @Description:
 * @Date: Created in 20:30 2018/9/21
 * @Modified By:
 */
public class RoleModule {
    private long id;
    private long roleId;
    private long moduleId;
    private long createAt;
    private long updateAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
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
        return "RoleModule{" + "id=" + id + ", roleId=" + roleId + ", moduleId=" + moduleId + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }
}
