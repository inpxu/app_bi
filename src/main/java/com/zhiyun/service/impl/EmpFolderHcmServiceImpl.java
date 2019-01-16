/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import com.zhiyun.dto.EmpFolderHcmDto;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.EmpFolderHcmDao;
import com.zhiyun.entity.EmpFolderHcm;
import com.zhiyun.service.EmpFolderHcmService;

import java.util.List;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("empFolderHcmService")
public class EmpFolderHcmServiceImpl extends BaseServiceImpl<EmpFolderHcm, Long> implements EmpFolderHcmService {

	@Resource
	private EmpFolderHcmDao empFolderHcmDao;

	@Override
	protected BaseDao<EmpFolderHcm, Long> getBaseDao() {
		return this.empFolderHcmDao;
	}

	@Override
	public List<EmpFolderHcmDto> getEmp(EmpFolderHcm empFolderHcm) {
		return empFolderHcmDao.getEmp(empFolderHcm);
	}
}
