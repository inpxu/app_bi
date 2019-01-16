/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.LayoutFolderDto;
import com.zhiyun.dto.ReportFolderDto;
import com.zhiyun.entity.LayoutFolder;
import com.zhiyun.entity.ReportFolder;

import java.util.List;

/**
 * 报表文件夹Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ReportFolderService extends BaseService<ReportFolder, Long> {

    // 新增
    void add(ReportFolder reportFolder);
    // 删除
    void del(ReportFolder reportFolder);
    // 树查询
    List<ReportFolderDto> getTree(ReportFolder reportFolder);
    // 编辑
    void upd(ReportFolder reportFolder);
}
