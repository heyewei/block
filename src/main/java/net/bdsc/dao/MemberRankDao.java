/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: xHiE28scKX0pMKOYhRNjCR+WO8iNHDrB
 */
package net.bdsc.dao;

import java.math.BigDecimal;

import net.bdsc.entity.MemberRank;

/**
 * Dao - 会员等级
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface MemberRankDao extends BaseDao<MemberRank, Long> {

	/**
	 * 查找默认会员等级
	 * 
	 * @return 默认会员等级，若不存在则返回null
	 */
	MemberRank findDefault();

	/**
	 * 根据消费金额查找符合此条件的最高会员等级
	 * 
	 * @param amount
	 *            消费金额
	 * @return 会员等级，不包含特殊会员等级，若不存在则返回null
	 */
	MemberRank findByAmount(BigDecimal amount);

	/**
	 * 清除默认
	 */
	void clearDefault();

	/**
	 * 清除默认
	 * 
	 * @param exclude
	 *            排除会员等级
	 */
	void clearDefault(MemberRank exclude);

}