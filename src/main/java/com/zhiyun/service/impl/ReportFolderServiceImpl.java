/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.ReportDao;
import com.zhiyun.dto.ReportDto;
import com.zhiyun.dto.ReportFolderDto;
import com.zhiyun.entity.Report;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ReportFolderDao;
import com.zhiyun.entity.ReportFolder;
import com.zhiyun.service.ReportFolderService;

import java.util.List;

/**
 * 报表文件夹Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("reportFolderService")
public class ReportFolderServiceImpl extends BaseServiceImpl<ReportFolder, Long> implements ReportFolderService {

	@Resource
	private ReportFolderDao reportFolderDao;
	@Resource
	private ReportDao reportDao;

	@Override
	protected BaseDao<ReportFolder, Long> getBaseDao() {
		return this.reportFolderDao;
	}

	@Override
	public void add(ReportFolder reportFolder) {

		ReportFolder ref = new ReportFolder();
		// 添加创建人主键
		reportFolder.setCreateUserId(UserHolder.getUser().getId());
		ref.setAlias(reportFolder.getAlias());
		ref.setCompanyId(UserHolder.getCompanyId());
		List<ReportFolder> reportFolders = reportFolderDao.find(ref);
		if (CollectionUtils.isNotEmpty(reportFolders)) {
			throw new BusinessException("该名称已存在！");
		}
		reportFolderDao.insert(reportFolder);
	}

	@Override
	public void del(ReportFolder reportFolder) {
		Long id = reportFolder.getId();
		Report report =  new Report();
		report.setFolderId(id);
		report.setCompanyId(UserHolder.getCompanyId());
		List<Report> list = reportDao.find(report);
		if (CollectionUtils.isNotEmpty(list)) {
			throw new BusinessException("该文件夹不为空，不能删除！");
		}
		reportFolderDao.delete(id);
	}

	@Override
	public List<ReportFolderDto> getTree(ReportFolder reportFolder) {
		Long userId = UserHolder.getUser().getId();
		reportFolder.setCreateUserId(userId);
		System.err.println(UserHolder.getUser().getId());
		reportFolder.setCompanyId(UserHolder.getCompanyId());
		List<ReportFolderDto> reportFolderDtos = reportFolderDao.getTree(reportFolder);
		for (ReportFolderDto reportFolderDto : reportFolderDtos) {
			Long id = reportFolderDto.getId();
			Report report =  new Report();
			report.setCreateUserId(userId);
			report.setFolderId(id);
			report.setCompanyId(UserHolder.getCompanyId());
			List<ReportDto> list = reportDao.getTree(report);
			for (ReportDto report1 : list) {
				Long is = report1.getIsDesisn();
				Long cid = report1.getCreateUserId();
				if (is == null || is == 0) {
					reportFolderDto.setDesisn(false);
				} else if (is == 1) {
					report1.setDesisn(true);
				}
				if (cid.equals(userId)) {
					report1.setDesisn(true);
					report1.setGiveDes(true);
				} else {
					report1.setGiveDes(false);
				}
			}
			reportFolderDto.setReports(list);
		}
		return reportFolderDtos;
	}

	@Override
	public void upd(ReportFolder reportFolder) {
		if (!(reportFolderDao.get(reportFolder.getId()).getAlias()).equals(reportFolder.getAlias())){
			ReportFolder lay = new ReportFolder();
			lay.setAlias(reportFolder.getAlias());
			lay.setCompanyId(UserHolder.getCompanyId());
			List<ReportFolder> reportFolders = reportFolderDao.find(lay);
			if (CollectionUtils.isNotEmpty(reportFolders)) {
				throw new BusinessException("该名称已存在！");
			}
		}
		reportFolderDao.update(reportFolder);
	}
}
