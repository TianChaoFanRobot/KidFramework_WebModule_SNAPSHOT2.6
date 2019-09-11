package com.tcf.kid.smart.framework.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/***
 * TODO TCF 文件流工具类
 * @author 71485
 *
 */
public class StreamUtil {

	//TODO TCF 从输入流中读取字符串
	public static String readInputStream(InputStream inputStream)
	{
		StringBuffer stb=new StringBuffer();
		
		try
		{
			//TODO TCF 字符输入流
			BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
			
			if(reader!=null)
			{
				//TODO TCF 是否读到末尾
				int readPoint=-1;
				
				while((readPoint=reader.read())>-1)
				{
					stb.append(reader.readLine());
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return stb.toString();
	}
}
