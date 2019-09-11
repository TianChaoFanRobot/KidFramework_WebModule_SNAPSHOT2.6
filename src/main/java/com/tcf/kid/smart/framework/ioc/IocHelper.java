package com.tcf.kid.smart.framework.ioc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import com.tcf.kid.smart.framework.annotation.KidAspect;
import com.tcf.kid.smart.framework.annotation.KidController;
import com.tcf.kid.smart.framework.annotation.KidInject;
import com.tcf.kid.smart.framework.demo.DemoFirst;
import com.tcf.kid.smart.framework.demo.DemoSecond;
import com.tcf.kid.smart.framework.demo.DemoThird;
import com.tcf.kid.smart.framework.helper.BeanHelper;
import com.tcf.kid.smart.framework.model.Param;
import com.tcf.kid.smart.framework.util.ReflectUtil;

/***
 * TODO TCF IOC/DI依赖注入核心助手类
 * TODO TCF 初始化启动IOC/DI依赖注入容器，基于反射给目标实例的目标属性注入属性值，基于反射调用目标实例的目标方法，实现依赖注入
 * @author 71485
 *
 */
public class IocHelper {

	//TODO TCF 初始化启动IOC/DI依赖注入容器，实现依赖注入
	static
	{
		//TODO TCF 模拟实现IOC/DI依赖注入
		Map<String,Map<String,Object>> fieldMap=new HashMap<String,Map<String,Object>>();
		
		//TODO TCF 属性参数 FieldName:FieldValue
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("name","张三");
		fieldMap.put(DemoFirst.class.getSimpleName(),paramMap);
		
		paramMap=new HashMap<String,Object>();
		paramMap.put("age",18);
		fieldMap.put(DemoSecond.class.getSimpleName(),paramMap);
		
		paramMap=new HashMap<String,Object>();
		paramMap.put("demoFirst",new DemoFirst());
		paramMap.put("demoSecond",new DemoSecond());
		fieldMap.put(DemoThird.class.getSimpleName(),paramMap);
		
		//TODO TCF 启动IOC/DI依赖注入容器，实现依赖注入
		init(fieldMap);
	}
	
	//TODO TCF 启动IOC/DI依赖注入容器，基于反射给目标实例的目标属性注入属性值，基于反射调用目标实例的目标方法，实现依赖注入
	public static void init(Map<String,Map<String,Object>> fieldMap)
	{
		try
		{
			//TODO TCF 已经加载的Bean组件和Bean组件实例之间的映射关系Map
			Map<Class<?>,Object> beanMap=BeanHelper.BEAN_MAP;
			
			if(beanMap!=null)
			{
				for(Map.Entry<Class<?>,Object> beanEntry:beanMap.entrySet())
				{
					//TODO TCF Bean组件类型
					Class<?> targetClass=beanEntry.getKey();
					
					//TODO TCF Bean组件实例
					Object targetInstance=beanEntry.getValue();
					
					if(targetClass!=null && targetInstance!=null)
					{
						//TODO TCF 过滤AOP容器已经加载的切面类
						if(targetClass.isAnnotationPresent(KidAspect.class))
						{
							continue;
						}
						
						//TODO TCF Bean组件类型中定义的所有属性
						Field[] fields=targetClass.getDeclaredFields();
						
						if(fields!=null && fields.length>0)
						{
							for(Field field:fields)
							{
								//TODO TCF 自定义过滤条件过滤需要注入属性值的属性
								if(injectFieldFilter(field))
								{
									//TODO TCF 属性名
									String fieldName=field.getName();
									
									if(StringUtils.isNotEmpty(fieldName))
									{
										//TODO TCF 开始IOC/DI依赖注入
										if(fieldMap!=null)
										{
											for(Map.Entry<String,Map<String,Object>> fieldEntry:fieldMap.entrySet())
											{
												//TODO TCF 需要注入的属性所在类simpleName
												String classSimpleName=fieldEntry.getKey();
												
												//TODO TCF 需要注入的属性所在类simpleName必须和当前加载的属性所在类simpleName相同才能注入
												if(StringUtils.isNotEmpty(classSimpleName) && classSimpleName.equals(targetClass.getSimpleName()))
												{
													//TODO TCF 属性参数 FieldName:FieldValue
													Map<String,Object> paramMap=fieldEntry.getValue();
													
													if(paramMap!=null)
													{
														for(Map.Entry<String,Object> paramEntry:paramMap.entrySet())
														{
															//TODO TCF 需要注入的属性名
															String injectFieldName=paramEntry.getKey();
															
															//TODO TCF 需要注入的属性值
															Object injectFieldValue=paramEntry.getValue();
															
															//TODO TCF 需要注入的属性名必须和当前加载的属性名相同才能注入属性值
															if(StringUtils.isNotEmpty(injectFieldName) && injectFieldName.equals(fieldName))
															{
																//TODO TCF 基于反射给目标实例的目标属性注入属性值
																ReflectUtil.setField(targetInstance,field,injectFieldValue);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
						
						//TODO TCF 以下条件可以去掉，在这里的目的是只测试AOP动态代理织入增强处理执行效果
						if(targetClass.isAnnotationPresent(KidController.class))
						{
							//TODO TCF 基于反射调用目标实例的目标方法
							Method[] methods=targetClass.getDeclaredMethods();
							if(methods!=null && methods.length>0)
							{
								for(Method method:methods)
								{
									//TODO TCF 自定义过滤条件过滤需要调用的方法
									if(invokeMethodFilter(method))
									{
										//TODO TCF 方法参数
										Object[] methodParams=new Object[1];
										methodParams[0]=new Param();
										
										//TODO TCF 自定义方法参数
										
										//TODO TCF 基于反射调用目标实例的目标方法
										ReflectUtil.invokeMethod(targetInstance,method,methodParams);
									}
								}
							}
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//TODO TCF 自定义过滤条件过滤需要注入属性值的属性
	public static boolean injectFieldFilter(Field field)
	{
		boolean result=false;
		
		//TODO TCF 自定义过滤条件过滤需要注入属性值的属性
		//TODO TCF 只给使用KidInject注解标注的属性注入属性值
		if(field.isAnnotationPresent(KidInject.class))
		{
			result=true;
		}
		else
		{
			//TODO TCF ...自定义其他过滤条件过滤需要注入属性值的属性
		}
		
		return result;
	}
	
	//TODO TCF 自定义过滤条件过滤需要调用的方法
	public static boolean invokeMethodFilter(Method method)
	{
		boolean result=true;
		
		//TODO TCF ...自定义过滤条件过滤需要调用的方法
		
		return result;
	}
}
