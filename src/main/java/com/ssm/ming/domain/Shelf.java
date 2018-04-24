package com.ssm.ming.domain;

import java.sql.Date;

/**
 * @author Wenming.Huang
 * @date 2018-04-24
 * @version 1.0
 */
public class Shelf {
    private Integer id;
    private Integer warehouseId;
    private Integer materialBaseId;
    private String name;
    private String code;
    private Integer capacity;
    private String description;
    private Boolean isEnable;
    private Boolean isDelete;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getMaterialBaseId() {
        return materialBaseId;
    }

    public void setMaterialBaseId(Integer materialBaseId) {
        this.materialBaseId = materialBaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "Shelf [id=" + id + ", warehouseId=" + warehouseId + ", materialBaseId=" + materialBaseId + ", name="
                + name + ", code=" + code + ", capacity=" + capacity + ", description=" + description + ", isEnable="
                + isEnable + ", isDelete=" + isDelete + ", createTime=" + createTime + ", createUser=" + createUser
                + ", updateTime=" + updateTime + ", updateUser=" + updateUser + "]";
    }

}
