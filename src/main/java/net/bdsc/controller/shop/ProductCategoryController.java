/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: mFgPu27MEMKx2FdJguKD8D8/mA79BmNG
 */
package net.bdsc.controller.shop;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bdsc.service.ProductCategoryService;

/**
 * Controller - 商品分类
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("shopProductCategoryController")
@RequestMapping("/product_category")
public class ProductCategoryController extends BaseController {

	@Inject
	private ProductCategoryService productCategoryService;

	/**
	 * 首页
	 */
	@GetMapping
	public String index(ModelMap model) {
		model.addAttribute("rootProductCategories", productCategoryService.findRoots());
		return "shop/product_category/index";
	}

}