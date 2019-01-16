/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.LayoutFolderDto;
import com.zhiyun.entity.LayoutFolder;

import java.util.List;

/**
 * 布局文件夹Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface LayoutFolderService extends BaseService<LayoutFolder, Long> {

    // 删除
    void delFolder(LayoutFolder layoutFolder);
    // 树查询
    List<LayoutFolderDto> getFolder(LayoutFolder layoutFolder);

    // 新增
    void addFolder(LayoutFolder layoutFolder);

    // 编辑
    void upFolder(LayoutFolder layoutFolder);

}
