package com.tcf.kid.smart.framework.model;

import java.util.Map;

/***
 * TODO TCF 请求参数信息
 * @author 71485
 *
 */
public class Param {

	//TODO TCF 请求参数 ParameterName:ParameterValue
	private Map<String,Object> paramMap;
	
	public Map<String, Object> getParamMap() {
		return paramMap;
	}
	
	//TODO TCF 构造注入
	public Param(Map<String,Object> paramMap)
	{
		this.paramMap=paramMap;
	}
	
	//TODO TCF 默认无参构造
	public Param()
	{
		
	}
	
}
