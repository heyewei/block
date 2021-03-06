/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: X4C4KF4+L9oykuDsVCzUhuo53PycbUUq
 */
package net.bdsc.dao;

import net.bdsc.entity.Seo;

/**
 * Dao - SEO设置
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface SeoDao extends BaseDao<Seo, Long> {

	/**
	 * 查找SEO设置
	 * 
	 * @param type
	 *            类型
	 * @return SEO设置
	 */
	Seo find(Seo.Type type);

}