/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: gtKrKIutYl/J23XLImivaQOZcyhpeCig
 */
package net.bdsc.controller.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.bdsc.Pageable;
import net.bdsc.Results;
import net.bdsc.entity.Business;
import net.bdsc.entity.Sku;
import net.bdsc.entity.StockLog;
import net.bdsc.entity.Store;
import net.bdsc.exception.UnauthorizedException;
import net.bdsc.security.CurrentStore;
import net.bdsc.security.CurrentUser;
import net.bdsc.service.SkuService;
import net.bdsc.service.StockLogService;

/**
 * Controller - 库存
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("businessStockController")
@RequestMapping("/business/stock")
public class StockController extends BaseController {

	@Inject
	private StockLogService stockLogService;
	@Inject
	private SkuService skuService;

	/**
	 * 添加属性
	 */
	@ModelAttribute
	public void populateModel(String skuSn, @CurrentStore Store currentStore, ModelMap model) {
		Sku sku = skuService.findBySn(skuSn);
		if (sku != null && !currentStore.equals(sku.getStore())) {
			throw new UnauthorizedException();
		}
		model.addAttribute("sku", sku);
	}

	/**
	 * SKU选择
	 */
	@GetMapping("/sku_select")
	public @ResponseBody List<Map<String, Object>> skuSelect(String keyword, @CurrentUser Business currentUser) {
		List<Map<String, Object>> data = new ArrayList<>();
		if (StringUtils.isEmpty(keyword)) {
			return data;
		}
		List<Sku> skus = skuService.search(currentUser.getStore(), null, keyword, null, null);
		for (Sku sku : skus) {
			Map<String, Object> item = new HashMap<>();
			item.put("sn", sku.getSn());
			item.put("name", sku.getName());
			item.put("stock", sku.getStock());
			item.put("allocatedStock", sku.getAllocatedStock());
			item.put("specifications", sku.getSpecifications());
			data.add(item);
		}
		return data;
	}

	/**
	 * 入库
	 */
	@GetMapping("/stock_in")
	public String stockIn(Sku sku, ModelMap model) {
		model.addAttribute("sku", sku);
		return "business/stock/stock_in";
	}

	/**
	 * 入库
	 */
	@PostMapping("/stock_in")
	public ResponseEntity<?> stockIn(Sku sku, Integer quantity, String memo) {
		if (sku == null) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		if (quantity == null || quantity <= 0) {
			return Results.UNPROCESSABLE_ENTITY;
		}

		skuService.addStock(sku, quantity, StockLog.Type.STOCK_IN, memo);

		return Results.OK;
	}

	/**
	 * 出库
	 */
	@GetMapping("/stock_out")
	public String stockOut(Sku sku, ModelMap model) {
		model.addAttribute("sku", sku);
		return "business/stock/stock_out";
	}

	/**
	 * 出库
	 */
	@PostMapping("/stock_out")
	public ResponseEntity<?> stockOut(Sku sku, Integer quantity, String memo) {
		if (sku == null) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		if (quantity == null || quantity <= 0) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		if (sku.getStock() - quantity < 0) {
			return Results.UNPROCESSABLE_ENTITY;
		}

		skuService.addStock(sku, -quantity, StockLog.Type.STOCK_OUT, memo);

		return Results.OK;
	}

	/**
	 * 记录
	 */
	@GetMapping("/log")
	public String log(Pageable pageable, @CurrentUser Business currentUser, ModelMap model) {
		model.addAttribute("page", stockLogService.findPage(currentUser.getStore(), pageable));
		return "business/stock/log";
	}

}