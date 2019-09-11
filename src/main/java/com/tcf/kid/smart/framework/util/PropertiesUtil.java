package com.tcf.kid.smart.framework.util;

import java.util.Properties;

/***
 * TODO TCF 属性配置文件工具类
 * TODO TCF 根据属性配置文件名加载属性配置文件
 * @author 71485
 *
 */
public class PropertiesUtil {

	//TODO TCF 单例模式(饿汉模式：类加载速度慢，获取对象速度快)
	private static Properties properties=new Properties();
	
	//TODO TCF 根据属性配置文件名加载属性配置文件
	public static Properties loadPropertiesFile(String propertiesFileName)
	{
		try
		{
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesFileName));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return properties;
	}
	
}
