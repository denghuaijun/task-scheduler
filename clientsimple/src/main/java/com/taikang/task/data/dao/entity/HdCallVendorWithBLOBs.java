package com.taikang.task.data.dao.entity;

public class HdCallVendorWithBLOBs extends HdCallVendor {
    private String reqParam;

    private String healthData;

    private String retContent;

    public String getReqParam() {
        return reqParam;
    }

    public void setReqParam(String reqParam) {
        this.reqParam = reqParam;
    }

    public String getHealthData() {
        return healthData;
    }

    public void setHealthData(String healthData) {
        this.healthData = healthData;
    }

    public String getRetContent() {
        return retContent;
    }

    public void setRetContent(String retContent) {
        this.retContent = retContent;
    }
}