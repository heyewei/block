/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: pGEnPurQxu1PnV3UXaCKHeCqyy17+Wan
 */
package net.bdsc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.dao.CouponDao;
import net.bdsc.entity.Coupon;
import net.bdsc.entity.Store;
import net.bdsc.service.CouponService;

/**
 * Service - 优惠券
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class CouponServiceImpl extends BaseServiceImpl<Coupon, Long> implements CouponService {

	/**
	 * 价格表达式变量
	 */
	private static final List<Map<String, Object>> PRICE_EXPRESSION_VARIABLES = new ArrayList<>();

	@Inject
	private CouponDao couponDao;

	static {
		Map<String, Object> variable0 = new HashMap<>();
		Map<String, Object> variable1 = new HashMap<>();
		Map<String, Object> variable2 = new HashMap<>();
		variable0.put("quantity", 99);
		variable0.put("price", new BigDecimal("99"));
		variable1.put("quantity", 99);
		variable1.put("price", new BigDecimal("9.9"));
		variable2.put("quantity", 99);
		variable2.put("price", new BigDecimal("0.99"));
		PRICE_EXPRESSION_VARIABLES.add(variable0);
		PRICE_EXPRESSION_VARIABLES.add(variable1);
		PRICE_EXPRESSION_VARIABLES.add(variable2);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isValidPriceExpression(String priceExpression) {
		Assert.hasText(priceExpression, "[Assertion failed] - priceExpression must have text; it must not be null, empty, or blank");

		for (Map<String, Object> variable : PRICE_EXPRESSION_VARIABLES) {
			try {
				Binding binding = new Binding();
				for (Map.Entry<String, Object> entry : variable.entrySet()) {
					binding.setVariable(entry.getKey(), entry.getValue());
				}
				GroovyShell groovyShell = new GroovyShell(binding);
				Object result = groovyShell.evaluate(priceExpression);
				new BigDecimal(String.valueOf(result));
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Coupon> findList(Store store) {
		return couponDao.findList(store, null, null, null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Coupon> findList(Store store, Boolean isEnabled, Boolean isExchange, Boolean hasExpired) {
		return couponDao.findList(store, isEnabled, isExchange, hasExpired);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Coupon> findList(Store store, Set<Coupon> matchs) {
		return couponDao.findList(store, matchs);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Coupon> findPage(Boolean isEnabled, Boolean isExchange, Boolean hasExpired, Pageable pageable) {
		return couponDao.findPage(isEnabled, isExchange, hasExpired, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Coupon> findPage(Store store, Pageable pageable) {
		return couponDao.findPage(store, pageable);
	}

}