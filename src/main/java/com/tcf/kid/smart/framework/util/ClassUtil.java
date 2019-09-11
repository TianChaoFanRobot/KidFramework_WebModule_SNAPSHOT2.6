package com.tcf.kid.smart.framework.util;

import java.io.File;
import java.io.FileFilter;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.lang3.StringUtils;

import com.tcf.kid.smart.framework.common.Const;

/***
 * TODO TCF 类加载器工具类
 * TODO TCF 获取类加载器
 * TODO TCF 根据类名加载类
 * TODO TCF 一次加载一个类到临时容器
 * TODO TCF 一次加载多个类到临时容器(递归扫包)
 * TODO TCF 加载基准包及其子包中的所有类
 * @author 71485
 *
 */
public class ClassUtil {

	//TODO TCF 获取类加载器
	public static ClassLoader getClassLoader()
	{
		return Thread.currentThread().getContextClassLoader();
	}
	
	//TODO TCF 根据类名加载类
	public static Class<?> loadClassByName(String className)
	{
		Class<?> cls=null;
		
		try
		{
			cls=Class.forName(className,true,getClassLoader());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return cls;
	}
	
	//TODO TCF 一次加载一个类到临时容器
	public static void addClass(Set<Class<?>> classList,String className)
	{
		try
		{
			Class<?> cls=loadClassByName(className);
			classList.add(cls);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//TODO TCF 一次加载多个类到临时容器(递归扫包)
	public static void addClassReceive(Set<Class<?>> classList,String packagePath,String packageName)
	{
		try
		{
			//TODO TCF 扫描的基准包目录
			File dirFile=new File(packagePath);
			
			if(dirFile!=null)
			{
				//TODO TCF 基准包中的所有文件和目录
				File[] files=dirFile.listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File file) 
					{
						return (file.isFile() && file.getName().endsWith(".class")) || (file.isDirectory());
					}
					
				});
				
				if(files!=null && files.length>0)
				{
					for(File file:files)
					{
						//TODO TCF 读取到的文件名或目录名
						String fileName=file.getName();
						
						if(StringUtils.isNotEmpty(fileName))
						{
							if(file.isFile())
							{
								//TODO TCF 读取到的是文件
								//TODO TCF 获取类名直接加载类
								String className=fileName.substring(0,fileName.lastIndexOf("."));
								
								if(StringUtils.isNotEmpty(packageName))
								{
									className=packageName+"."+className;
								}
								
								addClass(classList,className);
							}
							else
							{
								//TODO TCF 读取到的是目录
								//TODO TCF 获取子包路径和子包名递归加载包及其子包中的所有类
								String subPackagePath=fileName;
								
								if(StringUtils.isNotEmpty(packagePath))
								{
									subPackagePath=packagePath+"/"+subPackagePath;
								}
								
								String subPackageName=fileName;
								
								if(StringUtils.isNotEmpty(packageName))
								{
									subPackageName=packageName+"."+subPackageName;
								}
								
								addClassReceive(classList,subPackagePath,subPackageName);
							}
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//TODO TCF 加载基准包及其子包中的所有类
	public static Set<Class<?>> loadClassByPackage(String packageName)
	{
		Set<Class<?>> classList=new HashSet<Class<?>>();
		
		try
		{
			Enumeration<URL> urls=getClassLoader().getResources(packageName.replace(".","/"));
			
			if(urls!=null)
			{
				while(urls.hasMoreElements())
				{
					URL url=urls.nextElement();
					
					if(url!=null)
					{
						//TODO TCF URL协议类型
						String protocol=url.getProtocol();
						
						if(StringUtils.isNotEmpty(protocol))
						{
							if(protocol.equals(Const.URL_PROTOCOLS.FILE))
							{
								//TODO TCF URL文件协议File
								//TODO TCF 获取包路径递归加载包及其子包中的所有类
								String packagePath=url.getPath().replace("%20"," ");
								addClassReceive(classList,packagePath,packageName);
							}
							else if (protocol.equals(Const.URL_PROTOCOLS.JAR))
							{
								//TODO TCF URL目录协议Jar，解析Jar包
								JarURLConnection jarURLConnection=(JarURLConnection)url.openConnection();
								
								if(jarURLConnection!=null)
								{
									JarFile jarFile=jarURLConnection.getJarFile();
									
									if(jarFile!=null)
									{
										Enumeration<JarEntry> entries=jarFile.entries();
										
										if(entries!=null)
										{
											while(entries.hasMoreElements())
											{
												JarEntry jarEntry=entries.nextElement();
												
												if(jarEntry!=null)
												{
													//TODO TCF 读取到的类文件名
													String entryName=jarEntry.getName();
													
													if(StringUtils.isNotEmpty(entryName) && entryName.endsWith(".class"))
													{
														String className=entryName.substring(0,entryName.lastIndexOf("."));
														addClass(classList,className);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return classList;
	}
}
