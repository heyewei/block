/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 7H/znPb44dJ/d+AaFKaE21lmYE7Krlu+
 */
package net.bdsc.dao;

import java.util.Date;
import java.util.List;

import net.bdsc.entity.Statistic;
import net.bdsc.entity.Store;

/**
 * Dao - 统计
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface StatisticDao extends BaseDao<Statistic, Long> {

	/**
	 * 判断统计是否存在
	 * 
	 * @param type
	 *            类型
	 * @param store
	 *            店铺
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param day
	 *            日
	 * @return 统计是否存在
	 */
	boolean exists(Statistic.Type type, Store store, int year, int month, int day);

	/**
	 * 分析
	 * 
	 * @param type
	 *            类型
	 * @param store
	 *            店铺
	 * @param period
	 *            周期
	 * @param beginDate
	 *            起始日期
	 * @param endDate
	 *            结束日期
	 * @return 统计
	 */
	List<Statistic> analyze(Statistic.Type type, Store store, Statistic.Period period, Date beginDate, Date endDate);

}