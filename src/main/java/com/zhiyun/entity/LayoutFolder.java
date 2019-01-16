/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 布局文件夹实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class LayoutFolder extends BaseEntity<Long> {

	private static final long serialVersionUID = 5479558995946530753L;

	// ~~~~实体属性
	// 文件夹名称
	@Pattern(regexp="[\\S]{0,50}", message="文件夹名称字段过长")
	private String alias;
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
	 * 文件夹名称
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * 文件夹名称
	 */
	public void setAlias(String alias) {
		this.alias = alias;
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
