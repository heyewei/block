/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: k+H3e/iCcG/3QADokPUWu8pV0XaBYhjB
 */
package net.bdsc.template.directive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import net.bdsc.Filter;
import net.bdsc.Order;
import net.bdsc.entity.BusinessAttribute;
import net.bdsc.service.BusinessAttributeService;

/**
 * 模板指令 - 商家注册项列表
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Component
public class BusinessAttributeListDirective extends BaseDirective {

	/**
	 * 变量名称
	 */
	private static final String VARIABLE_NAME = "businessAttributes";

	@Inject
	private BusinessAttributeService businessAttributeService;

	/**
	 * 执行
	 * 
	 * @param env
	 *            环境变量
	 * @param params
	 *            参数
	 * @param loopVars
	 *            循环变量
	 * @param body
	 *            模板内容
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
		Integer count = getCount(params);
		List<Filter> filters = getFilters(params, BusinessAttribute.class);
		List<Order> orders = getOrders(params);
		boolean useCache = useCache(params);

		List<BusinessAttribute> businessAttributes = businessAttributeService.findList(true, count, filters, orders, useCache);
		setLocalVariable(VARIABLE_NAME, businessAttributes, env, body);
	}

}