/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.dto.ReportDto;
import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.ReportDao;
import com.zhiyun.entity.Report;

import java.util.List;

/**
 * ReportDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("reportDao")
public class ReportDaoImpl extends BaseDaoImpl<Report, Long> implements ReportDao {

    @Override
    public List<ReportDto> getTree(Report report) {
        return this.selectList(getMethodName(),report);
    }
}
