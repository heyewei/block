/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: gIjg4He5bh1GomBTuSU6OK58aoDroniZ
 */
package net.bdsc.service.impl;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.dao.BusinessCashDao;
import net.bdsc.dao.BusinessDao;
import net.bdsc.entity.Business;
import net.bdsc.entity.BusinessCash;
import net.bdsc.entity.BusinessCash.Status;
import net.bdsc.entity.BusinessDepositLog;
import net.bdsc.service.BusinessCashService;
import net.bdsc.service.BusinessService;

/**
 * Service - 商家提现
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class BusinessCashServiceImpl extends BaseServiceImpl<BusinessCash, Long> implements BusinessCashService {

	@Inject
	private BusinessCashDao businessCashDao;
	@Inject
	private BusinessDao businessDao;
	@Inject
	private BusinessService businessService;

	@Override
	@Transactional(readOnly = true)
	public Page<BusinessCash> findPage(Status status, String bank, String account, Business business, Pageable pageable) {
		return businessCashDao.findPage(status, bank, account, business, pageable);
	}

	@Override
	public void applyCash(BusinessCash businessCash, Business business) {
		Assert.notNull(businessCash, "[Assertion failed] - businessCash is required; it must not be null");
		Assert.notNull(business, "[Assertion failed] - business is required; it must not be null");
		Assert.isTrue(businessCash.getAmount().compareTo(BigDecimal.ZERO) > 0, "[Assertion failed] - businessCash amount must be greater than 0");

		businessCash.setStatus(BusinessCash.Status.PENDING);
		businessCash.setBusiness(business);
		businessCashDao.persist(businessCash);

		businessService.addFrozenAmount(business, businessCash.getAmount());

	}

	@Override
	public void review(BusinessCash businessCash, Boolean isPassed) {
		Assert.notNull(businessCash, "[Assertion failed] - businessCash is required; it must not be null");
		Assert.notNull(isPassed, "[Assertion failed] - isPassed is required; it must not be null");

		Business business = businessCash.getBusiness();
		if (isPassed) {
			Assert.notNull(businessCash.getAmount(), "[Assertion failed] - businessCash amount is required; it must not be null");
			Assert.notNull(businessCash.getBusiness(), "[Assertion failed] - businessCash business is required; it must not be null");
			businessCash.setStatus(BusinessCash.Status.APPROVED);
			businessService.addBalance(businessCash.getBusiness(), businessCash.getAmount().negate(), BusinessDepositLog.Type.CASH, null);
		} else {
			businessCash.setStatus(BusinessCash.Status.FAILED);
		}
		businessService.addFrozenAmount(business, businessCash.getAmount().negate());
	}

	@Override
	@Transactional(readOnly = true)
	public Long count(Business business, BusinessCash.Status status, String bank, String account) {
		return businessCashDao.count(status, bank, account, business);
	}

	@Override
	public Long count(Long businessId, Status status, String bank, String account) {
		Business business = businessDao.find(businessId);
		if (businessId != null && business == null) {
			return 0L;
		}

		return businessCashDao.count(status, bank, account, business);
	}

}