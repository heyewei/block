/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: Fq7hbSkCnnHKAWUa+HQGSlEAOjDptnC2
 */
package net.bdsc.service.impl;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bdsc.Filter;
import net.bdsc.Order;
import net.bdsc.dao.BrandDao;
import net.bdsc.dao.ProductCategoryDao;
import net.bdsc.entity.Brand;
import net.bdsc.entity.ProductCategory;
import net.bdsc.service.BrandService;

/**
 * Service - 品牌
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class BrandServiceImpl extends BaseServiceImpl<Brand, Long> implements BrandService {

	@Inject
	private BrandDao brandDao;
	@Inject
	private ProductCategoryDao productCategoryDao;

	@Override
	@Transactional(readOnly = true)
	public List<Brand> findList(ProductCategory productCategory, Integer count, List<Filter> filters, List<Order> orders) {
		return brandDao.findList(productCategory, count, filters, orders);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "brand", condition = "#useCache")
	public List<Brand> findList(Long productCategoryId, Integer count, List<Filter> filters, List<Order> orders, boolean useCache) {
		ProductCategory productCategory = productCategoryDao.find(productCategoryId);
		if (productCategoryId != null && productCategory == null) {
			return Collections.emptyList();
		}
		return brandDao.findList(productCategory, count, filters, orders);
	}

	@Override
	@Transactional
	@CacheEvict(value = "brand", allEntries = true)
	public Brand save(Brand brand) {
		return super.save(brand);
	}

	@Override
	@Transactional
	@CacheEvict(value = "brand", allEntries = true)
	public Brand update(Brand brand) {
		return super.update(brand);
	}

	@Override
	@Transactional
	@CacheEvict(value = "brand", allEntries = true)
	public Brand update(Brand brand, String... ignoreProperties) {
		return super.update(brand, ignoreProperties);
	}

	@Override
	@Transactional
	@CacheEvict(value = "brand", allEntries = true)
	public void delete(Long id) {
		super.delete(id);
	}

	@Override
	@Transactional
	@CacheEvict(value = "brand", allEntries = true)
	public void delete(Long... ids) {
		super.delete(ids);
	}

	@Override
	@Transactional
	@CacheEvict(value = "brand", allEntries = true)
	public void delete(Brand brand) {
		super.delete(brand);
	}

}