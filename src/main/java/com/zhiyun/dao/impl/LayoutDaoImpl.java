/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.dto.LayoutFolderDto;
import com.zhiyun.entity.LayoutFolder;
import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.LayoutDao;
import com.zhiyun.entity.Layout;

import java.util.List;

/**
 * LayoutDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("layoutDao")
public class LayoutDaoImpl extends BaseDaoImpl<Layout, Long> implements LayoutDao {
    @Override
    public List<Layout> layoutDrop(Layout layout) {
        return this.selectList(getMethodName(),layout);
    }
}
