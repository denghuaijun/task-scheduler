package com.taikang.task.data.dao.entity;

import java.util.Date;

public class HdVendorService {
    private Long id;

    private String vendorId;

    private String serviceCode;

    private String authorizeMsg;

    private String serviceUrl;

    private Integer interval;

    private Long serviceTypeId;

    private String serviceDesc;

    private Integer serviceStatus;

    private Integer level;

    private String serviceLink;

    private String servicePhone;

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

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getAuthorizeMsg() {
        return authorizeMsg;
    }

    public void setAuthorizeMsg(String authorizeMsg) {
        this.authorizeMsg = authorizeMsg;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public Integer getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(Integer serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getServiceLink() {
        return serviceLink;
    }

    public void setServiceLink(String serviceLink) {
        this.serviceLink = serviceLink;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
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