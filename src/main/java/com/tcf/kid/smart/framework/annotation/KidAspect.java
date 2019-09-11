package com.tcf.kid.smart.framework.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * TODO TCF 标注AOP自定义切面子类
 * @author 71485
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface KidAspect {

	//TODO TCF 代理目标类型
	Class<? extends Annotation> value();
	
}
