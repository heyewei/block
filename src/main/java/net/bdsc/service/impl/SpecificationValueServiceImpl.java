/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: kut25Lxb31rC/nLDGXbE/+cTpDz/R5aY
 */
package net.bdsc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import net.bdsc.entity.SpecificationItem;
import net.bdsc.entity.SpecificationValue;
import net.bdsc.service.SpecificationValueService;

/**
 * Service - 规格值
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class SpecificationValueServiceImpl implements SpecificationValueService {

	@Override
	public boolean isValid(List<SpecificationItem> specificationItems, List<SpecificationValue> specificationValues) {
		Assert.notEmpty(specificationItems, "[Assertion failed] - specificationItems must not be empty: it must contain at least 1 element");
		Assert.notEmpty(specificationValues, "[Assertion failed] - specificationValues must not be empty: it must contain at least 1 element");

		if (specificationItems.size() != specificationValues.size()) {
			return false;
		}
		for (int i = 0; i < specificationValues.size(); i++) {
			SpecificationItem specificationItem = specificationItems.get(i);
			SpecificationValue specificationValue = specificationValues.get(i);
			if (specificationItem == null || specificationValue == null || !specificationItem.isValid(specificationValue)) {
				return false;
			}
		}
		return true;
	}

}