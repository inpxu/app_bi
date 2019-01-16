/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.facade.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.facade.DatasourceLocationFieldFacade;
import com.zhiyun.service.DatasourceLocationFieldService;

/**
 * DatasourceLocationFieldFacade接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("datasourceLocationFieldFacade")
public class DatasourceLocationFieldFacadeImpl implements DatasourceLocationFieldFacade {

	@Resource
	private DatasourceLocationFieldService datasourceLocationFieldService;
	
	
}
