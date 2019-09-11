package com.tcf.kid.smart.framework.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.tcf.kid.smart.framework.util.ReflectUtil;

/***
 * TODO TCF Bean组件和Bean组件实例之间的映射关系Map助手类
 * TODO TCF 初始化加载Bean组件和Bean组件实例之间的映射关系Map
 * TODO TCF 根据Bean组件类型获取Bean组件实例
 * TODO TCF 往Bean组件和Bean组件实例映射关系Map中存入新的映射关系
 * @author 71485
 *
 */
public class BeanHelper {

	//TODO TCF 全局Bean组件和Bean组件实例之间的映射关系Map
	public static Map<Class<?>,Object> BEAN_MAP=new HashMap<Class<?>,Object>();
	
	//TODO TCF 初始化加载Bean组件和Bean组件实例之间的映射关系Map
	static
	{
		//TODO TCF 已经加载的基准包及其子包中的类
		Set<Class<?>> classList=ClassHelper.CLASS_LIST;
		
		if(classList!=null && classList.size()>0)
		{
			for(Class<?> targetClass:classList)
			{
				Object targetInstance=ReflectUtil.newInstance(targetClass);
				BEAN_MAP.put(targetClass,targetInstance);
			}
		}
	}
	
	//TODO TCF 根据Bean组件类型加载Bean组件实例
	public static Object getBeanInstance(Class<?> targetClass)
	{
		return BEAN_MAP.get(targetClass);
	}
	
	//TODO TCF 往Bean组件和Bean组件实例映射关系Map中存入新的映射关系
	public static void putBeanMapping(Class<?> targetClass,Object targetInstance)
	{
		BEAN_MAP.put(targetClass,targetInstance);
	}
}
