/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: GJiTwu3ZHoQ3+Ef4guoWuZl1OKJzRUTP
 */
package net.bdsc.controller.admin.plugin;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bdsc.Results;
import net.bdsc.controller.admin.BaseController;
import net.bdsc.entity.PluginConfig;
import net.bdsc.plugin.LocalStoragePlugin;
import net.bdsc.service.PluginConfigService;

/**
 * Controller - 本地文件存储
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("adminPluginLocalStorageController")
@RequestMapping("/admin/plugin/local_storage")
public class LocalStorageController extends BaseController {

	@Inject
	private LocalStoragePlugin localStoragePlugin;
	@Inject
	private PluginConfigService pluginConfigService;

	/**
	 * 设置
	 */
	@GetMapping("/setting")
	public String setting(ModelMap model) {
		PluginConfig pluginConfig = localStoragePlugin.getPluginConfig();
		model.addAttribute("pluginConfig", pluginConfig);
		return "/admin/plugin/local_storage/setting";
	}

	/**
	 * 更新
	 */
	@PostMapping("/update")
	public ResponseEntity<?> update(Integer order) {
		PluginConfig pluginConfig = localStoragePlugin.getPluginConfig();
		pluginConfig.setIsEnabled(true);
		pluginConfig.setOrder(order);
		pluginConfigService.update(pluginConfig);
		return Results.OK;
	}

}