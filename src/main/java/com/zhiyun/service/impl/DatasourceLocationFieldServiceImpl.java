/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.DatasourceLocationFieldDao;
import com.zhiyun.entity.DatasourceLocationField;
import com.zhiyun.service.DatasourceLocationFieldService;

/**
 * 本地数据域字段Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("datasourceLocationFieldService")
public class DatasourceLocationFieldServiceImpl extends BaseServiceImpl<DatasourceLocationField, Long> implements DatasourceLocationFieldService {

	@Resource
	private DatasourceLocationFieldDao datasourceLocationFieldDao;

	@Override
	protected BaseDao<DatasourceLocationField, Long> getBaseDao() {
		return this.datasourceLocationFieldDao;
	}
}
