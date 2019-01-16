/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.facade.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.facade.ReportTemplateFacade;
import com.zhiyun.service.ReportTemplateService;

/**
 * ReportTemplateFacade接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("reportTemplateFacade")
public class ReportTemplateFacadeImpl implements ReportTemplateFacade {

	@Resource
	private ReportTemplateService reportTemplateService;
	
	
}
