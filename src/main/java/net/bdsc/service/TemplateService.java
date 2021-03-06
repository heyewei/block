/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: KWISmKkx6Ow1nPNj51TjC4OIASlYokl6
 */
package net.bdsc.service;

import net.bdsc.TemplateConfig;

/**
 * Service - 模板
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface TemplateService {

	/**
	 * 读取模板文件内容
	 * 
	 * @param templateConfigId
	 *            模板配置ID
	 * @return 模板文件内容
	 */
	String read(String templateConfigId);

	/**
	 * 读取模板文件内容
	 * 
	 * @param templateConfig
	 *            模板配置
	 * @return 模板文件内容
	 */
	String read(TemplateConfig templateConfig);

	/**
	 * 写入模板文件内容
	 * 
	 * @param templateConfigId
	 *            模板配置ID
	 * @param content
	 *            模板文件内容
	 */
	void write(String templateConfigId, String content);

	/**
	 * 写入模板文件内容
	 * 
	 * @param templateConfig
	 *            模板配置
	 * @param content
	 *            模板文件内容
	 */
	void write(TemplateConfig templateConfig, String content);

}