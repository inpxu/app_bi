/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import com.zhiyun.client.UserHolder;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ReportConfigDao;
import com.zhiyun.entity.ReportConfig;
import com.zhiyun.service.ReportConfigService;

import java.util.List;

/**
 * 报表设计Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("reportConfigService")
public class ReportConfigServiceImpl extends BaseServiceImpl<ReportConfig, Long> implements ReportConfigService {

	@Resource
	private ReportConfigDao reportConfigDao;

	@Override
	protected BaseDao<ReportConfig, Long> getBaseDao() {
		return this.reportConfigDao;
	}

	@Override
	public void upd(ReportConfig reportConfig) {
		Long id = reportConfig.getId();
		if (id == null) {
			Long reportId = reportConfig.getReportId();
			ReportConfig re = new ReportConfig();
			re.setReportId(reportId);
			re.setCompanyId(UserHolder.getCompanyId());
			List<ReportConfig> list = reportConfigDao.find(re);
			if (CollectionUtils.isNotEmpty(list)) {
				for (ReportConfig config : list) {
					reportConfig.setId(config.getId());
					reportConfigDao.update(reportConfig);
				}
			}
		} else {
			reportConfigDao.update(reportConfig);
		}
	}
}
