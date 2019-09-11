package com.tcf.kid.smart.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * TODO TCF 标注控制器处理请求方法
 * @author 71485
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface KidAction {

	//TODO TCF 拦截请求路径
	String url();
	
	//TODO TCF 拦截请求方式
	String method();
	
}
