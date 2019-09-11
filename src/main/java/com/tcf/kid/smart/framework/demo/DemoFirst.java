package com.tcf.kid.smart.framework.demo;

import com.tcf.kid.smart.framework.annotation.KidComponent;
import com.tcf.kid.smart.framework.annotation.KidInject;

@KidComponent
public class DemoFirst {

	//TODO TCF –’√˚
	@KidInject
	private String name;
	
	public void showName()
	{
		System.out.println("===="+DemoFirst.class.getSimpleName()+"¿‡£∫====–’√˚£∫"+name+"====");
	}
	
}
