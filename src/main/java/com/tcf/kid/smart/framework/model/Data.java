package com.tcf.kid.smart.framework.model;

/***
 * TODO TCF 控制器处理请求方法返回的响应数据，JSON序列化后直接写入输出流并返回响应
 * @author 71485
 *
 */
public class Data {

	//TODO TCF 控制器处理请求方法返回的响应数据
	private Object data;
	
	public Object getData() {
		return data;
	}
	
	//TODO TCF 构造注入
	public Data(Object data)
	{
		this.data=data;
	}
	
	//TODO TCF 默认无参构造
	public Data()
	{
		
	}
	
}
