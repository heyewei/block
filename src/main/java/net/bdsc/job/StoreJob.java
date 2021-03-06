/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 2UMK2SM8sXCz1ACLvbgNTGTGRfTZIBBV
 */
package net.bdsc.job;

import javax.inject.Inject;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.bdsc.service.StoreService;

/**
 * Job - 店铺
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Lazy(false)
@Component
public class StoreJob {

	@Inject
	private StoreService storeService;

	/**
	 * 过期店铺处理
	 */
	@Scheduled(cron = "${job.store_expired_processing.cron}")
	public void evictExpired() {
		storeService.expiredStoreProcessing();
	}

}