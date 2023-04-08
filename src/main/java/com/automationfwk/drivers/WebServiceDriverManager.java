package com.automationfwk.drivers;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.automationfwk.config.josnmodels.EnvironmentConfigJsonModel;
import com.automationfwk.util.ApiUtil;

import io.restassured.response.Response;

public abstract class WebServiceDriverManager 
{
	EnvironmentConfigJsonModel config;
	Map<String,Object> header;

	public WebServiceDriverManager(EnvironmentConfigJsonModel config)
	{
		this.config = config;
		header= new HashMap<>();
	}
	
	public abstract Response createGetRequest(String endpoint);
		
	public abstract Response cretePostRequest(String endpoint,JSONObject body);
	
	public abstract Response createDeleteRequest(String endpoint);
	
	public abstract Response createPatchRequest(String endpoint,JSONObject body);
	
	public abstract Response createPutRequest(String endpoint,JSONObject body);
		
	public <T> T deserialize(Response response,Class<T> classType)
	{
		return ApiUtil.deserialize(response, classType);
	}
}
