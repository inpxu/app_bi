package com.zhiyun.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.zhiyun.entity.DatasourceLocationValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DatasourceLocationValueDto extends DatasourceLocationValue {

    private static final long serialVersionUID = 6312054131489237688L;

    // key
    private List<Object> keyls;

    private List<Object> maps;
    // 维度详情
    private List<Object> veidooValue;
    // 数值详情
    private List<Object> figureValue;

    // 请求时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date nowTime;
    // 是否是表格
    private Boolean Form;

    private String values;

    private List<Object> valueParam;

    private List<String> findList;

    private List<String> findCond;

    public List<String> getFindList() {
        return findList;
    }

    public void setFindList(List<String> findList) {
        this.findList = findList;
    }

    public List<String> getFindCond() {
        return findCond;
    }

    public void setFindCond(List<String> findCond) {
        this.findCond = findCond;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public List<Object> getValueParam() {
        return valueParam;
    }

    public void setValueParam(List<Object> valueParam) {
        this.valueParam = valueParam;
    }

    public Boolean getForm() {
        return Form;
    }

    public void setForm(Boolean form) {
        Form = form;
    }

    public Date getNowTime() {
        return nowTime;
    }

    public void setNowTime(Date nowTime) {
        this.nowTime = nowTime;
    }

    public List<Object> getVeidooValue() {
        return veidooValue;
    }

    public void setVeidooValue(List<Object> veidooValue) {
        this.veidooValue = veidooValue;
    }

    public List<Object> getFigureValue() {
        return figureValue;
    }

    public void setFigureValue(List<Object> figureValue) {
        this.figureValue = figureValue;
    }

    public List<Object> getMaps() {
        return maps;
    }

    public void setMaps(List<Object> maps) {
        this.maps = maps;
    }

    public List<Object> getKeyls() {
        return keyls;
    }

    public void setKeyls(List<Object> keyls) {
        this.keyls = keyls;
    }
}