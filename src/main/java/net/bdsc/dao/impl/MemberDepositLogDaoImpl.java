/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: LaetFP1kWmYOSj1SJWRueArGUsDIbbBe
 */
package net.bdsc.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.dao.MemberDepositLogDao;
import net.bdsc.entity.Member;
import net.bdsc.entity.MemberDepositLog;

/**
 * Dao - 会员预存款记录
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Repository
public class MemberDepositLogDaoImpl extends BaseDaoImpl<MemberDepositLog, Long> implements MemberDepositLogDao {

	@Override
	public Page<MemberDepositLog> findPage(Member member, Pageable pageable) {
		if (member == null) {
			return Page.emptyPage(pageable);
		}
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MemberDepositLog> criteriaQuery = criteriaBuilder.createQuery(MemberDepositLog.class);
		Root<MemberDepositLog> root = criteriaQuery.from(MemberDepositLog.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("member"), member));
		return super.findPage(criteriaQuery, pageable);
	}

}