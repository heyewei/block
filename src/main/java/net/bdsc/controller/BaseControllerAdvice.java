/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: ZUVDFbthn9z9Xcm0xcrpU0f11z9WnPrz
 */
package net.bdsc.controller;

import java.util.Date;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.bdsc.DateEditor;
import net.bdsc.StringEditor;
import net.bdsc.exception.ResourceNotFoundException;
import net.bdsc.exception.UnauthorizedException;

/**
 * ControllerAdvice - 基类
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@ControllerAdvice("net.dbsc.controller")
public class BaseControllerAdvice {

	/**
	 * 数据绑定
	 * 
	 * @param binder
	 *            WebDataBinder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(Date.class, new DateEditor(true));
		binder.registerCustomEditor(String.class, "password", new StringEditor(true));
	}

	/**
	 * 异常处理
	 * 
	 * @param resourceNotFoundException
	 *            资源不存在
	 * @return 视图
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String exceptionHandler(ResourceNotFoundException resourceNotFoundException) {
		return "common/error/not_found";
	}

	/**
	 * 异常处理
	 * 
	 * @param typeMismatchException
	 *            类型配比错误
	 * @return 视图
	 */
	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String exceptionHandler(TypeMismatchException typeMismatchException) {
		return "common/error/type_mismatch";
	}

	/**
	 * 异常处理
	 * 
	 * @param unauthorizedException
	 *            无此访问权限
	 * @return 视图
	 */
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public String exceptionHandler(UnauthorizedException unauthorizedException) {
		return "common/error/unauthorized";
	}

}