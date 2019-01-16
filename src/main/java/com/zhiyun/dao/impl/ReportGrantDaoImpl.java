/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.dto.ReportGrantDto;
import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.ReportGrantDao;
import com.zhiyun.entity.ReportGrant;

import java.util.List;

/**
 * ReportGrantDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("reportGrantDao")
public class ReportGrantDaoImpl extends BaseDaoImpl<ReportGrant, Long> implements ReportGrantDao {

    @Override
    public List<ReportGrantDto> getGrant(ReportGrant reportGrant) {
        return this.selectList(getMethodName(),reportGrant);
    }
}
