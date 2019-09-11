package com.tcf.kid.smart.framework.demo;

import java.util.HashMap;
import java.util.Map;

import com.tcf.kid.smart.framework.annotation.KidAction;
import com.tcf.kid.smart.framework.annotation.KidController;
import com.tcf.kid.smart.framework.model.Data;
import com.tcf.kid.smart.framework.model.Param;
import com.tcf.kid.smart.framework.model.View;

/***
 * TODO TCF 自定义MVC处理请求控制器
 * @author 71485
 *
 */
@KidController
public class TestController {

	//TODO TCF 代理目标方法
	public void showProxyResult(Param param)
	{
		System.out.println("====代理目标方法执行====");
	}
	
	//TODO TCF EXAMPLE 1 返回视图解析格式响应数据
	@KidAction(url="/toPage.do",method="GET")
	public View toPage(Param param)
	{
		return new View("example.jsp",null);
	}
	
	//TODO TCF EXAMPLE 2 直接返回响应数据，JSON序列化后直接写入输出流并返回响应
	@KidAction(url="/show.do",method="GET")
	public Data show(Param param)
	{
		if(param!=null)
		{
			//TODO TCF 后台接收到的请求参数
			Map<String,Object> paramMap=param.getParamMap();
			
			if(paramMap!=null)
			{
				for(Map.Entry<String,Object> paramEntry:paramMap.entrySet())
				{
					//TODO TCF 请求参数名
					String paramName=paramEntry.getKey();
					
					//TODO TCF 请求参数值
					String paramValue=paramEntry.getValue()!=null?paramEntry.getValue().toString():"";
					
					System.out.println("后台接收到的请求参数名===>"+paramName);
					System.out.println("后台接收到的请求参数值===>"+paramValue);
				}
			}
		}
		
		//TODO TCF 返回响应数据
		Map<String,Object> dataMap=new HashMap<String,Object>();
		dataMap.put("name","mhw");
		
		return new Data(dataMap);
	}
}
