/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.dto.ReportGrantDto;
import com.zhiyun.entity.ReportGrant;

import java.util.List;

/**
 * ReportGrantDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ReportGrantDao extends BaseDao<ReportGrant, Long> {

    List<ReportGrantDto> getGrant(ReportGrant reportGrant);

}
