/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: kVBGxk2n0OoO1AQfeMHhRLtI1esgTu2u
 */
package net.bdsc.service;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.Area;
import net.bdsc.entity.AreaFreightConfig;
import net.bdsc.entity.ShippingMethod;
import net.bdsc.entity.Store;

/**
 * Service - 地区运费配置
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface AreaFreightConfigService extends BaseService<AreaFreightConfig, Long> {

	/**
	 * 判断运费配置是否存在
	 * 
	 * @param shippingMethod
	 *            配送方式
	 * @param store
	 *            店铺
	 * @param area
	 *            地区
	 * @return 运费配置是否存在
	 */
	boolean exists(ShippingMethod shippingMethod, Store store, Area area);

	/**
	 * 判断运费配置是否唯一
	 * 
	 * @param id
	 *            ID
	 * @param shippingMethod
	 *            配送方式
	 * @param area
	 *            地区
	 * @param store
	 *            店铺
	 * @return 运费配置是否唯一
	 */
	boolean unique(Long id, ShippingMethod shippingMethod, Store store, Area area);

	/**
	 * 查找运费配置分页
	 * 
	 * @param shippingMethod
	 *            配送方式
	 * @param store
	 *            店铺
	 * @param pageable
	 *            分页信息
	 * @return 运费配置分页
	 */
	Page<AreaFreightConfig> findPage(ShippingMethod shippingMethod, Store store, Pageable pageable);

}