/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 本地数据域字段实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class DatasourceLocationField extends BaseEntity<Long> {

	private static final long serialVersionUID = 1306764305882665153L;

	// ~~~~实体属性
	// 看板主键
	@Max(value=9223372036854775807L,message="看板主键字段过长")
	private Long boardId;
	// 报表主键
	@Max(value=9223372036854775807L,message="报表主键字段过长")
	private Long reportId;
	// 字段标识
	@Pattern(regexp="[\\S]{0,50}", message="字段标识字段过长")
	private String fieldCode;
	// 字段中文名
	@Pattern(regexp="[\\S]{0,50}", message="字段中文名字段过长")
	private String fieldLabel;
	// 字段数据类型
	@Pattern(regexp="[\\S]{0,20}", message="字段数据类型字段过长")
	private String fieldDatatype;
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
	 * 字段标识
	 */
	public String getFieldCode() {
		return this.fieldCode;
	}

	/**
	 * 字段标识
	 */
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}
	
	/**
	 * 字段中文名
	 */
	public String getFieldLabel() {
		return this.fieldLabel;
	}

	/**
	 * 字段中文名
	 */
	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}
	
	/**
	 * 字段数据类型
	 */
	public String getFieldDatatype() {
		return this.fieldDatatype;
	}

	/**
	 * 字段数据类型
	 */
	public void setFieldDatatype(String fieldDatatype) {
		this.fieldDatatype = fieldDatatype;
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
