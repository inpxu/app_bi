/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.ReportDto;
import com.zhiyun.entity.Report;

import java.util.List;

/**
 * 看板信息Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ReportService extends BaseService<Report, Long> {

    void add (ReportDto reportDto);

    ReportDto getRe(Report report);

    void upRe (ReportDto reportDto);

    void copy(ReportDto reportDto);
    void del(Long id);

}
