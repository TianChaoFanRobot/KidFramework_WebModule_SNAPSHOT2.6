package com.tcf.kid.smart.framework.demo;

import com.tcf.kid.smart.framework.annotation.KidAspect;
import com.tcf.kid.smart.framework.annotation.KidController;
import com.tcf.kid.smart.framework.aop.ProxyAspect;

/***
 * TODO TCF 自定义AOP切面子类，继承AOP切面基类并重写各类增强处理方法
 * @author 71485
 *
 */
@KidAspect(KidController.class)
public class AspectController extends ProxyAspect{

	//TODO TCF 前置增强
	@Override
	public void before() 
	{
		super.before();
		System.out.println("===="+this.getClass().getSimpleName()+"类的前置增强处理方法执行====");
	}
	
	//TODO TCF 后置增强
	@Override
	public void afterReturning()
	{
		super.afterReturning();
		System.out.println("===="+this.getClass().getSimpleName()+"类的后置增强处理方法执行====");
	}
	
}
