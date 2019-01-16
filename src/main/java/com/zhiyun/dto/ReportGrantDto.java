package com.zhiyun.dto;

import com.zhiyun.entity.ReportGrant;

public class ReportGrantDto extends ReportGrant {

    private static final long serialVersionUID = 2513749260302477971L;

    private String orgName;

    private String empName;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}