/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: WEPC5daLb1hVyw/q8ER6ZP6Y+X8taY32
 */
package net.bdsc.controller.admin;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bdsc.Pageable;
import net.bdsc.Results;
import net.bdsc.service.OrderRefundsService;

/**
 * Controller - 订单退款
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("adminOrderRefundsController")
@RequestMapping("/admin/order_refunds")
public class OrderRefundsController extends BaseController {

	@Inject
	private OrderRefundsService orderRefundsService;

	/**
	 * 查看
	 */
	@GetMapping("/view")
	public String view(Long id, ModelMap model) {
		model.addAttribute("refunds", orderRefundsService.find(id));
		return "admin/order_refunds/view";
	}

	/**
	 * 列表
	 */
	@GetMapping("/list")
	public String list(Pageable pageable, ModelMap model) {
		model.addAttribute("page", orderRefundsService.findPage(pageable));
		return "admin/order_refunds/list";
	}

	/**
	 * 删除
	 */
	@PostMapping("/delete")
	public ResponseEntity<?> delete(Long[] ids) {
		orderRefundsService.delete(ids);
		return Results.OK;
	}

}