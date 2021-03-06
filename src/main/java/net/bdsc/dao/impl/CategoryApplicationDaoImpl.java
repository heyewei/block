/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: nqsFAWp/hfDQeyzhNQ5K2UfinKmNKrxJ
 */
package net.bdsc.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.dao.CategoryApplicationDao;
import net.bdsc.entity.CategoryApplication;
import net.bdsc.entity.CategoryApplication.Status;
import net.bdsc.entity.ProductCategory;
import net.bdsc.entity.Store;

/**
 * Dao - 经营分类申请
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Repository
public class CategoryApplicationDaoImpl extends BaseDaoImpl<CategoryApplication, Long> implements CategoryApplicationDao {

	@Override
	public List<CategoryApplication> findList(Store store, ProductCategory productCategory, CategoryApplication.Status status) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CategoryApplication> criteriaQuery = criteriaBuilder.createQuery(CategoryApplication.class);
		Root<CategoryApplication> root = criteriaQuery.from(CategoryApplication.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (status != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("status"), status));
		}
		if (store != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("store"), store));
		}
		if (productCategory != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("productCategory"), productCategory));
		}
		criteriaQuery.where(restrictions);
		return super.findList(criteriaQuery);
	}

	@Override
	public Page<CategoryApplication> findPage(Status status, Store store, ProductCategory productCategory, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CategoryApplication> criteriaQuery = criteriaBuilder.createQuery(CategoryApplication.class);
		Root<CategoryApplication> root = criteriaQuery.from(CategoryApplication.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (status != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("status"), status));
		}
		if (store != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("store"), store));
		}
		if (productCategory != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("productCategory"), productCategory));
		}
		criteriaQuery.where(restrictions);
		return super.findPage(criteriaQuery, pageable);
	}

	@Override
	public Long count(Status status, Store store, ProductCategory productCategory) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CategoryApplication> criteriaQuery = criteriaBuilder.createQuery(CategoryApplication.class);
		Root<CategoryApplication> root = criteriaQuery.from(CategoryApplication.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (status != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("status"), status));
		}
		if (store != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("store"), store));
		}
		if (productCategory != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("productCategory"), productCategory));
		}
		criteriaQuery.where(restrictions);
		return super.count(criteriaQuery, null);
	}

}