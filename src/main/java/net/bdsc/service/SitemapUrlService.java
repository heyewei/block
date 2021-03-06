/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: jgMArw7Bqaq6L31nM65QjiLgNE1dxCz2
 */
package net.bdsc.service;

import java.util.List;

import net.bdsc.entity.SitemapUrl;

/**
 * Service - Sitemap URL
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface SitemapUrlService {

	/**
	 * 生成Sitemap URL
	 * 
	 * @param type
	 *            类型
	 * @param changefreq
	 *            更新频率
	 * @param priority
	 *            权重
	 * @param first
	 *            起始记录
	 * @param count
	 *            数量
	 * @return Sitemap URL
	 */
	List<SitemapUrl> generate(SitemapUrl.Type type, SitemapUrl.Changefreq changefreq, float priority, Integer first, Integer count);

	/**
	 * 查询Sitemap URL数量
	 * 
	 * @param type
	 *            类型
	 * @return Sitemap URL数量
	 */
	Long count(SitemapUrl.Type type);

}