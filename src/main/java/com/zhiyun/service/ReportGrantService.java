/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.ReportGrantDto;
import com.zhiyun.entity.ReportGrant;

import java.util.List;

/**
 * 报表授权Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ReportGrantService extends BaseService<ReportGrant, Long> {

    List<ReportGrantDto> getGrant(ReportGrant reportGrant);
    void add(ReportGrant reportGrant);
}
