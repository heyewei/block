/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: MuTFtNaI/o1oWMUxyvYPa/2hOd5HlYzV
 */
package net.bdsc.service.impl;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.dao.SocialUserDao;
import net.bdsc.entity.SocialUser;
import net.bdsc.entity.User;
import net.bdsc.service.SocialUserService;

/**
 * Service - 社会化用户
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class SocialUserServiceImpl extends BaseServiceImpl<SocialUser, Long> implements SocialUserService {

	@Inject
	private SocialUserDao socialUserDao;

	@Override
	@Transactional(readOnly = true)
	public SocialUser find(String loginPluginId, String uniqueId) {
		return socialUserDao.find(loginPluginId, uniqueId);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<SocialUser> findPage(User user, Pageable pageable) {
		return socialUserDao.findPage(user, pageable);
	}

	@Override
	public void bindUser(User user, SocialUser socialUser, String uniqueId) {
		Assert.notNull(socialUser, "[Assertion failed] - socialUser is required; it must not be null");
		Assert.hasText(uniqueId, "[Assertion failed] - uniqueId must have text; it must not be null, empty, or blank");

		if (!StringUtils.equals(socialUser.getUniqueId(), uniqueId) || socialUser.getUser() != null) {
			return;
		}

		socialUser.setUser(user);
	}

}