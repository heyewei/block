/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: Ib+ksMoQ6nwtZQAxNmv+6y+x8pnWX+v8
 */
package net.bdsc.service;

import net.bdsc.entity.Cart;
import net.bdsc.entity.Sku;

/**
 * Service - 购物车
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface CartService extends BaseService<Cart, Long> {

	/**
	 * 获取当前购物车
	 * 
	 * @return 当前购物车，若不存在则返回null
	 */
	Cart getCurrent();

	/**
	 * 创建购物车
	 * 
	 * @return 购物车
	 */
	Cart create();

	/**
	 * 添加购物车SKU
	 * 
	 * @param cart
	 *            购物车
	 * @param sku
	 *            SKU
	 * @param quantity
	 *            数量
	 */
	void add(Cart cart, Sku sku, int quantity);

	/**
	 * 修改购物车SKU
	 * 
	 * @param cart
	 *            购物车
	 * @param sku
	 *            SKU
	 * @param quantity
	 *            数量
	 */
	void modify(Cart cart, Sku sku, int quantity);

	/**
	 * 移除购物车SKU
	 * 
	 * @param cart
	 *            购物车
	 * @param sku
	 *            SKU
	 */
	void remove(Cart cart, Sku sku);

	/**
	 * 清空购物车SKU
	 * 
	 * @param cart
	 *            购物车
	 */
	void clear(Cart cart);

	/**
	 * 合并购物车
	 * 
	 * @param cart
	 *            购物车
	 */
	void merge(Cart cart);

	/**
	 * 删除过期购物车
	 */
	void deleteExpired();

}