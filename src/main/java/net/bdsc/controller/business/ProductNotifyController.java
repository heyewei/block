/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: HhIXcZbG7vufwwdXSvTUruJCmUoPLOo2
 */
package net.bdsc.controller.business;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bdsc.Pageable;
import net.bdsc.Results;
import net.bdsc.entity.ProductNotify;
import net.bdsc.entity.Store;
import net.bdsc.security.CurrentStore;
import net.bdsc.service.ProductNotifyService;

/**
 * Controller - 到货通知
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("businessProductNotifyntroller")
@RequestMapping("/business/product_notify")
public class ProductNotifyController extends BaseController {

	@Inject
	private ProductNotifyService productNotifyService;

	/**
	 * 发送到货通知
	 */
	@PostMapping("/send")
	public ResponseEntity<?> send(Long[] ids, @CurrentStore Store currentStore) {
		if (ids == null) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		List<ProductNotify> productNotifies = productNotifyService.findList(ids);
		for (ProductNotify productNotify : productNotifies) {
			if (productNotify == null) {
				return Results.UNPROCESSABLE_ENTITY;
			}
			if (!currentStore.equals(productNotify.getStore())) {
				return Results.UNPROCESSABLE_ENTITY;
			}
		}
		productNotifyService.send(productNotifies);
		return Results.OK;
	}

	/**
	 * 列表
	 */
	@GetMapping("/list")
	public String list(Boolean isMarketable, Boolean isOutOfStock, Boolean hasSent, Pageable pageable, @CurrentStore Store currentStore, ModelMap model) {
		model.addAttribute("isMarketable", isMarketable);
		model.addAttribute("isOutOfStock", isOutOfStock);
		model.addAttribute("hasSent", hasSent);
		model.addAttribute("page", productNotifyService.findPage(currentStore, null, isMarketable, isOutOfStock, hasSent, pageable));
		return "business/product_notify/list";
	}

	/**
	 * 删除
	 */
	@PostMapping("/delete")
	public ResponseEntity<?> delete(Long[] ids, @CurrentStore Store currentStore) {
		if (ids == null) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		for (Long id : ids) {
			ProductNotify productNotify = productNotifyService.find(id);
			if (productNotify == null) {
				return Results.UNPROCESSABLE_ENTITY;
			}
			if (!currentStore.equals(productNotify.getStore())) {
				return Results.UNPROCESSABLE_ENTITY;
			}
			productNotifyService.delete(id);
		}
		return Results.OK;
	}

}