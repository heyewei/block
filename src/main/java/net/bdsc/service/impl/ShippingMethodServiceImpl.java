/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: dLc7DWIYdSFXcslAgdpGnadOHMB38Oqc
 */
package net.bdsc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import net.bdsc.Setting;
import net.bdsc.dao.DefaultFreightConfigDao;
import net.bdsc.entity.Area;
import net.bdsc.entity.AreaFreightConfig;
import net.bdsc.entity.DefaultFreightConfig;
import net.bdsc.entity.Receiver;
import net.bdsc.entity.ShippingMethod;
import net.bdsc.entity.Store;
import net.bdsc.service.ShippingMethodService;
import net.bdsc.util.SystemUtils;

/**
 * Service - 配送方式
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class ShippingMethodServiceImpl extends BaseServiceImpl<ShippingMethod, Long> implements ShippingMethodService {

	@Inject
	private DefaultFreightConfigDao defaultFreightConfigDao;

	@Override
	@Transactional(readOnly = true)
	public BigDecimal calculateFreight(ShippingMethod shippingMethod, Store store, Area area, Integer weight) {
		Assert.notNull(shippingMethod, "[Assertion failed] - shippingMethod is required; it must not be null");

		Setting setting = SystemUtils.getSetting();
		DefaultFreightConfig defaultFreightConfig = defaultFreightConfigDao.find(shippingMethod, store);
		BigDecimal firstPrice = defaultFreightConfig != null ? defaultFreightConfig.getFirstPrice() : BigDecimal.ZERO;
		BigDecimal continuePrice = defaultFreightConfig != null ? defaultFreightConfig.getContinuePrice() : BigDecimal.ZERO;
		Integer firstWeight = defaultFreightConfig != null ? defaultFreightConfig.getFirstWeight() : 0;
		Integer continueWeight = defaultFreightConfig != null ? defaultFreightConfig.getContinueWeight() : 1;
		if (area != null && CollectionUtils.isNotEmpty(shippingMethod.getAreaFreightConfigs())) {
			List<Area> areas = new ArrayList<>();
			areas.addAll(area.getParents());
			areas.add(area);
			for (int i = areas.size() - 1; i >= 0; i--) {
				AreaFreightConfig areaFreightConfig = shippingMethod.getAreaFreightConfig(store, areas.get(i));
				if (areaFreightConfig != null) {
					firstPrice = areaFreightConfig.getFirstPrice();
					continuePrice = areaFreightConfig.getContinuePrice();
					firstWeight = areaFreightConfig.getFirstWeight();
					continueWeight = areaFreightConfig.getContinueWeight();
					break;
				}
			}
		}
		if (weight == null || weight <= firstWeight || continuePrice.compareTo(BigDecimal.ZERO) == 0) {
			return setting.setScale(firstPrice);
		} else {
			double contiuneWeightCount = Math.ceil((weight - firstWeight) / (double) continueWeight);
			return setting.setScale(firstPrice.add(continuePrice.multiply(new BigDecimal(String.valueOf(contiuneWeightCount)))));
		}
	}

	@Override
	@Transactional(readOnly = true)
	public BigDecimal calculateFreight(ShippingMethod shippingMethod, Store store, Receiver receiver, Integer weight) {
		return calculateFreight(shippingMethod, store, receiver != null ? receiver.getArea() : null, weight);
	}

}