/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: liUIcXEgXCR0vdbYXrSrx1TWFPhDcB01
 */
package net.bdsc.controller.admin;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bdsc.Results;
import net.bdsc.entity.Article;
import net.bdsc.entity.ArticleCategory;
import net.bdsc.service.ArticleCategoryService;

/**
 * Controller - 文章分类
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("adminArticleCategoryController")
@RequestMapping("/admin/article_category")
public class ArticleCategoryController extends BaseController {

	@Inject
	private ArticleCategoryService articleCategoryService;

	/**
	 * 添加
	 */
	@GetMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("articleCategoryTree", articleCategoryService.findTree());
		return "admin/article_category/add";
	}

	/**
	 * 保存
	 */
	@PostMapping("/save")
	public ResponseEntity<?> save(ArticleCategory articleCategory, Long parentId) {
		articleCategory.setParent(articleCategoryService.find(parentId));
		if (!isValid(articleCategory)) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		articleCategory.setTreePath(null);
		articleCategory.setGrade(null);
		articleCategory.setChildren(null);
		articleCategory.setArticles(null);
		articleCategoryService.save(articleCategory);
		return Results.OK;
	}

	/**
	 * 编辑
	 */
	@GetMapping("/edit")
	public String edit(Long id, ModelMap model) {
		ArticleCategory articleCategory = articleCategoryService.find(id);
		model.addAttribute("articleCategoryTree", articleCategoryService.findTree());
		model.addAttribute("articleCategory", articleCategory);
		model.addAttribute("children", articleCategoryService.findChildren(articleCategory, true, null));
		return "admin/article_category/edit";
	}

	/**
	 * 更新
	 */
	@PostMapping("/update")
	public ResponseEntity<?> update(ArticleCategory articleCategory, Long parentId) {
		articleCategory.setParent(articleCategoryService.find(parentId));
		if (!isValid(articleCategory)) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		if (articleCategory.getParent() != null) {
			ArticleCategory parent = articleCategory.getParent();
			if (parent.equals(articleCategory)) {
				return Results.UNPROCESSABLE_ENTITY;
			}
			List<ArticleCategory> children = articleCategoryService.findChildren(parent, true, null);
			if (children != null && children.contains(parent)) {
				return Results.UNPROCESSABLE_ENTITY;
			}
		}
		articleCategoryService.update(articleCategory, "treePath", "grade", "children", "articles");
		return Results.OK;
	}

	/**
	 * 列表
	 */
	@GetMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("articleCategoryTree", articleCategoryService.findTree());
		return "admin/article_category/list";
	}

	/**
	 * 删除
	 */
	@PostMapping("/delete")
	public ResponseEntity<?> delete(Long id) {
		ArticleCategory articleCategory = articleCategoryService.find(id);
		if (articleCategory == null) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		Set<ArticleCategory> children = articleCategory.getChildren();
		if (children != null && !children.isEmpty()) {
			return Results.unprocessableEntity("admin.articleCategory.deleteExistChildrenNotAllowed");
		}
		Set<Article> articles = articleCategory.getArticles();
		if (articles != null && !articles.isEmpty()) {
			return Results.unprocessableEntity("admin.articleCategory.deleteExistArticleNotAllowed");
		}
		articleCategoryService.delete(id);
		return Results.OK;
	}

}