/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: nKzylKM1YgGjJQlpAiBGwOXWxr9uj+Ge
 */
package net.bdsc.dao;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.SocialUser;
import net.bdsc.entity.User;

/**
 * Dao - 社会化用户
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface SocialUserDao extends BaseDao<SocialUser, Long> {

	/**
	 * 查找社会化用户
	 * 
	 * @param loginPluginId
	 *            登录插件ID
	 * @param uniqueId
	 *            唯一ID
	 * @return 社会化用户，若不存在则返回null
	 */
	SocialUser find(String loginPluginId, String uniqueId);

	/**
	 * 查找社会化用户分页
	 * 
	 * @param user
	 *            用户
	 * @param pageable
	 *            分页信息
	 * @return 社会化用户分页
	 */
	Page<SocialUser> findPage(User user, Pageable pageable);

}