package com.zhiyun.dto;

import com.zhiyun.entity.Report;
import com.zhiyun.entity.ReportFolder;

import java.util.List;

public class ReportFolderDto extends ReportFolder {

    private static final long serialVersionUID = 7678221495879399991L;

    private List<ReportDto> reports;

    private Boolean desisn;

    private Long isDesisn;

    public Long getIsDesisn() {
        return isDesisn;
    }

    public void setIsDesisn(Long isDesisn) {
        this.isDesisn = isDesisn;
    }

    public Boolean getDesisn() {
        return desisn;
    }

    public void setDesisn(Boolean desisn) {
        this.desisn = desisn;
    }

    public List<ReportDto> getReports() {
        return reports;
    }

    public void setReports(List<ReportDto> reports) {
        this.reports = reports;
    }
}