/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: BXEfdHDyfLRM8MDEbtzzwiN0WtEmxtlr
 */
package net.bdsc.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.bdsc.entity.Business;

/**
 * Dao - 商家
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface BusinessDao extends BaseDao<Business, Long> {

	/**
	 * 通过名称查找商家
	 * 
	 * @param keyword
	 *            关键词
	 * @param count
	 *            数量
	 * @return 商家
	 */
	List<Business> search(String keyword, Integer count);

	/**
	 * 查询商家数量
	 * 
	 * @param beginDate
	 *            起始日期
	 * @param endDate
	 *            结束日期
	 * @return 商家数量
	 */
	Long count(Date beginDate, Date endDate);

	/**
	 * 查询总余额
	 * 
	 * @return 总余额
	 */
	BigDecimal totalBalance();

	/**
	 * 查询冻结总额
	 * 
	 * @return 冻结总额
	 */
	BigDecimal frozenTotalAmount();

}