/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.dto.ReportFolderDto;
import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.ReportFolderDao;
import com.zhiyun.entity.ReportFolder;

import java.util.List;

/**
 * ReportFolderDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("reportFolderDao")
public class ReportFolderDaoImpl extends BaseDaoImpl<ReportFolder, Long> implements ReportFolderDao {

    @Override
    public List<ReportFolderDto> getTree(ReportFolder reportFolder) {
        return this.selectList(getMethodName(), reportFolder);
    }
}
