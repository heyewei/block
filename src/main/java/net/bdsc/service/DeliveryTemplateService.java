/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: yxrxOZTw/bIoKVoh9n/OT7/2vDmu9MhU
 */
package net.bdsc.service;

import java.util.List;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.DeliveryCenter;
import net.bdsc.entity.DeliveryTemplate;
import net.bdsc.entity.Order;
import net.bdsc.entity.Store;

/**
 * Service - 快递单模板
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface DeliveryTemplateService extends BaseService<DeliveryTemplate, Long> {

	/**
	 * 查找默认快递单模板
	 * 
	 * @param store
	 *            店铺
	 * @return 默认快递单模板，若不存在则返回null
	 */
	DeliveryTemplate findDefault(Store store);

	/**
	 * 查找快递单模板
	 * 
	 * @param store
	 *            店铺
	 * @return 快递单模板
	 */
	List<DeliveryTemplate> findList(Store store);

	/**
	 * 查找快递单模板分页
	 * 
	 * @param store
	 *            店铺
	 * @param pageable
	 *            分页信息
	 * @return 快递单模板分页
	 */
	Page<DeliveryTemplate> findPage(Store store, Pageable pageable);

	/**
	 * 解析内容
	 * 
	 * @param deliveryTemplate
	 *            快递单模板
	 * @param store
	 *            店铺
	 * @param deliveryCenter
	 *            发货点
	 * @param order
	 *            订单
	 * @return 内容
	 */
	String resolveContent(DeliveryTemplate deliveryTemplate, Store store, DeliveryCenter deliveryCenter, Order order);

}