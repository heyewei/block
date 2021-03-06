/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: iXhPYTvxRIcqK3Wdo9VAJUjpKeOwEr/3
 */
package net.bdsc.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.dao.PointLogDao;
import net.bdsc.entity.Member;
import net.bdsc.entity.PointLog;

/**
 * Dao - 积分记录
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Repository
public class PointLogDaoImpl extends BaseDaoImpl<PointLog, Long> implements PointLogDao {

	@Override
	public Page<PointLog> findPage(Member member, Pageable pageable) {
		if (member == null) {
			return Page.emptyPage(pageable);
		}
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PointLog> criteriaQuery = criteriaBuilder.createQuery(PointLog.class);
		Root<PointLog> root = criteriaQuery.from(PointLog.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("member"), member));
		return super.findPage(criteriaQuery, pageable);
	}

}