/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: AJct73iVQkHXIDZUXeec/ELtIY6cOUmn
 */
package net.bdsc.service;

import java.util.List;
import java.util.Set;

import net.bdsc.entity.Product;
import net.bdsc.entity.Sku;
import net.bdsc.entity.StockLog;
import net.bdsc.entity.Store;

/**
 * Service - SKU
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface SkuService extends BaseService<Sku, Long> {

	/**
	 * 判断编号是否存在
	 * 
	 * @param sn
	 *            编号(忽略大小写)
	 * @return 编号是否存在
	 */
	boolean snExists(String sn);

	/**
	 * 根据编号查找SKU
	 * 
	 * @param sn
	 *            编号(忽略大小写)
	 * @return SKU，若不存在则返回null
	 */
	Sku findBySn(String sn);

	/**
	 * 通过编号、名称查找SKU
	 * 
	 * @param store
	 *            店铺
	 * @param type
	 *            类型
	 * @param keyword
	 *            关键词
	 * @param excludes
	 *            排除SKU
	 * @param count
	 *            数量
	 * @return SKU
	 */
	List<Sku> search(Store store, Product.Type type, String keyword, Set<Sku> excludes, Integer count);

	/**
	 * 查找SKU
	 * 
	 * @param store
	 *            店铺
	 * @param type
	 *            类型
	 * @param matchs
	 *            匹配SKU
	 * @param count
	 *            数量
	 * @return SKU
	 */
	List<Sku> findList(Store store, Product.Type type, Set<Sku> matchs, Integer count);

	/**
	 * 增加库存
	 * 
	 * @param sku
	 *            SKU
	 * @param amount
	 *            值
	 * @param type
	 *            类型
	 * @param memo
	 *            备注
	 */
	void addStock(Sku sku, int amount, StockLog.Type type, String memo);

	/**
	 * 增加已分配库存
	 * 
	 * @param sku
	 *            SKU
	 * @param amount
	 *            值
	 */
	void addAllocatedStock(Sku sku, int amount);

	/**
	 * SKU过滤
	 * 
	 * @param skus
	 *            SKU
	 */
	void filter(List<Sku> skus);

}