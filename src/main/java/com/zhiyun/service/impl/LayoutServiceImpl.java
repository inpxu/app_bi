/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.LayoutDao;
import com.zhiyun.entity.Layout;
import com.zhiyun.service.LayoutService;

import java.util.List;

/**
 * 布局信息Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("layoutService")
public class LayoutServiceImpl extends BaseServiceImpl<Layout, Long> implements LayoutService {

	@Resource
	private LayoutDao layoutDao;

	@Override
	protected BaseDao<Layout, Long> getBaseDao() {
		return this.layoutDao;
	}

	@Override
	public List<Layout> layoutDrop(Layout layout) {
		return layoutDao.layoutDrop(layout);
	}
}
