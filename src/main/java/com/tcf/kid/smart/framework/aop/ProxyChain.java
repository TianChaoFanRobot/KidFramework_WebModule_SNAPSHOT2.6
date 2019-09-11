package com.tcf.kid.smart.framework.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import net.sf.cglib.proxy.MethodProxy;

/***
 * TODO TCF AOP动态代理执行链
 * TODO TCF 构造注入
 * TODO TCF 定义代理实例执行链执行主体，按顺序调用每个代理实例的代理方法，使用全局静态变量记录当前调用的是第几个代理实例的代理方法
 * @author 71485
 *
 */
public class ProxyChain {

	//TODO TCF 代理目标类型
	private Class<?> targetClass;
	
	//TODO TCF 代理目标实例
	private Object targetInstance;
	
	//TODO TCF 代理目标方法
	private Method targetMethod;
	
	//TODO TCF 代理方法
	private MethodProxy methodProxy;
	
	//TODO TCF 方法参数
	private Object[] methodParams;
	
	//TODO TCF 代理实例
	private List<Proxy> proxyList=new ArrayList<Proxy>();
	
	//TODO TCF 全局静态变量，记录当前调用的是第几个代理实例的代理方法
	public static Integer executeIndex=0;
	
	public Class<?> getTargetClass() {
		return targetClass;
	}
	public Object getTargetInstance() {
		return targetInstance;
	}
	public Method getTargetMethod() {
		return targetMethod;
	}
	public MethodProxy getMethodProxy() {
		return methodProxy;
	}
	public Object[] getMethodParams() {
		return methodParams;
	}
	public List<Proxy> getProxyList() {
		return proxyList;
	}
	
	//TODO TCF 构造注入
	public ProxyChain(
			    Class<?> targetClass,
			    Object targetInstance,
			    Method targetMethod,
			    MethodProxy methodProxy,
			    Object[] methodParams,
			    List<Proxy> proxyList
			)
	{
		this.targetClass=targetClass;
		this.targetInstance=targetInstance;
		this.targetMethod=targetMethod;
		this.methodProxy=methodProxy;
		this.methodParams=methodParams;
		this.proxyList=proxyList;
	}
	
	//TODO TCF 代理实例执行链执行主体，按顺序调用每个代理实例的代理方法
	public Object doProxyChain()
	{
		Object invokeResult=null;
		
		try
		{
			if(executeIndex<proxyList.size())
			{
				invokeResult=proxyList.get(executeIndex++).doProxy(this);
			}
			else
			{
				invokeResult=methodProxy.invokeSuper(targetInstance,methodParams);
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		return invokeResult;
	}
}
