/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: /VBoaBLG5Lyq8PkOBowhIgl+KSB4omIV
 */
package net.bdsc.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import net.bdsc.Filter;
import net.bdsc.Order;
import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.dao.ProductFavoriteDao;
import net.bdsc.entity.Member;
import net.bdsc.entity.Product;
import net.bdsc.entity.ProductFavorite;

/**
 * Dao - 商品收藏
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Repository
public class ProductFavoriteDaoImpl extends BaseDaoImpl<ProductFavorite, Long> implements ProductFavoriteDao {

	@Override
	public boolean exists(Member member, Product product) {
		String jpql = "select count(*) from ProductFavorite productFavorite where productFavorite.member = :member and productFavorite.product = :product";
		Long count = entityManager.createQuery(jpql, Long.class).setParameter("member", member).setParameter("product", product).getSingleResult();
		return count > 0;
	}

	@Override
	public List<ProductFavorite> findList(Member member, Integer count, List<Filter> filters, List<Order> orders) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProductFavorite> criteriaQuery = criteriaBuilder.createQuery(ProductFavorite.class);
		Root<ProductFavorite> root = criteriaQuery.from(ProductFavorite.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (member != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("member"), member));
		}
		criteriaQuery.where(restrictions);
		return super.findList(criteriaQuery, null, count, filters, orders);
	}

	@Override
	public Page<ProductFavorite> findPage(Member member, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProductFavorite> criteriaQuery = criteriaBuilder.createQuery(ProductFavorite.class);
		Root<ProductFavorite> root = criteriaQuery.from(ProductFavorite.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (member != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("member"), member));
		}
		criteriaQuery.where(restrictions);
		return super.findPage(criteriaQuery, pageable);
	}

	@Override
	public Long count(Member member) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProductFavorite> criteriaQuery = criteriaBuilder.createQuery(ProductFavorite.class);
		Root<ProductFavorite> root = criteriaQuery.from(ProductFavorite.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (member != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("member"), member));
		}
		criteriaQuery.where(restrictions);
		return super.count(criteriaQuery);
	}

}