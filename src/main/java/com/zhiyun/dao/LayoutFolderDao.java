/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.dto.LayoutFolderDto;
import com.zhiyun.entity.LayoutFolder;

import java.util.List;

/**
 * LayoutFolderDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface LayoutFolderDao extends BaseDao<LayoutFolder, Long> {

    List<LayoutFolderDto> getFolder(LayoutFolder layoutFolder);

}
