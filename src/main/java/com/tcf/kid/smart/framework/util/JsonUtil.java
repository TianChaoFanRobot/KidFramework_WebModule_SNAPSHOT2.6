package com.tcf.kid.smart.framework.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/***
 * TODO TCF JSON序列化和反序列化工具类
 * @author 71485
 *
 */
public class JsonUtil {
	
	//TODO TCF Mapping Jackson JSON序列化和反序列化核心处理器ObjectMapper
	private static ObjectMapper OBJECT_MAPPER=new ObjectMapper();
	
	//TODO TCF JSON序列化
	public static String pojoToJson(Object obj)
	{
		String jsonString="";
		
		try
		{
			jsonString=OBJECT_MAPPER.writeValueAsString(obj);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	//TODO TCF JSON反序列化
	public static Object jsonToPojo(String jsonString,Class<?> pojoClass)
	{
		Object obj=null;
		
		try
		{
			obj=OBJECT_MAPPER.readValue(jsonString,pojoClass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return obj;
	}
}
