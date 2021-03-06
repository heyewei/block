/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: o+xi8kvQi1qxBdWXLgvoSSskwZkhT82L
 */
package net.bdsc.security;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.bdsc.entity.User;
import net.bdsc.service.UserService;

/**
 * Security - 当前用户拦截器
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public class CurrentUserHandlerInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 默认"当前用户"属性名称
	 */
	public static final String DEFAULT_CURRENT_USER_ATTRIBUTE_NAME = "currentUser";

	/**
	 * 用户类型
	 */
	private Class<? extends User> userClass;

	/**
	 * "当前用户"属性名称
	 */
	private String currentUserAttributeName = DEFAULT_CURRENT_USER_ATTRIBUTE_NAME;

	@Inject
	private UserService userService;

	/**
	 * 请求后处理
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @param handler
	 *            处理器
	 * @param modelAndView
	 *            数据视图
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		request.setAttribute(getCurrentUserAttributeName(), userService.getCurrent(getUserClass()));
	}

	/**
	 * 获取用户类型
	 * 
	 * @return 用户类型
	 */
	public Class<? extends User> getUserClass() {
		return userClass;
	}

	/**
	 * 设置用户类型
	 * 
	 * @param userClass
	 *            用户类型
	 */
	public void setUserClass(Class<? extends User> userClass) {
		this.userClass = userClass;
	}

	/**
	 * 获取"当前用户"属性名称
	 * 
	 * @return "当前用户"属性名称
	 */
	public String getCurrentUserAttributeName() {
		return currentUserAttributeName;
	}

	/**
	 * 设置"当前用户"属性名称
	 * 
	 * @param currentUserAttributeName
	 *            "当前用户"属性名称
	 */
	public void setCurrentUserAttributeName(String currentUserAttributeName) {
		this.currentUserAttributeName = currentUserAttributeName;
	}

}