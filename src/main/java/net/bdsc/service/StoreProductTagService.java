/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: moay8gImvYR2CeUVhJ3SswPEOg8pwweN
 */
package net.bdsc.service;

import java.util.List;

import net.bdsc.Filter;
import net.bdsc.Order;
import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.Store;
import net.bdsc.entity.StoreProductTag;

/**
 * Service - 店铺商品标签
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface StoreProductTagService extends BaseService<StoreProductTag, Long> {

	/**
	 * 查找店铺商品标签
	 * 
	 * @param store
	 *            店铺
	 * @param isEnabled
	 *            是否启用
	 * @return 店铺商品标签
	 */
	List<StoreProductTag> findList(Store store, Boolean isEnabled);

	/**
	 * 查找店铺商品标签
	 * 
	 * @param storeId
	 *            店铺ID
	 * @param isEnabled
	 *            是否启用
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @param useCache
	 *            是否使用缓存
	 * @return 店铺商品标签
	 */
	List<StoreProductTag> findList(Long storeId, Boolean isEnabled, Integer count, List<Filter> filters, List<Order> orders, boolean useCache);

	/**
	 * 查找店铺商品标签分页
	 * 
	 * @param store
	 *            店铺
	 * @param pageable
	 *            分页
	 * @return 店铺商品标签分页
	 */
	Page<StoreProductTag> findPage(Store store, Pageable pageable);

}