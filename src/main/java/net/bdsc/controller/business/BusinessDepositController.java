/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 2A+Y6f4ynBYAMJVzid2+N3obR4IxFCOr
 */
package net.bdsc.controller.business;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.bdsc.Pageable;
import net.bdsc.Results;
import net.bdsc.entity.Business;
import net.bdsc.plugin.PaymentPlugin;
import net.bdsc.security.CurrentUser;
import net.bdsc.service.BusinessDepositLogService;
import net.bdsc.service.PluginService;
import net.bdsc.util.WebUtils;

/**
 * Controller - 预存款
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("businessDepositController")
@RequestMapping("/business/business_deposit")
public class BusinessDepositController extends BaseController {

	@Inject
	private BusinessDepositLogService businessDepositLogService;
	@Inject
	private PluginService pluginService;

	/**
	 * 计算
	 */
	@GetMapping("/calculate")
	public ResponseEntity<?> calculate(String paymentPluginId, BigDecimal rechargeAmount) {
		Map<String, Object> data = new HashMap<>();
		PaymentPlugin paymentPlugin = pluginService.getPaymentPlugin(paymentPluginId);
		if (paymentPlugin == null || !paymentPlugin.getIsEnabled()) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		if (rechargeAmount == null || rechargeAmount.compareTo(BigDecimal.ZERO) <= 0) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		data.put("fee", paymentPlugin.calculateFee(rechargeAmount));
		return ResponseEntity.ok(data);
	}

	/**
	 * 检查余额
	 */
	@PostMapping("/check_balance")
	public @ResponseBody Map<String, Object> checkBalance(@CurrentUser Business currenUser) {
		Map<String, Object> data = new HashMap<>();
		data.put("balance", currenUser.getBalance());
		return data;
	}

	/**
	 * 充值
	 */
	@GetMapping("/recharge")
	public String recharge(ModelMap model) {
		List<PaymentPlugin> paymentPlugins = pluginService.getActivePaymentPlugins(WebUtils.getRequest());
		if (!paymentPlugins.isEmpty()) {
			model.addAttribute("defaultPaymentPlugin", paymentPlugins.get(0));
			model.addAttribute("paymentPlugins", paymentPlugins);
		}
		return "business/business_deposit/recharge";
	}

	/**
	 * 记录
	 */
	@GetMapping("/log")
	public String log(Pageable pageable, @CurrentUser Business currenUser, ModelMap model) {
		model.addAttribute("page", businessDepositLogService.findPage(currenUser, pageable));
		return "business/business_deposit/log";
	}

}