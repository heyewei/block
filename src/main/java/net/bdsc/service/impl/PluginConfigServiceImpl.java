/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: ZAYvn1plPyeQabMIiStF5pRNCebPX3G4
 */
package net.bdsc.service.impl;

import javax.inject.Inject;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bdsc.dao.PluginConfigDao;
import net.bdsc.entity.PluginConfig;
import net.bdsc.service.PluginConfigService;

/**
 * Service - 插件配置
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class PluginConfigServiceImpl extends BaseServiceImpl<PluginConfig, Long> implements PluginConfigService {

	@Inject
	private PluginConfigDao pluginConfigDao;

	@Override
	@Transactional(readOnly = true)
	public boolean pluginIdExists(String pluginId) {
		return pluginConfigDao.exists("pluginId", pluginId);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("pluginConfig")
	public PluginConfig findByPluginId(String pluginId) {
		return pluginConfigDao.find("pluginId", pluginId);
	}

	@Override
	@CacheEvict(value = "pluginConfig", allEntries = true)
	public void deleteByPluginId(String pluginId) {
		PluginConfig pluginConfig = findByPluginId(pluginId);
		pluginConfigDao.remove(pluginConfig);
	}

	@Override
	@Transactional
	@CacheEvict(value = "pluginConfig", allEntries = true)
	public PluginConfig save(PluginConfig pluginConfig) {
		return super.save(pluginConfig);
	}

	@Override
	@Transactional
	@CacheEvict(value = "pluginConfig", allEntries = true)
	public PluginConfig update(PluginConfig pluginConfig) {
		return super.update(pluginConfig);
	}

	@Override
	@Transactional
	@CacheEvict(value = "pluginConfig", allEntries = true)
	public PluginConfig update(PluginConfig pluginConfig, String... ignoreProperties) {
		return super.update(pluginConfig, ignoreProperties);
	}

	@Override
	@Transactional
	@CacheEvict(value = "pluginConfig", allEntries = true)
	public void delete(Long id) {
		super.delete(id);
	}

	@Override
	@Transactional
	@CacheEvict(value = "pluginConfig", allEntries = true)
	public void delete(Long... ids) {
		super.delete(ids);
	}

	@Override
	@Transactional
	@CacheEvict(value = "pluginConfig", allEntries = true)
	public void delete(PluginConfig pluginConfig) {
		super.delete(pluginConfig);
	}

}