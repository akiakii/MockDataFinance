package com.finance.mock.entity;

import java.util.List;

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
    private long fatherModuleId;
    private String moduleType;
    private String createdBy;
    private String updatedBy;
    private long createAt;
    private long updateAt;
    private List<Module> modules;

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

    public long getFatherModuleId() {
        return fatherModuleId;
    }

    public void setFatherModuleId(long fatherModuleId) {
        this.fatherModuleId = fatherModuleId;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
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

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "Module{" + "id=" + id + ", serialId='" + serialId + '\'' + ", moduleName='" + moduleName + '\'' + ", moduleUrl='" + moduleUrl + '\'' + ", fatherModuleId=" + fatherModuleId + ", moduleType='" + moduleType + '\'' + ", createdBy='" + createdBy + '\'' + ", updatedBy='" + updatedBy + '\'' + ", createAt=" + createAt + ", updateAt=" + updateAt + ", modules=" + modules + '}';
    }
}
