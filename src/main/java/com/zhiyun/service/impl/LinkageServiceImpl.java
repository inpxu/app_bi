/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.LinkageDao;
import com.zhiyun.entity.Linkage;
import com.zhiyun.service.LinkageService;

/**
 * 看板联动Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("linkageService")
public class LinkageServiceImpl extends BaseServiceImpl<Linkage, Long> implements LinkageService {

	@Resource
	private LinkageDao linkageDao;

	@Override
	protected BaseDao<Linkage, Long> getBaseDao() {
		return this.linkageDao;
	}
}
