/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.CasUserDao;
import com.zhiyun.entity.CasUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CasUserDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("casUserDao")
public class CasUserDaoImpl extends BaseDaoImpl<CasUser, Long> implements CasUserDao {

    @Override
    public List<CasUser> listCasUserInAuthAuthorization(CasUser casUser){
        return this.selectList(getMethodName(), casUser);
    }

}
