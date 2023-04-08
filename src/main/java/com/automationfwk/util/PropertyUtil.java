package com.automationfwk.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil 
{
	private static Properties prop;
	
	//private constructor to restrict object creation
	private PropertyUtil()
	{
		
	}
	
	public static Properties loadProperty(String fileName)
	{
		prop = new Properties();
		try (FileInputStream fis=  new FileInputStream(new File("./resources/"+fileName))){
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
