package com.tcf.kid.smart.framework.aop;

/***
 * TODO TCF AOP动态代理接口，定义每个AOP动态代理实例都需要调用的代理方法
 * @author 71485
 *
 */
public interface Proxy {
	
	//TODO TCF 代理方法
	public Object doProxy(ProxyChain proxyChain);
	
}
