/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: fNplSeAVyYw/B1jxjRAWW7bz/N3z86Gw
 */
package net.bdsc.security;

import org.apache.shiro.authc.UsernamePasswordToken;

import net.bdsc.entity.SocialUser;

/**
 * Security - 社会化用户认证令牌
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public class SocialUserAuthenticationToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 4730354877859067747L;

	/**
	 * 社会化用户
	 */
	private SocialUser socialUser;

	/**
	 * 记住我
	 */
	private boolean rememberMe = false;

	/**
	 * 主机
	 */
	private String host;

	/**
	 * 构造方法
	 * 
	 * @param socialUser
	 *            社会化用户
	 * @param rememberMe
	 *            记住我
	 * @param host
	 *            主机
	 */
	public SocialUserAuthenticationToken(SocialUser socialUser, boolean rememberMe, String host) {
		this.socialUser = socialUser;
		this.rememberMe = rememberMe;
		this.host = host;
	}

	/**
	 * 获取社会化用户
	 * 
	 * @return 社会化用户
	 */
	public SocialUser getSocialUser() {
		return socialUser;
	}

	@Override
	public boolean isRememberMe() {
		return rememberMe;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public Object getPrincipal() {
		return socialUser != null && socialUser.getUser() != null ? socialUser.getUser().getPrincipal() : null;
	}

	@Override
	public Object getCredentials() {
		return socialUser != null && socialUser.getUser() != null ? socialUser.getUser().getCredentials() : null;
	}

}