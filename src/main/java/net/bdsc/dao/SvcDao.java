/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: pSspsrrnia+NqPaML3795/zsrertvE1m
 */
package net.bdsc.dao;

import java.util.List;

import net.bdsc.Order;
import net.bdsc.entity.Store;
import net.bdsc.entity.StoreRank;
import net.bdsc.entity.Svc;

/**
 * Dao - 服务
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface SvcDao extends BaseDao<Svc, Long> {

	/**
	 * 查找服务
	 * 
	 * @param store
	 *            店铺
	 * @param promotionPluginId
	 *            促销插件Id
	 * @param storeRank
	 *            店铺等级
	 * @param orders
	 *            排序
	 * @return 服务
	 */
	List<Svc> find(Store store, String promotionPluginId, StoreRank storeRank, List<Order> orders);

}