package com.tcf.kid.smart.framework.aop;

import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/***
 * TODO TCF AOP动态代理工厂类，根据代理目标和代理目标的所有代理实例批量创建cglib动态代理实例并启动代理实例执行链，按顺序调用每个代理实例的代理方法
 * @author 71485
 *
 */
public class ProxyManager {

	private static Logger logger=Logger.getLogger(ProxyManager.class.getName());
	
	//TODO TCF 根据代理目标和代理目标的所有代理实例批量创建cglib动态代理实例并启动代理实例执行链，按顺序调用每个代理实例的代理方法
	public static Object newProxyInstance(final Class<?> targetClass,final List<Proxy> proxyList)
	{
		Object proxy=Enhancer.create(targetClass,new MethodInterceptor() {
			
			@Override
			public Object intercept(
					                   Object targetInstance, 
					                   Method targetMethod,
					                   Object[] methodParams, 
					                   MethodProxy methodProxy
					               ) throws Throwable 
			{
				return new ProxyChain(targetClass,targetInstance,targetMethod,methodProxy,methodParams,proxyList)
						.doProxyChain();
			}
			
		});
		
		logger.info(proxy!=null?proxy.toString():"");
		
		return proxy;
	}
}
