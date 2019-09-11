package com.tcf.kid.smart.framework.model;

import java.util.Map;

/***
 * TODO TCF 封装控制器处理请求方法返回的视图解析格式响应数据
 * @author 71485
 *
 */
public class View {

	//TODO TCF 视图解析路径
	private String viewPath;
	
	//TODO TCF 绑定的模型参数
	private Map<String,Object> modelParams;
	
	public String getViewPath() {
		return viewPath;
	}
	public Map<String, Object> getModelParams() {
		return modelParams;
	}
	
	//TODO TCF 构造注入
	public View(String viewPath,Map<String,Object> modelParams)
	{
		this.viewPath=viewPath;
		this.modelParams=modelParams;
	}
	
	//TODO TCF 默认无参构造
	public View()
	{
		
	}
	
}
