package com.zhiyun.dto;

import com.zhiyun.entity.Linkage;
import com.zhiyun.entity.Report;

import java.util.List;

public class ReportDto extends Report {

    private static final long serialVersionUID = 6678678757706499051L;

    private Long layoutId;
    // 布局配置
    private String layoutConfig;
    // 报表设计
    private String config;
    // 解压路径
    private String unzipPath;

    private String pic;
    // 是否可编辑
    private Boolean desisn;
    // 编辑授权
    private Long isDesisn;

    private Boolean giveDes;

    public Boolean getGiveDes() {
        return giveDes;
    }

    public void setGiveDes(Boolean giveDes) {
        this.giveDes = giveDes;
    }

    public Boolean getDesisn() {
        return desisn;
    }

    public void setDesisn(Boolean desisn) {
        this.desisn = desisn;
    }

    public Long getIsDesisn() {
        return isDesisn;
    }

    public void setIsDesisn(Long isDesisn) {
        this.isDesisn = isDesisn;
    }

    private List<DatasourceLocationValueDto> datasourceLocationValueDtos;

    private List<Linkage> linkages;

    public List<Linkage> getLinkages() {
        return linkages;
    }

    public void setLinkages(List<Linkage> linkages) {
        this.linkages = linkages;
    }

    public List<DatasourceLocationValueDto> getDatasourceLocationValueDtos() {
        return datasourceLocationValueDtos;
    }

    public void setDatasourceLocationValueDtos(List<DatasourceLocationValueDto> datasourceLocationValueDtos) {
        this.datasourceLocationValueDtos = datasourceLocationValueDtos;
    }

    public String getUnzipPath() {
        return unzipPath;
    }

    public void setUnzipPath(String unzipPath) {
        this.unzipPath = unzipPath;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLayoutConfig() {
        return layoutConfig;
    }

    public void setLayoutConfig(String layoutConfig) {
        this.layoutConfig = layoutConfig;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Long getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(Long layoutId) {
        this.layoutId = layoutId;
    }
}