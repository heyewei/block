/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: MNg18BextvaGn6UOZpddrCJ3JRWxzY77
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
import net.bdsc.entity.ProductFavorite;
import net.bdsc.entity.StoreFavorite;
import net.bdsc.service.StoreFavoriteService;
import net.bdsc.util.FreeMarkerUtils;

/**
 * 模板指令 - 店铺收藏
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Component
public class StoreFavoriteDirective extends BaseDirective {

	/**
	 * "会员ID"参数名称
	 */
	private static final String MEMBER_ID_PARAMETER_NAME = "memberId";

	/**
	 * 变量名称
	 */
	private static final String VARIABLE_NAME = "storeFavorites";

	@Inject
	private StoreFavoriteService storeFavoriteService;

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
		Long memberId = FreeMarkerUtils.getParameter(MEMBER_ID_PARAMETER_NAME, Long.class, params);
		Integer count = getCount(params);
		List<Filter> filters = getFilters(params, ProductFavorite.class);
		List<Order> orders = getOrders(params);
		boolean useCache = useCache(params);

		List<StoreFavorite> storeFavorites = storeFavoriteService.findList(memberId, count, filters, orders, useCache);
		setLocalVariable(VARIABLE_NAME, storeFavorites, env, body);
	}

}