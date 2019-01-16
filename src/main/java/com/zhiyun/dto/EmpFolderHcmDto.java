package com.zhiyun.dto;

import com.zhiyun.entity.EmpFolderHcm;

public class EmpFolderHcmDto extends EmpFolderHcm {

    private static final long serialVersionUID = 7639711796996682722L;

    private String orgName;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}