/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: ayH5VolzQLrq8BJn31A69TEtDZZqG8eO
 */
package net.bdsc.service;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.Area;
import net.bdsc.entity.DefaultFreightConfig;
import net.bdsc.entity.ShippingMethod;
import net.bdsc.entity.Store;

/**
 * Service - 默认运费配置
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface DefaultFreightConfigService extends BaseService<DefaultFreightConfig, Long> {

	/**
	 * 判断运费配置是否存在
	 * 
	 * @param shippingMethod
	 *            配送方式
	 * @param area
	 *            地区
	 * @return 运费配置是否存在
	 */
	boolean exists(ShippingMethod shippingMethod, Area area);

	/**
	 * 判断运费配置是否唯一
	 * 
	 * @param shippingMethod
	 *            配送方式
	 * @param previousArea
	 *            修改前地区
	 * @param currentArea
	 *            当前地区
	 * @return 运费配置是否唯一
	 */
	boolean unique(ShippingMethod shippingMethod, Area previousArea, Area currentArea);

	/**
	 * 查找运费配置分页
	 * 
	 * @param store
	 *            店铺
	 * @param pageable
	 *            分页信息
	 * @return 运费配置分页
	 */
	Page<DefaultFreightConfig> findPage(Store store, Pageable pageable);

	/**
	 * 查找默认运费配置
	 * 
	 * @param shippingMethod
	 *            配送方式
	 * @param store
	 *            店铺
	 * @return 默认运费配置
	 */
	DefaultFreightConfig find(ShippingMethod shippingMethod, Store store);

	/**
	 * 更新
	 * 
	 * @param defaultFreightConfig
	 *            默认运费配置
	 * @param store
	 *            店铺
	 * @param shippingMethod
	 *            配送方式
	 */
	void update(DefaultFreightConfig defaultFreightConfig, Store store, ShippingMethod shippingMethod);

}