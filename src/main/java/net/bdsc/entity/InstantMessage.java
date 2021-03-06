/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: Vteal2hTAXm5IpWlu6a70yPj6mmkaiMW
 */
package net.bdsc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity - 即时通讯
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Entity
public class InstantMessage extends OrderedEntity<Long> {

	private static final long serialVersionUID = 163292786603104144L;

	/**
	 * 类型
	 */
	public enum Type {

		/**
		 * QQ
		 */
		QQ,

		/**
		 * 阿里旺旺
		 */
		ALI_TALK
	}

	/**
	 * 名称
	 */
	@NotEmpty
	@Length(max = 200)
	@Column(nullable = false)
	private String name;

	/**
	 * 类型
	 */
	@NotNull
	@Column(nullable = false)
	private InstantMessage.Type type;

	/**
	 * 账号
	 */
	@NotNull
	@Length(max = 200)
	@Column(nullable = false)
	private String account;

	/**
	 * 店铺
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Store store;

	/**
	 * 获取名称
	 * 
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 * 
	 * @param name
	 *            名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取类型
	 * 
	 * @return 类型
	 */
	public InstantMessage.Type getType() {
		return type;
	}

	/**
	 * 设置类型
	 * 
	 * @param type
	 *            类型
	 */
	public void setType(InstantMessage.Type type) {
		this.type = type;
	}

	/**
	 * 获取账号
	 * 
	 * @return 账号
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 设置账号
	 * 
	 * @param account
	 *            账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * 获取店铺
	 * 
	 * @return 店铺
	 */
	public Store getStore() {
		return store;
	}

	/**
	 * 设置店铺
	 * 
	 * @param store
	 *            店铺
	 */
	public void setStore(Store store) {
		this.store = store;
	}

}