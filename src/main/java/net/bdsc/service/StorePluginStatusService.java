/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 38s5IrbD6BuahraNSm/sByTdyv87/xNh
 */
package net.bdsc.service;

import net.bdsc.entity.Store;
import net.bdsc.entity.StorePluginStatus;

/**
 * Service - 店铺插件状态
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface StorePluginStatusService extends BaseService<StorePluginStatus, Long> {

	/**
	 * 查找店铺插件状态
	 * 
	 * @param store
	 *            店铺
	 * @param pluginId
	 *            插件ID
	 * @return 店铺插件状态，若不存在则返回null
	 */
	StorePluginStatus find(Store store, String pluginId);

	/**
	 * 增加插件到期天数
	 * 
	 * @param storePluginStatus
	 *            店铺插件状态
	 * @param amount
	 *            值
	 */
	void addPluginEndDays(StorePluginStatus storePluginStatus, int amount);

	/**
	 * 创建
	 * 
	 * @param store
	 *            店铺
	 * @param pluginId
	 *            插件ID
	 * @param amount
	 *            值
	 * @return 店铺插件状态
	 */
	StorePluginStatus create(Store store, String pluginId, Integer amount);

}