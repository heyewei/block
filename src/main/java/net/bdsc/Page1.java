/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: NKXbIa+kM4PwgHlk+HKlrHuIPBF5Faei
 */
package net.bdsc;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 分页
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public class Page1<T> implements Serializable {

	private static final long serialVersionUID = -2053800594583879853L;

	/**
	 * 内容
	 */
	private final List<T> list = new ArrayList<>();

	/**
	 * 总记录数
	 */
	private final long totalRow;


	/**
	 * 分页信息
	 */
	private final Pageable pageable;

	/**
	 * 构造方法
	 */
	public Page1() {
		this.totalRow = 0L;
		this.pageable = new Pageable();
	}

	/**
	 * 构造方法
	 *
	 * @param content
	 *            内容
	 * @param total
	 *            总记录数
	 * @param pageable
	 *            分页信息
	 */
	public Page1(List<T> content, long total, Pageable pageable) {
		this.list.addAll(content);
		this.totalRow = total;
		this.pageable = pageable;
	}

	/**
	 * 获取页码
	 * 
	 * @return 页码
	 */
	public int getPage() {
		return pageable.getPageNumber();
	}

	/**
	 * 获取每页记录数
	 * 
	 * @return 每页记录数
	 */
	public int getSize() {
		return pageable.getPageSize();
	}

	/**
	 * 获取搜索属性
	 * 
	 * @return 搜索属性
	 */
	public String getSearchProperty() {
		return pageable.getSearchProperty();
	}

	/**
	 * 获取搜索值
	 * 
	 * @return 搜索值
	 */
	public String getSearchValue() {
		return pageable.getSearchValue();
	}

	/**
	 * 获取排序属性
	 * 
	 * @return 排序属性
	 */
	public String getOrderProperty() {
		return pageable.getOrderProperty();
	}

	/**
	 * 获取排序方向
	 * 
	 * @return 排序方向
	 */
	public Order.Direction getOrderDirection() {
		return pageable.getOrderDirection();
	}

	/**
	 * 获取排序
	 * 
	 * @return 排序
	 */
	public List<Order> getOrders() {
		return pageable.getOrders();
	}

	/**
	 * 获取筛选
	 * 
	 * @return 筛选
	 */
	public List<Filter> getFilters() {
		return pageable.getFilters();
	}

	/**
	 * 获取总页数
	 * 
	 * @return 总页数
	 */
	public int getTotalPage() {
		return (int) Math.ceil((double) getTotalRow() / (double) getSize());
	}

	/**
	 * 获取内容
	 * 
	 * @return 内容
	 */
	public List<T> getContent() {
		return list;
	}

	/**
	 * 获取总记录数
	 * 
	 * @return 总记录数
	 */
	public long getTotalRow() {
		return totalRow;
	}

	/**
	 * 获取分页信息
	 * 
	 * @return 分页信息
	 */
	public Pageable getPageable() {
		return pageable;
	}

	/**
	 * 获取空分页
	 * 
	 * @param pageable
	 *            分页信息
	 * @return 空分页
	 */
	public static final <T> Page1<T> emptyPage(Pageable pageable) {
		return new Page1<>(Collections.<T>emptyList(), 0L, pageable);
	}

	/**
	 * 重写equals方法
	 * 
	 * @param obj
	 *            对象
	 * @return 是否相等
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * 重写hashCode方法
	 * 
	 * @return HashCode
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}