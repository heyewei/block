/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: p23bon8B2RydpTLVqqhKq4q9UyyTVmSh
 */
package net.bdsc.controller.member;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonView;

import net.bdsc.Pageable;
import net.bdsc.entity.BaseEntity;
import net.bdsc.entity.Distributor;
import net.bdsc.entity.Member;
import net.bdsc.exception.UnauthorizedException;
import net.bdsc.security.CurrentUser;
import net.bdsc.service.DistributionCommissionService;

/**
 * Controller - 分销佣金
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("memberDistributionCommissionController")
@RequestMapping("/member/distribution_commission")
public class DistributionCommissionController extends BaseController {

	/**
	 * 每页记录数
	 */
	private static final int PAGE_SIZE = 10;

	@Inject
	private DistributionCommissionService distributionCommissionService;

	/**
	 * 添加属性
	 */
	@ModelAttribute
	public void populateModel(@CurrentUser Member currentUser, ModelMap model) {
		if (!currentUser.getIsDistributor()) {
			throw new UnauthorizedException();
		}
		model.addAttribute("distributor", currentUser.getDistributor());
	}

	/**
	 * 列表
	 */
	@GetMapping("/list")
	public String list(Pageable pageable, @ModelAttribute(binding = false) Distributor distributor, ModelMap model) {
		model.addAttribute("page", distributionCommissionService.findPage(distributor, pageable));
		return "member/distribution_commission/list";
	}

	/**
	 * 列表
	 */
	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(BaseEntity.BaseView.class)
	public ResponseEntity<?> list(Integer pageNumber, @ModelAttribute(binding = false) Distributor distributor) {
		Pageable pageable = new Pageable(pageNumber, PAGE_SIZE);
		return ResponseEntity.ok(distributionCommissionService.findPage(distributor, pageable).getContent());
	}

}