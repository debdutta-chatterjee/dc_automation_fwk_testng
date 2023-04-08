package com.automationfwk.util;

import java.util.Properties;

import com.automationfwk.config.josnmodels.EnvironmentConfigJsonModel;
import com.automationfwk.config.josnmodels.UserConfigJsonModel;
import com.automationfwk.constants.EnvironmentType;

public class ConfigLoader 
{

	private static ConfigLoader loader;
	private Properties prop;
	private static EnvironmentConfigJsonModel config;
	
	private ConfigLoader(String testEnv)
	{
		prop = PropertyUtil.loadProperty(testEnv+"_envconfig.properties");
	}
	
	public static EnvironmentConfigJsonModel getInstance()
	{
		if(loader==null) 
		{
			loader = new ConfigLoader(getEnv().toString());
			ConfigLoader.setEnvironmentValues();
		}
		return config;
	}
	
	private static EnvironmentType getEnv()
	{
		String env=System.getProperty("testEnv", String.valueOf("PRD"));
		return EnvironmentType.valueOf(env) == null? 
				EnvironmentType.valueOf(String.valueOf("PRD")):EnvironmentType.valueOf(env);
    }
	
	private static EnvironmentConfigJsonModel setEnvironmentValues()
	{
		UserConfigJsonModel user = new UserConfigJsonModel(loader.prop.get("username").toString(),
				loader.prop.get("password").toString());
		user.setUserId(loader.prop.get("userId").toString());
		
		config = new EnvironmentConfigJsonModel(loader.prop.get("baseUrl").toString(), user);
		config.setTokenUrl(loader.prop.get("tokenurl").toString());
		return config;
	}
}

