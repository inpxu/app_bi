/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 报表文件夹实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class ReportFolder extends BaseEntity<Long> {

	private static final long serialVersionUID = 3745361115848585291L;

	// ~~~~实体属性
	// 创建人id
	@Max(value=9223372036854775807L,message="创建人id字段过长")
	private Long createUserId;
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
	 * 创建人id
	 */
	public Long getCreateUserId() {
		return this.createUserId;
	}

	/**
	 * 创建人id
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
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
