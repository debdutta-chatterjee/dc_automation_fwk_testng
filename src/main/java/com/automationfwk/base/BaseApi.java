package com.automationfwk.base;

import com.automationfwk.config.josnmodels.EnvironmentConfigJsonModel;
import com.automationfwk.drivers.WebServiceDriverManager;

public class BaseApi 
{
	protected WebServiceDriverManager driver;
	protected EnvironmentConfigJsonModel config;
	
	protected BaseApi(WebServiceDriverManager driver,EnvironmentConfigJsonModel config) 
	{
		this.driver=driver;
		this.config=config;
	}
}
