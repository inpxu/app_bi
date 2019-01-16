/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.BoardDao;
import com.zhiyun.entity.Board;
import com.zhiyun.service.BoardService;

/**
 * 看板信息Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("boardService")
public class BoardServiceImpl extends BaseServiceImpl<Board, Long> implements BoardService {

	@Resource
	private BoardDao boardDao;

	@Override
	protected BaseDao<Board, Long> getBaseDao() {
		return this.boardDao;
	}
}
