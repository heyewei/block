/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: LzNPhb/R25trZLO5yYFfOPxq2ur7pZWL
 */
package net.bdsc.event;

import net.bdsc.entity.Cart;

/**
 * Event - 清空购物车SKU
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public class CartClearedEvent extends CartEvent {

	private static final long serialVersionUID = -5881246837387897341L;

	/**
	 * 构造方法
	 * 
	 * @param source
	 *            事件源
	 * @param cart
	 *            购物车
	 */
	public CartClearedEvent(Object source, Cart cart) {
		super(source, cart);
	}

}