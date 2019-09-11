package com.tcf.kid.smart.framework.demo;

import com.tcf.kid.smart.framework.annotation.KidInject;
import com.tcf.kid.smart.framework.annotation.KidService;

@KidService
public class DemoThird {

	//TODO TCF 其他组件
	@KidInject
	private DemoFirst demoFirst;
	
	@KidInject
	private DemoSecond demoSecond;
	
	public void showDemoFirst()
	{
		if(demoFirst!=null)
		{
			System.out.println(DemoThird.class.getSimpleName()+"===="+demoFirst.toString());
		}
	}
	
	public void showDemoSecond()
	{
		if(demoSecond!=null)
		{
			System.out.println(DemoThird.class.getSimpleName()+"===="+demoSecond.toString());
		}
	}
	
}
