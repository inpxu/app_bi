/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 报表授权实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class ReportGrant extends BaseEntity<Long> {

	private static final long serialVersionUID = 7755427158215140816L;

	// ~~~~实体属性
	// 文件夹主键
	@Max(value=9223372036854775807L,message="文件夹主键字段过长")
	private Long folderId;
	// 用户主键
	@Max(value=9223372036854775807L,message="用户主键字段过长")
	private Long userId;
	// 查看权限
	@Max(value=99999999999L,message="查看权限字段过长")
	private Integer isView;
	// 设计权限
	@Max(value=99999999999L,message="设计权限字段过长")
	private Integer isDesisn;

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
	 * 用户主键
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * 用户主键
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/**
	 * 查看权限
	 */
	public Integer getIsView() {
		return this.isView;
	}

	/**
	 * 查看权限
	 */
	public void setIsView(Integer isView) {
		this.isView = isView;
	}
	
	/**
	 * 设计权限
	 */
	public Integer getIsDesisn() {
		return this.isDesisn;
	}

	/**
	 * 设计权限
	 */
	public void setIsDesisn(Integer isDesisn) {
		this.isDesisn = isDesisn;
	}
}
