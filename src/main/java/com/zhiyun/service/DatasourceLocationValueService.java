/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.DatasourceLocationValueDto;
import com.zhiyun.entity.DatasourceLocationValue;

import java.util.List;

/**
 * 本地数据域Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface DatasourceLocationValueService extends BaseService<DatasourceLocationValue, Long> {

    DatasourceLocationValueDto add(DatasourceLocationValue datasourceLocationValue);

    DatasourceLocationValueDto upd(DatasourceLocationValueDto datasourceLocationValue);

    DatasourceLocationValueDto getByKey(DatasourceLocationValueDto datasourceLocationValueDto);

    DatasourceLocationValueDto addOrUpd(DatasourceLocationValueDto datasourceLocationValueDto);

}
