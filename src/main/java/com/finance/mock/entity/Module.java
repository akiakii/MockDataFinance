package com.finance.mock.entity;

/**
 * @Author: 快乐水 樱桃可乐
 * @Description:
 * @Date: Created in 20:28 2018/9/21
 * @Modified By:
 */
public class Module {
    private long id;
    private String serialId;
    private String moduleName;
    private String moduleUrl;
    private String fatherModule;
    private String moduleType;
    private long createId;
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

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public String getFatherModule() {
        return fatherModule;
    }

    public void setFatherModule(String fatherModule) {
        this.fatherModule = fatherModule;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public long getCreateId() {
        return createId;
    }

    public void setCreateId(long createId) {
        this.createId = createId;
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
        return "Module{" + "id=" + id + ", serialId='" + serialId + '\'' + ", moduleName='" + moduleName + '\'' + ", moduleUrl='" + moduleUrl + '\'' + ", fatherModule='" + fatherModule + '\'' + ", moduleType='" + moduleType + '\'' + ", createId=" + createId + ", updateName='" + updateName + '\'' + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }
}
