/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: xAQrkEKVubkLZfvYQtFRWEsAgDaFjgmZ
 */
package net.bdsc.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import net.bdsc.entity.Aftersales;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import net.bdsc.Filter;
import net.bdsc.Order;
import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.dao.ArticleDao;
import net.bdsc.entity.Article;
import net.bdsc.entity.ArticleCategory;
import net.bdsc.entity.ArticleTag;

/**
 * Dao - 文章
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Repository
public class ArticleDaoImpl extends BaseDaoImpl<Article, Long> implements ArticleDao {

	@Override
	public List<Article> findList(ArticleCategory articleCategory, ArticleTag articleTag, Boolean isPublication, Integer count, List<Filter> filters, List<Order> orders) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Article> criteriaQuery = criteriaBuilder.createQuery(Article.class);
		Root<Article> root = criteriaQuery.from(Article.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (articleCategory != null) {
			Subquery<ArticleCategory> subquery = criteriaQuery.subquery(ArticleCategory.class);
			Root<ArticleCategory> subqueryRoot = subquery.from(ArticleCategory.class);
			subquery.select(subqueryRoot);
			subquery.where(criteriaBuilder.or(criteriaBuilder.equal(subqueryRoot, articleCategory), criteriaBuilder.like(subqueryRoot.<String>get("treePath"), "%" + ArticleCategory.TREE_PATH_SEPARATOR + articleCategory.getId() + ArticleCategory.TREE_PATH_SEPARATOR + "%")));
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.in(root.get("articleCategory")).value(subquery));
		}
		if (articleTag != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.join("articleTags"), articleTag));
		}
		if (isPublication != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("isPublication"), isPublication));
		}
		criteriaQuery.where(restrictions);
		if (orders == null || orders.isEmpty()) {
			criteriaQuery.orderBy(criteriaBuilder.desc(root.get("isTop")), criteriaBuilder.desc(root.get("createdDate")));
		}
		return super.findList(criteriaQuery, null, count, filters, orders);
	}

	@Override
	public List<Article> findList(ArticleCategory articleCategory, Boolean isPublication, Date beginDate, Date endDate, Integer first, Integer count) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Article> criteriaQuery = criteriaBuilder.createQuery(Article.class);
		Root<Article> root = criteriaQuery.from(Article.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (articleCategory != null) {
			Subquery<ArticleCategory> subquery = criteriaQuery.subquery(ArticleCategory.class);
			Root<ArticleCategory> subqueryRoot = subquery.from(ArticleCategory.class);
			subquery.select(subqueryRoot);
			subquery.where(criteriaBuilder.or(criteriaBuilder.equal(subqueryRoot, articleCategory), criteriaBuilder.like(subqueryRoot.<String>get("treePath"), "%" + ArticleCategory.TREE_PATH_SEPARATOR + articleCategory.getId() + ArticleCategory.TREE_PATH_SEPARATOR + "%")));
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.in(root.get("articleCategory")).value(subquery));
		}
		if (isPublication != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("isPublication"), isPublication));
		}
		if (beginDate != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.greaterThanOrEqualTo(root.<Date>get("createdDate"), beginDate));
		}
		if (endDate != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.lessThanOrEqualTo(root.<Date>get("createdDate"), endDate));
		}
		criteriaQuery.where(restrictions);
		return super.findList(criteriaQuery, first, count);
	}

	@Override
	public Page<Article> findPage(ArticleCategory articleCategory, ArticleTag articleTag, Boolean isPublication, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Article> criteriaQuery = criteriaBuilder.createQuery(Article.class);
		Root<Article> root = criteriaQuery.from(Article.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (articleCategory != null) {
			Subquery<ArticleCategory> subquery = criteriaQuery.subquery(ArticleCategory.class);
			Root<ArticleCategory> subqueryRoot = subquery.from(ArticleCategory.class);
			subquery.select(subqueryRoot);
			subquery.where(criteriaBuilder.or(criteriaBuilder.equal(subqueryRoot, articleCategory), criteriaBuilder.like(subqueryRoot.<String>get("treePath"), "%" + ArticleCategory.TREE_PATH_SEPARATOR + articleCategory.getId() + ArticleCategory.TREE_PATH_SEPARATOR + "%")));
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.in(root.get("articleCategory")).value(subquery));
		}
		if (articleTag != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.join("articleTags"), articleTag));
		}
		if (isPublication != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("isPublication"), isPublication));
		}
		criteriaQuery.where(restrictions);
		if (pageable == null || ((StringUtils.isEmpty(pageable.getOrderProperty()) || pageable.getOrderDirection() == null) && CollectionUtils.isEmpty(pageable.getOrders()))) {
			criteriaQuery.orderBy(criteriaBuilder.desc(root.get("isTop")), criteriaBuilder.desc(root.get("createdDate")));
		}
		return super.findPage(criteriaQuery, pageable);
	}

    @Override
    public Article findLastest() {
		String jpql = "select article from Article article order by article.createdDate desc";
		TypedQuery<Article> query = entityManager.createQuery(jpql, Article.class);
		return query.getResultList().get(0);

    }

}