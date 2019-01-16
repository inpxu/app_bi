package com.zhiyun.dto;

import com.zhiyun.base.entity.BaseEntity;

import java.util.List;

public class FindSQL extends BaseEntity<Long> {

    private List<String> findList;

    private List<String> findCond;

    private List<String> findCondList;

    private String dataModelCode;

    private Integer version;

    // 过滤规则
    private List<String> findCondJson;

    public List<String> getFindCondList() {
        return findCondList;
    }

    public void setFindCondList(List<String> findCondList) {
        this.findCondList = findCondList;
    }

    public List<String> getFindCondJson() {
        return findCondJson;
    }

    public void setFindCondJson(List<String> findCondJson) {
        this.findCondJson = findCondJson;
    }

    public String getDataModelCode() {
        return dataModelCode;
    }

    public void setDataModelCode(String dataModelCode) {
        this.dataModelCode = dataModelCode;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<String> getFindCond() {
        return findCond;
    }

    public void setFindCond(List<String> findCond) {
        this.findCond = findCond;
    }

    public List<String> getFindList() {
        return findList;
    }

    public void setFindList(List<String> findList) {
        this.findList = findList;
    }
}