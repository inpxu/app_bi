/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.BoardDao;
import com.zhiyun.entity.Board;

/**
 * BoardDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("boardDao")
public class BoardDaoImpl extends BaseDaoImpl<Board, Long> implements BoardDao {

}
