/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: bxul9H0O1V+Qz0+3rGnadeLUAuJmYw9G
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
import net.bdsc.entity.Brand;
import net.bdsc.entity.Product;
import net.bdsc.entity.ProductCategory;
import net.bdsc.entity.ProductTag;
import net.bdsc.service.BrandService;
import net.bdsc.service.ProductCategoryService;
import net.bdsc.service.ProductService;
import net.bdsc.service.ProductTagService;
import net.bdsc.service.StoreService;

/**
 * Controller - 商品
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("adminProductController")
@RequestMapping("/admin/product")
public class ProductController extends BaseController {

	@Inject
	private ProductService productService;
	@Inject
	private ProductCategoryService productCategoryService;
	@Inject
	private BrandService brandService;
	@Inject
	private ProductTagService productTagService;
	@Inject
	private StoreService storeService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	public String list(Product.Type type, Long productCategoryId, Long brandId, Long productTagId, Boolean isActive, Boolean isMarketable, Boolean isList, Boolean isTop, Boolean isOutOfStock, Boolean isStockAlert, Pageable pageable, ModelMap model) {
		ProductCategory productCategory = productCategoryService.find(productCategoryId);
		Brand brand = brandService.find(brandId);
		ProductTag productTag = productTagService.find(productTagId);

		model.addAttribute("types", Product.Type.values());
		model.addAttribute("productCategoryTree", productCategoryService.findTree());
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("productTags", productTagService.findAll());
		model.addAttribute("type", type);
		model.addAttribute("productCategoryId", productCategoryId);
		model.addAttribute("brandId", brandId);
		model.addAttribute("productTagId", productTagId);
		model.addAttribute("isMarketable", isMarketable);
		model.addAttribute("isList", isList);
		model.addAttribute("isTop", isTop);
		model.addAttribute("isActive", isActive);
		model.addAttribute("isOutOfStock", isOutOfStock);
		model.addAttribute("isStockAlert", isStockAlert);
		model.addAttribute("page", productService.findPage(type, null, null, productCategory, null, brand, null, productTag, null, null, null, null, isMarketable, isList, isTop, isActive, isOutOfStock, isStockAlert, null, null, pageable));
		return "admin/product/list";
	}

	/**
	 * 删除
	 */
	@PostMapping("/delete")
	public ResponseEntity<?> delete(Long[] ids) {
		productService.delete(ids);
		return Results.OK;
	}

	/**
	 * 上架商品
	 */
	@PostMapping("/shelves")
	public ResponseEntity<?> shelves(Long[] ids) {
		if (ids != null) {
			for (Long id : ids) {
				Product product = productService.find(id);
				if (product == null) {
					return Results.UNPROCESSABLE_ENTITY;
				}
				if (!storeService.productCategoryExists(product.getStore(), product.getProductCategory())) {
					return Results.unprocessableEntity("admin.product.marketableNotExistCategoryNotAllowed", product.getName());
				}
			}
			productService.shelves(ids);
		}
		return Results.OK;
	}

	/**
	 * 下架商品
	 */
	@PostMapping("/shelf")
	public ResponseEntity<?> shelf(Long[] ids) {
		productService.shelf(ids);
		return Results.OK;
	}
}