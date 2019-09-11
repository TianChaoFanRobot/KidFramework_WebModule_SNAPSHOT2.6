package com.tcf.kid.smart.framework.common;

/***
 * TODO TCF 常量类
 * @author 71485
 *
 */
public class Const {

	//TODO TCF IOC/DI/AOP属性配置文件
	public static class PROPERTIES_FILES
	{
		//TODO TCF IOC/DI/AOP核心配置文件
		public static final String BASE_PROPERTIES="base.properties";
	}
	
	//TODO TCF IOC/DI/AOP核心配置文件中的KEY
	public static class BASE_PROPERTIES_KEYS
	{
		//TODO TCF IOC/DI/AOP扫描基准包
		public static final String BASE_PACKAGE="base_package";
		
		//TODO TCF MVC视图资源路径
		public static final String VIEW_RESOURCE="view_resource";
		
		//TODO TCF MVC默认其他静态资源
		public static final String STATIC_RESOURCE="static_resource";
	}
	
	//TODO TCF URL协议类型
	public static class URL_PROTOCOLS
	{
		//TODO TCF URL文件协议File
		public static final String FILE="file";
		
		//TODO TCF URL目录协议Jar
		public static final String JAR="jar";
	}
	
	//TODO TCF Servlet资源服务类型
	public static class SERVLET_REGISTRATION_TYPES
	{
		//TODO TCF JSP视图资源
		public static final String JSP="jsp";
		
		//TODO TCF HTML视图资源
		public static final String HTML="html";
		
		//TODO TCF 默认其他静态资源
		public static final String DEFAULT="default";
	}
}
