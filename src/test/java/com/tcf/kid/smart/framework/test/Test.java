package com.tcf.kid.smart.framework.test;

import java.util.ArrayList;
import java.util.List;

import com.tcf.kid.smart.framework.aop.AopHelper;
import com.tcf.kid.smart.framework.helper.BeanHelper;
import com.tcf.kid.smart.framework.helper.ClassHelper;
import com.tcf.kid.smart.framework.ioc.IocHelper;
import com.tcf.kid.smart.framework.util.ClassUtil;

public class Test {

	public static void main(String[] args) 
	{
		//TODO TCF 需要加载的类
		List<Class<?>> classList=new ArrayList<Class<?>>();
		
		classList.add(ClassHelper.class);
		classList.add(BeanHelper.class);
		classList.add(AopHelper.class);
		classList.add(IocHelper.class);
		
		for(Class<?> cls:classList)
		{
			ClassUtil.loadClassByName(cls.getName());
		}
	}
}
