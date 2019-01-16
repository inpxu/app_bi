/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.dto.EmpFolderHcmDto;
import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.EmpFolderHcmDao;
import com.zhiyun.entity.EmpFolderHcm;

import java.util.List;

/**
 * EmpFolderHcmDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("empFolderHcmDao")
public class EmpFolderHcmDaoImpl extends BaseDaoImpl<EmpFolderHcm, Long> implements EmpFolderHcmDao {

    @Override
    public List<EmpFolderHcmDto> getEmp(EmpFolderHcm empFolderHcm) {
        return this.selectList(getMethodName(),empFolderHcm);
    }
}
