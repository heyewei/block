/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: qSflDk/ZX/ZXE0dfU4A97i4QDYi0cnCc
 */
package net.bdsc.service;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.MessageGroup;
import net.bdsc.entity.User;

/**
 * Service - 消息组
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface MessageGroupService extends BaseService<MessageGroup, Long> {

	/**
	 * 查找分页
	 * 
	 * @param user
	 *            用户
	 * @param pageable
	 *            分页信息
	 * @return 消息组分页
	 */
	Page<MessageGroup> findPage(User user, Pageable pageable);

	/**
	 * 查找
	 * 
	 * @param user1
	 *            用户1
	 * @param user2
	 *            用户2
	 * @return 消息组
	 */
	MessageGroup find(User user1, User user2);

	/**
	 * 删除
	 * 
	 * @param messageGroup
	 *            消息组
	 * @param user
	 *            用户
	 */
	void delete(MessageGroup messageGroup, User user);

}