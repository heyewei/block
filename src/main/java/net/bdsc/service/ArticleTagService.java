/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: q4IMu1xYdJnvv1yyG9Wv+PK3mTi+aHa+
 */
package net.bdsc.service;

import java.util.List;

import net.bdsc.Filter;
import net.bdsc.Order;
import net.bdsc.entity.ArticleTag;

/**
 * Service - 文章标签
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface ArticleTagService extends BaseService<ArticleTag, Long> {

	/**
	 * 查找文章标签
	 * 
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @param useCache
	 *            是否使用缓存
	 * @return 文章标签
	 */
	List<ArticleTag> findList(Integer count, List<Filter> filters, List<Order> orders, boolean useCache);

}