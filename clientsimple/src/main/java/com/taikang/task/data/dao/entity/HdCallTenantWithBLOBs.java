package com.taikang.task.data.dao.entity;

public class HdCallTenantWithBLOBs extends HdCallTenant {
    private String reqParam;

    private String retContent;

    public String getReqParam() {
        return reqParam;
    }

    public void setReqParam(String reqParam) {
        this.reqParam = reqParam;
    }

    public String getRetContent() {
        return retContent;
    }

    public void setRetContent(String retContent) {
        this.retContent = retContent;
    }
}