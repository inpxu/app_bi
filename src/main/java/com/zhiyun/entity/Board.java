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
public class Board extends BaseEntity<Long> {

	private static final long serialVersionUID = 3910727611072272468L;

	// ~~~~实体属性
	// 报表主键
	@Max(value=9223372036854775807L,message="报表主键字段过长")
	private Long reportId;
	// 布局编号
	@Pattern(regexp="[\\S]{0,10}", message="布局编号字段过长")
	private String layoutNo;
	// 看板设计
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
	 * 布局编号
	 */
	public String getLayoutNo() {
		return this.layoutNo;
	}

	/**
	 * 布局编号
	 */
	public void setLayoutNo(String layoutNo) {
		this.layoutNo = layoutNo;
	}
	
	/**
	 * 看板设计
	 */
	public String getConfig() {
		return this.config;
	}

	/**
	 * 看板设计
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
