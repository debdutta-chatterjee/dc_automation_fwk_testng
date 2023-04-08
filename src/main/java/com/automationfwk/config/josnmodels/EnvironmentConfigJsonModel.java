package com.automationfwk.config.josnmodels;

import com.automationfwk.constants.AuthenticationType;

public class EnvironmentConfigJsonModel 
{
	private String baseUrl;
	private UserConfigJsonModel user;
	private String tokenUrl;
	private AuthenticationType authType;
	
	public AuthenticationType getAuthType() 
	{
		return authType;
	}

	public void setAuthType(AuthenticationType authType) 
	{
		this.authType = authType;
	}

	public String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	public EnvironmentConfigJsonModel() {}
	
	public EnvironmentConfigJsonModel(String baseUrl, UserConfigJsonModel user) 
	{
		super();
		this.baseUrl = baseUrl;
		this.user = user;
	}
	
	public String getBaseUrl() 
	{
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) 
	{
		this.baseUrl = baseUrl;
	}

	public UserConfigJsonModel getUser() 
	{
		return user;
	}

	public void setUser(UserConfigJsonModel user) 
	{
		this.user = user;
	}
}
