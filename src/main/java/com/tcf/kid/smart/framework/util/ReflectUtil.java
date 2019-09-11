package com.tcf.kid.smart.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/***
 * TODO TCF 反射工具类
 * TODO TCF 基于反射创建指定类型实例
 * TODO TCF 基于反射给目标实例的目标属性注入属性值
 * TODO TCF 基于反射调用目标实例的目标方法
 * @author 71485
 *
 */
public class ReflectUtil {

	//TODO TCF 基于反射创建指定类型实例
	public static Object newInstance(Class<?> targetClass)
	{
		Object instance=null;
		
		try
		{
			instance=targetClass.newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return instance;
	}
	
	//TODO TCF 基于反射给目标实例的目标属性注入属性值
	public static void setField(Object targetInstance,Field field,Object fieldValue)
	{
		try
		{
			field.setAccessible(true);
			field.set(targetInstance,fieldValue);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//TODO TCF 基于反射调用目标实例的目标方法
	public static Object invokeMethod(Object targetInstance,Method targetMethod,Object...methodParams)
	{
		Object invokeResult=null;
		
		try
		{
			invokeResult=targetMethod.invoke(targetInstance,methodParams);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return invokeResult;
	}
}
