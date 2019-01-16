/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.dto.LayoutFolderDto;
import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.LayoutFolderDao;
import com.zhiyun.entity.LayoutFolder;

import java.util.List;

/**
 * LayoutFolderDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("layoutFolderDao")
public class LayoutFolderDaoImpl extends BaseDaoImpl<LayoutFolder, Long> implements LayoutFolderDao {

    @Override
    public List<LayoutFolderDto> getFolder(LayoutFolder layoutFolder) {
        return this.selectList(getMethodName(),layoutFolder);
    }

}
