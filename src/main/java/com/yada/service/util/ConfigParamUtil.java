package com.yada.service.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ConfigParamUtil
{
	private static Properties prop = new Properties();
	static
	{
		try
		{
			prop.load(Thread.currentThread()
					.getContextClassLoader()
					.getResourceAsStream("configuration.properties"));
			/*
			 * String path=DbUtils.class.getResource("/").getPath(); String
			 * fullpath=path+"configuration.properties";
			 * System.out.println(fullpath);
			 */
			// prop.load(new FileInputStream(new File(fullpath)));
			// prop.load(new FileInputStream("configuration.properties"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static String getProperty(String key)
	{
		return prop.getProperty(key);
	}
}
