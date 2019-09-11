package com.tcf.kid.smart.framework.demo;

import com.tcf.kid.smart.framework.annotation.KidInject;
import com.tcf.kid.smart.framework.annotation.KidRepository;

@KidRepository
public class DemoSecond {

	//TODO TCF ƒÍ¡‰
	@KidInject
	private Integer age;
	
	public void showAge()
	{
		System.out.println("===="+DemoSecond.class.getSimpleName()+"¿‡£∫====ƒÍ¡‰£∫"+age+"====");
	}
	
}
