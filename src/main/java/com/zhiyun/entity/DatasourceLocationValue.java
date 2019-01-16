/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 本地数据域实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class DatasourceLocationValue extends BaseEntity<Long> {

	private static final long serialVersionUID = 2715440999691597021L;

	// ~~~~实体属性
	// 看板主键
	@Max(value=9223372036854775807L,message="看板主键字段过长")
	private Long boardId;
	// 报表主键
	@Pattern(regexp="[\\S]{0,20}", message="报表主键字段过长")
	private String reportId;
	// 数据源类型
	@Pattern(regexp="[\\S]{0,20}", message="数据源类型字段过长")
	private String type;
	// 数据集名称
	@Pattern(regexp="[\\S]{0,20}", message="数据集名称字段过长")
	private String value;
	// 仓库id
	@Max(value=9223372036854775807L,message="仓库id字段过长")
	private Long wareHouseId;
	// 模型id
	@Max(value=9223372036854775807L,message="模型id字段过长")
	private Long modelId;
	// 模型编码
	@Pattern(regexp="[\\S]{0,50}", message="模型编码字段过长")
	private String dataModelCode;
	// 版本号
	@Max(value=99999999999L,message="版本号字段过长")
	private Integer version;
	// 数值
	@Pattern(regexp="[\\S]{0,1000}", message="数值字段过长")
	private String figure;
	// 维度
	@Pattern(regexp="[\\S]{0,1000}", message="维度字段过长")
	private String veidoo;
	// 数据列
	@Pattern(regexp="[\\S]{0,1000}", message="数据列字段过长")
	private String findDate;
	// 过滤规则list
	@Pattern(regexp="[\\S]{0,1000}", message="过滤规则list字段过长")
	private String findCondList;
	// 过滤规则
	private String findCondJson;
	// 图表配置信息
	private String picConfig;
	// 远端数据域
	private String longDomain;
	// 数据域
	private String domain;
	// 
	@Max(value=9223372036854775807L,message="字段过长")
	private Long companyId;

	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	/**
	 * 看板主键
	 */
	public Long getBoardId() {
		return this.boardId;
	}

	/**
	 * 看板主键
	 */
	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}
	
	/**
	 * 报表主键
	 */
	public String getReportId() {
		return this.reportId;
	}

	/**
	 * 报表主键
	 */
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	
	/**
	 * 数据源类型
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * 数据源类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 数据集名称
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * 数据集名称
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * 仓库id
	 */
	public Long getWareHouseId() {
		return this.wareHouseId;
	}

	/**
	 * 仓库id
	 */
	public void setWareHouseId(Long wareHouseId) {
		this.wareHouseId = wareHouseId;
	}
	
	/**
	 * 模型id
	 */
	public Long getModelId() {
		return this.modelId;
	}

	/**
	 * 模型id
	 */
	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}
	
	/**
	 * 模型编码
	 */
	public String getDataModelCode() {
		return this.dataModelCode;
	}

	/**
	 * 模型编码
	 */
	public void setDataModelCode(String dataModelCode) {
		this.dataModelCode = dataModelCode;
	}
	
	/**
	 * 版本号
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * 版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	/**
	 * 数值
	 */
	public String getFigure() {
		return this.figure;
	}

	/**
	 * 数值
	 */
	public void setFigure(String figure) {
		this.figure = figure;
	}
	
	/**
	 * 维度
	 */
	public String getVeidoo() {
		return this.veidoo;
	}

	/**
	 * 维度
	 */
	public void setVeidoo(String veidoo) {
		this.veidoo = veidoo;
	}
	
	/**
	 * 数据列
	 */
	public String getFindDate() {
		return this.findDate;
	}

	/**
	 * 数据列
	 */
	public void setFindDate(String findDate) {
		this.findDate = findDate;
	}
	
	/**
	 * 过滤规则list
	 */
	public String getFindCondList() {
		return this.findCondList;
	}

	/**
	 * 过滤规则list
	 */
	public void setFindCondList(String findCondList) {
		this.findCondList = findCondList;
	}
	
	/**
	 * 过滤规则
	 */
	public String getFindCondJson() {
		return this.findCondJson;
	}

	/**
	 * 过滤规则
	 */
	public void setFindCondJson(String findCondJson) {
		this.findCondJson = findCondJson;
	}
	
	/**
	 * 图表配置信息
	 */
	public String getPicConfig() {
		return this.picConfig;
	}

	/**
	 * 图表配置信息
	 */
	public void setPicConfig(String picConfig) {
		this.picConfig = picConfig;
	}
	
	/**
	 * 远端数据域
	 */
	public String getLongDomain() {
		return this.longDomain;
	}

	/**
	 * 远端数据域
	 */
	public void setLongDomain(String longDomain) {
		this.longDomain = longDomain;
	}
	
	/**
	 * 数据域
	 */
	public String getDomain() {
		return this.domain;
	}

	/**
	 * 数据域
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	/**
	 * 
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
