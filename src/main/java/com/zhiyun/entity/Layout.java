/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 布局信息实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class Layout extends BaseEntity<Long> {

	private static final long serialVersionUID = 3471808018087210648L;

	// ~~~~实体属性
	// 文件夹主键
	@Max(value=9223372036854775807L,message="文件夹主键字段过长")
	private Long folderId;
	// 布局名称
	@Pattern(regexp="[\\S]{0,50}", message="布局名称字段过长")
	private String alias;
	// 布局配置
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
	 * 文件夹主键
	 */
	public Long getFolderId() {
		return this.folderId;
	}

	/**
	 * 文件夹主键
	 */
	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}
	
	/**
	 * 布局名称
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * 布局名称
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	/**
	 * 布局配置
	 */
	public String getConfig() {
		return this.config;
	}

	/**
	 * 布局配置
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
