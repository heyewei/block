/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 8pn2V0sJJmX3U+sOn3dFOLJ7bz6xE/j1
 */
package net.bdsc.dao;

import java.util.List;

import net.bdsc.Filter;
import net.bdsc.Order;
import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.Consultation;
import net.bdsc.entity.Member;
import net.bdsc.entity.Product;
import net.bdsc.entity.Store;

/**
 * Dao - 咨询
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface ConsultationDao extends BaseDao<Consultation, Long> {

	/**
	 * 查找咨询
	 * 
	 * @param member
	 *            会员
	 * @param product
	 *            商品
	 * @param isShow
	 *            是否显示
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @return 咨询，不包含咨询回复
	 */
	List<Consultation> findList(Member member, Product product, Boolean isShow, Integer count, List<Filter> filters, List<Order> orders);

	/**
	 * 查找咨询分页
	 * 
	 * @param member
	 *            会员
	 * @param product
	 *            商品
	 * @param store
	 *            店铺
	 * @param isShow
	 *            是否显示
	 * @param pageable
	 *            分页信息
	 * @return 咨询分页，不包含咨询回复
	 */
	Page<Consultation> findPage(Member member, Product product, Store store, Boolean isShow, Pageable pageable);

	/**
	 * 查找咨询数量
	 * 
	 * @param member
	 *            会员
	 * @param product
	 *            商品
	 * @param isShow
	 *            是否显示
	 * @return 咨询数量，不包含咨询回复
	 */
	Long count(Member member, Product product, Boolean isShow);

}