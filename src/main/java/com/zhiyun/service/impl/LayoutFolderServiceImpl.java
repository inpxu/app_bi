/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.LayoutDao;
import com.zhiyun.dto.LayoutFolderDto;
import com.zhiyun.entity.Layout;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.LayoutFolderDao;
import com.zhiyun.entity.LayoutFolder;
import com.zhiyun.service.LayoutFolderService;

import java.util.List;

/**
 * 布局文件夹Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("layoutFolderService")
public class LayoutFolderServiceImpl extends BaseServiceImpl<LayoutFolder, Long> implements LayoutFolderService {

	@Resource
	private LayoutFolderDao layoutFolderDao;
	@Resource
	private LayoutDao layoutDao;

	@Override
	protected BaseDao<LayoutFolder, Long> getBaseDao() {
		return this.layoutFolderDao;
	}

	@Override
	public void delFolder(LayoutFolder layoutFolder) {
		Long id = layoutFolder.getId();
		Layout layout =  new Layout();
		layout.setFolderId(id);
		layout.setCompanyId(UserHolder.getCompanyId());
		List<Layout> list = layoutDao.find(layout);
		if (CollectionUtils.isNotEmpty(list)) {
			throw new BusinessException("该文件夹不为空，不能删除！");
		}
		layoutFolderDao.delete(id);
	}

	@Override
	public List<LayoutFolderDto> getFolder(LayoutFolder layoutFolder) {
		List<LayoutFolderDto> layoutFolderDtos = layoutFolderDao.getFolder(layoutFolder);
		for (LayoutFolderDto layoutFolderDto : layoutFolderDtos) {
			Long id = layoutFolderDto.getId();
			Layout layout =  new Layout();
			layout.setFolderId(id);
			layout.setCompanyId(UserHolder.getCompanyId());
			List<Layout> list = layoutDao.find(layout);
			for (Layout layout1 : list) {
				layout1.setConfig(null);
			}
			layoutFolderDto.setLayouts(list);
		}
		return layoutFolderDtos;
	}

	@Override
	public void addFolder(LayoutFolder layoutFolder) {
		LayoutFolder lay = new LayoutFolder();
		lay.setAlias(layoutFolder.getAlias());
		lay.setCompanyId(UserHolder.getCompanyId());
		List<LayoutFolder> layoutFolders = layoutFolderDao.find(lay);
		if (CollectionUtils.isNotEmpty(layoutFolders)) {
			throw new BusinessException("该名称已存在！");
		}
		layoutFolderDao.insert(layoutFolder);
	}

	@Override
	public void upFolder(LayoutFolder layoutFolder) {
		if (!layoutFolderDao.get(layoutFolder.getId()).getAlias().equals(layoutFolder.getAlias())){
			LayoutFolder lay = new LayoutFolder();
			lay.setAlias(layoutFolder.getAlias());
			lay.setCompanyId(UserHolder.getCompanyId());
			List<LayoutFolder> layoutFolders = layoutFolderDao.find(lay);
			if (CollectionUtils.isNotEmpty(layoutFolders)) {
				throw new BusinessException("该名称已存在！");
			}
		}
		layoutFolderDao.update(layoutFolder);
	}
}
