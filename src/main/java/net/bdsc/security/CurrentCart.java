/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: roJ9br2ZIoHQHZYgZ5d0Z8VI4UP99ZRD
 */
package net.bdsc.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Security - 当前购物车注解
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.PARAMETER)
public @interface CurrentCart {

}