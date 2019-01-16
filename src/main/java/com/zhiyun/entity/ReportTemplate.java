/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 专业模板库实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class ReportTemplate extends BaseEntity<Long> {

	private static final long serialVersionUID = 6114557105625722462L;

	// ~~~~实体属性
	// 模板名
	@Pattern(regexp="[\\S]{0,20}", message="模板名字段过长")
	private String alias;
	// 模板路径
	@Pattern(regexp="[\\S]{0,200}", message="模板路径字段过长")
	private String templatePath;

	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	/**
	 * 模板名
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * 模板名
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	/**
	 * 模板路径
	 */
	public String getTemplatePath() {
		return this.templatePath;
	}

	/**
	 * 模板路径
	 */
	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}
}
