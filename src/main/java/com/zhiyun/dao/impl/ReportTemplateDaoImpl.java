/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.ReportTemplateDto;
import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.ReportTemplateDao;
import com.zhiyun.entity.ReportTemplate;

/**
 * ReportTemplateDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("reportTemplateDao")
public class ReportTemplateDaoImpl extends BaseDaoImpl<ReportTemplate, Long> implements ReportTemplateDao {

    @Override
    public DataGrid<ReportTemplateDto> getPage(Params params, Pager pager) {
        return this.selectPage(getMethodName(), params, pager);
    }
}
