/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: kPU7oqwYlDiBp3oIes/8BZiqVMNVH03L
 */
package net.bdsc.controller.shop;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonView;

import net.bdsc.Pageable;
import net.bdsc.Results;
import net.bdsc.entity.Article;
import net.bdsc.entity.ArticleCategory;
import net.bdsc.entity.BaseEntity;
import net.bdsc.exception.ResourceNotFoundException;
import net.bdsc.service.ArticleCategoryService;
import net.bdsc.service.ArticleService;

/**
 * Controller - 文章
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("shopArticleController")
@RequestMapping("/article")
public class ArticleController extends BaseController {

	/**
	 * 每页记录数
	 */
	private static final int PAGE_SIZE = 20;

	@Inject
	private ArticleService articleService;
	@Inject
	private ArticleCategoryService articleCategoryService;

	/**
	 * 详情
	 */
	@GetMapping("/detail/{articleId}_{pageNumber}")
	public String detail(@PathVariable Long articleId, @PathVariable Integer pageNumber, ModelMap model) {
		Article article = articleService.find(articleId);
		if (article == null || pageNumber < 1 || pageNumber > article.getTotalPages()) {
			throw new ResourceNotFoundException();
		}
		model.addAttribute("article", article);
		model.addAttribute("pageNumber", pageNumber);
		return "shop/article/detail";
	}

	/**
	 * 列表
	 */
	@GetMapping("/list/{articleCategoryId}")
	public String list(@PathVariable Long articleCategoryId, Integer pageNumber, ModelMap model) {
		ArticleCategory articleCategory = articleCategoryService.find(articleCategoryId);
		if (articleCategory == null) {
			throw new ResourceNotFoundException();
		}
		Pageable pageable = new Pageable(pageNumber, PAGE_SIZE);
		model.addAttribute("articleCategory", articleCategory);
		model.addAttribute("page", articleService.findPage(articleCategory, null, true, pageable));
		return "shop/article/list";
	}

	/**
	 * 列表
	 */
	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(BaseEntity.BaseView.class)
	public ResponseEntity<?> list(Long articleCategoryId, Integer pageNumber) {
		ArticleCategory articleCategory = articleCategoryService.find(articleCategoryId);
		if (articleCategory == null) {
			return Results.NOT_FOUND;
		}

		Pageable pageable = new Pageable(pageNumber, PAGE_SIZE);
		return ResponseEntity.ok(articleService.findPage(articleCategory, null, true, pageable).getContent());
	}

	/**
	 * 搜索
	 */
	@GetMapping("/search")
	public String search(String keyword, Integer pageNumber, ModelMap model) {
		if (StringUtils.isEmpty(keyword)) {
			return UNPROCESSABLE_ENTITY_VIEW;
		}
		Pageable pageable = new Pageable(pageNumber, PAGE_SIZE);
		model.addAttribute("articleKeyword", keyword);
		model.addAttribute("page", articleService.search(keyword, pageable));
		return "shop/article/search";
	}

	/**
	 * 搜索
	 */
	@GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(BaseEntity.BaseView.class)
	public ResponseEntity<?> search(String keyword, Integer pageNumber) {
		if (StringUtils.isEmpty(keyword)) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		Pageable pageable = new Pageable(pageNumber, PAGE_SIZE);
		return ResponseEntity.ok(articleService.search(keyword, pageable).getContent());
	}

	/**
	 * 点击数
	 */
	@GetMapping("/hits/{articleId}")
	public ResponseEntity<?> hits(@PathVariable Long articleId) {
		if (articleId == null) {
			return Results.UNPROCESSABLE_ENTITY;
		}

		Map<String, Object> data = new HashMap<>();
		data.put("hits", articleService.viewHits(articleId));
		return ResponseEntity.ok(data);
	}

}