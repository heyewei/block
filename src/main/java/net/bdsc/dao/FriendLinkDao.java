/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 1PRwbTMgZwFLvsZ2UPz5SLUFm0jrf55K
 */
package net.bdsc.dao;

import java.util.List;

import net.bdsc.entity.FriendLink;

/**
 * Dao - 友情链接
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface FriendLinkDao extends BaseDao<FriendLink, Long> {

	/**
	 * 查找友情链接
	 * 
	 * @param type
	 *            类型
	 * @return 友情链接
	 */
	List<FriendLink> findList(FriendLink.Type type);

}