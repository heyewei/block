/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: IpE4J5Aftzy7rrjVPnJJ0PauEaUi2lK8
 */
package net.bdsc.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.dao.BusinessCashDao;
import net.bdsc.entity.Business;
import net.bdsc.entity.BusinessCash;
import net.bdsc.entity.BusinessCash.Status;

/**
 * Dao - 商家提现
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Repository
public class BusinessCashDaoImpl extends BaseDaoImpl<BusinessCash, Long> implements BusinessCashDao {

	@Override
	public Page<BusinessCash> findPage(Status status, String bank, String account, Business business, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<BusinessCash> criteriaQuery = criteriaBuilder.createQuery(BusinessCash.class);
		Root<BusinessCash> root = criteriaQuery.from(BusinessCash.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (status != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("status"), status));
		}
		if (bank != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("bank"), bank));
		}
		if (account != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("account"), account));
		}
		if (business != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("business"), business));
		}
		criteriaQuery.where(restrictions);
		return super.findPage(criteriaQuery, pageable);
	}

	@Override
	public Long count(Status status, String bank, String account, Business business) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<BusinessCash> criteriaQuery = criteriaBuilder.createQuery(BusinessCash.class);
		Root<BusinessCash> root = criteriaQuery.from(BusinessCash.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (status != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("status"), status));
		}
		if (bank != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("bank"), bank));
		}
		if (account != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("account"), account));
		}
		if (business != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("business"), business));
		}
		criteriaQuery.where(restrictions);
		return super.count(criteriaQuery, null);
	}

}