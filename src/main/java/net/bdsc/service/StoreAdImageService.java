/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: hlSxvbmtLSL8i9UCDsFZusu3ACC6T/Lu
 */
package net.bdsc.service;

import java.util.List;

import net.bdsc.Filter;
import net.bdsc.Order;
import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.Store;
import net.bdsc.entity.StoreAdImage;

/**
 * Service - 店铺广告图片
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface StoreAdImageService extends BaseService<StoreAdImage, Long> {

	/**
	 * 查找店铺广告图片
	 * 
	 * @param storeId
	 *            店铺ID
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @param useCache
	 *            是否使用缓存
	 * @return 店铺广告图片
	 */
	List<StoreAdImage> findList(Long storeId, Integer count, List<Filter> filters, List<Order> orders, boolean useCache);

	/**
	 * 查找店铺广告图片分页
	 * 
	 * @param store
	 *            店铺
	 * @param pageable
	 *            分页信息
	 * @return 店铺广告图片分页
	 */
	Page<StoreAdImage> findPage(Store store, Pageable pageable);

}