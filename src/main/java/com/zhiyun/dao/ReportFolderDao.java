/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.dto.ReportFolderDto;
import com.zhiyun.entity.ReportFolder;

import java.util.List;

/**
 * ReportFolderDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ReportFolderDao extends BaseDao<ReportFolder, Long> {

    // 树查询
    List<ReportFolderDto> getTree(ReportFolder reportFolder);
}
