/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 7SUeqWaE94RN+X4BpQI78ifOYTUhG126
 */
package net.bdsc.dao;

import java.util.List;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.DeliveryCenter;
import net.bdsc.entity.Store;

/**
 * Dao - 发货点
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface DeliveryCenterDao extends BaseDao<DeliveryCenter, Long> {

	/**
	 * 查找默认发货点
	 * 
	 * @param store
	 *            店铺
	 * @return 默认发货点，若不存在则返回null
	 */
	DeliveryCenter findDefault(Store store);

	/**
	 * 清除默认
	 * 
	 * @param store
	 *            店铺
	 */
	void clearDefault(Store store);

	/**
	 * 清除默认
	 * 
	 * @param exclude
	 *            排除发货点
	 */
	void clearDefault(DeliveryCenter exclude);

	/**
	 * 查找发货点分页
	 * 
	 * @param store
	 *            店铺
	 * @param pageable
	 *            分页
	 * @return 发货点分页
	 */
	Page<DeliveryCenter> findPage(Store store, Pageable pageable);

	/**
	 * 查找发货点
	 * 
	 * @param store
	 *            店铺
	 * @return 发货点
	 */
	List<DeliveryCenter> findAll(Store store);

}