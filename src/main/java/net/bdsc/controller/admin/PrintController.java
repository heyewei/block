/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: P1h6fH3P1Bslcknbo+iE85GKgLo/y5du
 */
package net.bdsc.controller.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bdsc.service.OrderService;

/**
 * Controller - 打印
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("adminPrintController")
@RequestMapping("/admin/print")
public class PrintController extends BaseController {

	@Inject
	private OrderService orderService;

	/**
	 * 订单打印
	 */
	@GetMapping("/order")
	public String order(Long id, ModelMap model) {
		model.addAttribute("order", orderService.find(id));
		return "admin/print/order";
	}

}