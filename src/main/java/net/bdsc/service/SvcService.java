/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: sN5gu/VMg2wgpSia9fdQALrILPdDBXoz
 */
package net.bdsc.service;

import net.bdsc.entity.Store;
import net.bdsc.entity.StoreRank;
import net.bdsc.entity.Svc;

/**
 * Service - 服务
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface SvcService extends BaseService<Svc, Long> {

	/**
	 * 根据编号查找服务
	 * 
	 * @param sn
	 *            编号(忽略大小写)
	 * @return 服务，若不存在则返回null
	 */
	Svc findBySn(String sn);

	/**
	 * 查找最新服务
	 * 
	 * @param store
	 *            店铺
	 * @param promotionPluginId
	 *            促销插件Id
	 * @param storeRank
	 *            店铺等级
	 * @return 最新服务
	 */
	Svc findTheLatest(Store store, String promotionPluginId, StoreRank storeRank);

}