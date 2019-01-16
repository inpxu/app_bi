/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 看板联动实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class Linkage extends BaseEntity<Long> {

	private static final long serialVersionUID = 3517497211618545295L;

	// ~~~~实体属性
	// 看板id
	@Max(value=9223372036854775807L,message="看板id字段过长")
	private Long boardId;
	// 联动目标
	@Pattern(regexp="[\\S]{0,50}", message="联动目标字段过长")
	private String fromId;
	// 联动目标名称
	@Pattern(regexp="[\\S]{0,50}", message="联动目标名称字段过长")
	private String fromName;
	// 被联动目标
	@Pattern(regexp="[\\S]{0,50}", message="被联动目标字段过长")
	private String toId;
	// 被联动目标名称
	@Pattern(regexp="[\\S]{0,50}", message="被联动目标名称字段过长")
	private String toName;
	// 联动参数
	@Pattern(regexp="[\\S]{0,255}", message="联动参数字段过长")
	private String linkParam;
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
	 * 看板id
	 */
	public Long getBoardId() {
		return this.boardId;
	}

	/**
	 * 看板id
	 */
	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}
	
	/**
	 * 联动目标
	 */
	public String getFromId() {
		return this.fromId;
	}

	/**
	 * 联动目标
	 */
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	
	/**
	 * 联动目标名称
	 */
	public String getFromName() {
		return this.fromName;
	}

	/**
	 * 联动目标名称
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	
	/**
	 * 被联动目标
	 */
	public String getToId() {
		return this.toId;
	}

	/**
	 * 被联动目标
	 */
	public void setToId(String toId) {
		this.toId = toId;
	}
	
	/**
	 * 被联动目标名称
	 */
	public String getToName() {
		return this.toName;
	}

	/**
	 * 被联动目标名称
	 */
	public void setToName(String toName) {
		this.toName = toName;
	}
	
	/**
	 * 联动参数
	 */
	public String getLinkParam() {
		return this.linkParam;
	}

	/**
	 * 联动参数
	 */
	public void setLinkParam(String linkParam) {
		this.linkParam = linkParam;
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
