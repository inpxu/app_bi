/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 看板信息实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class Report extends BaseEntity<Long> {

	private static final long serialVersionUID = 2165796292233654524L;

	// ~~~~实体属性
	// 文件夹主键
	@Max(value=9223372036854775807L,message="文件夹主键字段过长")
	private Long folderId;
	// 创建人
	@Max(value=9223372036854775807L,message="创建人字段过长")
	private Long createUserId;
	// 报表类型
	@Pattern(regexp="[\\S]{0,50}", message="报表类型字段过长")
	private String reportType;
	// 报表名称
	@Pattern(regexp="[\\S]{0,50}", message="报表名称字段过长")
	private String alias;
	// 模板主键
	@Max(value=9223372036854775807L,message="模板主键字段过长")
	private Long templateId;
	// 模板路径
	@Pattern(regexp="[\\S]{0,200}", message="模板路径字段过长")
	private String templateUrl;
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
	 * 创建人
	 */
	public Long getCreateUserId() {
		return this.createUserId;
	}

	/**
	 * 创建人
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	
	/**
	 * 报表类型
	 */
	public String getReportType() {
		return this.reportType;
	}

	/**
	 * 报表类型
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
	/**
	 * 报表名称
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * 报表名称
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	/**
	 * 模板主键
	 */
	public Long getTemplateId() {
		return this.templateId;
	}

	/**
	 * 模板主键
	 */
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
	
	/**
	 * 模板路径
	 */
	public String getTemplateUrl() {
		return this.templateUrl;
	}

	/**
	 * 模板路径
	 */
	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
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
