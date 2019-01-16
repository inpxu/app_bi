/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 报表设计实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class ReportConfig extends BaseEntity<Long> {

	private static final long serialVersionUID = 7299942439331595822L;

	// ~~~~实体属性
	// 报表主键
	@Max(value=9223372036854775807L,message="报表主键字段过长")
	private Long reportId;
	// 布局主键
	@Max(value=9223372036854775807L,message="布局主键字段过长")
	private Long layoutId;
	// 布局配置
	private String layoutConfig;
	// 报表设计
	private String config;
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
	 * 报表主键
	 */
	public Long getReportId() {
		return this.reportId;
	}

	/**
	 * 报表主键
	 */
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	
	/**
	 * 布局主键
	 */
	public Long getLayoutId() {
		return this.layoutId;
	}

	/**
	 * 布局主键
	 */
	public void setLayoutId(Long layoutId) {
		this.layoutId = layoutId;
	}
	
	/**
	 * 布局配置
	 */
	public String getLayoutConfig() {
		return this.layoutConfig;
	}

	/**
	 * 布局配置
	 */
	public void setLayoutConfig(String layoutConfig) {
		this.layoutConfig = layoutConfig;
	}
	
	/**
	 * 报表设计
	 */
	public String getConfig() {
		return this.config;
	}

	/**
	 * 报表设计
	 */
	public void setConfig(String config) {
		this.config = config;
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
