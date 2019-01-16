/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.dto.ReportGrantDto;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ReportGrantDao;
import com.zhiyun.entity.ReportGrant;
import com.zhiyun.service.ReportGrantService;

import java.util.List;

/**
 * 报表授权Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("reportGrantService")
public class ReportGrantServiceImpl extends BaseServiceImpl<ReportGrant, Long> implements ReportGrantService {

	@Resource
	private ReportGrantDao reportGrantDao;

	@Override
	protected BaseDao<ReportGrant, Long> getBaseDao() {
		return this.reportGrantDao;
	}

	@Override
	public List<ReportGrantDto> getGrant(ReportGrant reportGrant) {
		return reportGrantDao.getGrant(reportGrant);
	}

	@Override
	public void add(ReportGrant reportGrant) {
		Long fi = reportGrant.getFolderId();
		Long ui = reportGrant.getUserId();
		ReportGrant rt = new ReportGrant();
		rt.setFolderId(fi);
		rt.setUserId(ui);
		List<ReportGrant> list = reportGrantDao.find(rt);
		if (CollectionUtils.isNotEmpty(list)) {
			throw  new BusinessException("该员工已授权");
		}
		reportGrantDao.insert(reportGrant);
	}
}
