package com.tcf.kid.smart.framework.model;

/***
 * TODO TCF 封装请求信息
 * @author 71485
 *
 */
public class Request {

	//TODO TCF 请求路径
	private String requestUrl;
	
	//TODO TCF 请求方式
	private String requestMethod;
	
	public String getRequestUrl() {
		return requestUrl;
	}
	public String getRequestMethod() {
		return requestMethod;
	}
	
	//TODO TCF 构造注入
	public Request(String requestUrl,String requestMethod)
	{
		this.requestUrl=requestUrl;
		this.requestMethod=requestMethod;
	}
	
	//TODO TCF 默认无参构造
	public Request()
	{
		
	}
	
}
