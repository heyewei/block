/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: KHriKg7cc2Q8d5+C2u1P/72uDglTAkqE
 */
package net.bdsc.job;

import java.util.Calendar;

import javax.inject.Inject;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.bdsc.service.StatisticService;

/**
 * Job - 统计
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Lazy(false)
@Component
public class StatisticJob {

	@Inject
	private StatisticService statisticService;

	/**
	 * 收集
	 */
	@Scheduled(cron = "${job.statistic_collect.cron}")
	public void collect() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		statisticService.collect(year, month, day);
	}
}