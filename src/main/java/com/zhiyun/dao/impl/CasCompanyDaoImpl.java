/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.CasCompanyDao;
import com.zhiyun.entity.CasCompany;
import org.springframework.stereotype.Repository;

/**
 * CasCompanyDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("casCompanyDao")
public class CasCompanyDaoImpl extends BaseDaoImpl<CasCompany, Long> implements CasCompanyDao {

    @Override
    public CasCompany getCasCompanyInAuthAuthorization(Long companyId) {
        Params params = Params.create();
        params.add("id",companyId);
        params.add("deleted","F");
        return this.selectOne(getMethodName(),params);
    }
}
