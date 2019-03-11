package com.taikang.task.data.dao.entity;

import java.util.Date;

public class HdVendor {
    private Long id;

    private String vendorCode;

    private String vendorName;

    private String vendorPerson;

    private String vendorPhone;

    private Integer vendorStatus;

    private String creatorCode;

    private Date createdTime;

    private String modifyCode;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorPerson() {
        return vendorPerson;
    }

    public void setVendorPerson(String vendorPerson) {
        this.vendorPerson = vendorPerson;
    }

    public String getVendorPhone() {
        return vendorPhone;
    }

    public void setVendorPhone(String vendorPhone) {
        this.vendorPhone = vendorPhone;
    }

    public Integer getVendorStatus() {
        return vendorStatus;
    }

    public void setVendorStatus(Integer vendorStatus) {
        this.vendorStatus = vendorStatus;
    }

    public String getCreatorCode() {
        return creatorCode;
    }

    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifyCode() {
        return modifyCode;
    }

    public void setModifyCode(String modifyCode) {
        this.modifyCode = modifyCode;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}