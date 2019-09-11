package com.tcf.kid.smart.framework.model;

import java.lang.reflect.Method;

/***
 * TODO TCF 封装处理请求信息
 * @author 71485
 *
 */
public class Handle {

	//TODO TCF 处理请求控制器
	private Class<?> handleController;
	
	//TODO TCF 处理请求方法
	private Method handleMethod;
	
	public Class<?> getHandleController() {
		return handleController;
	}
	public Method getHandleMethod() {
		return handleMethod;
	}
	
	//TODO TCF 构造注入
	public Handle(Class<?> handleController,Method handleMethod)
	{
		this.handleController=handleController;
		this.handleMethod=handleMethod;
	}
	
	//TODO TCF 默认无参构造
	public Handle()
	{
		
	}
	
}
