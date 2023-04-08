package com.automationfwk.drivers;


import com.automationfwk.api.josnmodels.Token;
import com.automationfwk.authentication.TokenAuthenticator;
import com.automationfwk.config.josnmodels.EnvironmentConfigJsonModel;
import com.automationfwk.util.ApiUtil;


import io.restassured.http.Method;
import io.restassured.response.Response;

public class TokenAuthWebServiceDriverManager extends WebServiceDriverManager
{
	private Token token;
	
	public TokenAuthWebServiceDriverManager(EnvironmentConfigJsonModel config) throws Exception
	{
		super(config);
		token= TokenAuthenticator.getToken(config.getBaseUrl(), config.getTokenUrl(),
				config.getUser().getUserName(),config.getUser().getPassword());
		header.put("Authorization", "Bearer "+token.getToken());
	}
		
	public Response createGetRequest(String endpoint)
	{
		return ApiUtil.createRequest(config.getBaseUrl(), Method.GET, endpoint,header);
	}
	
	public Response createPostRequest(String endpoint,String body)
	{
		return ApiUtil.createRequest(config.getBaseUrl(), Method.POST, endpoint,header,body);
	}
	
	public Response createDeleteRequest(String endpoint)
	{
		return ApiUtil.createRequest(config.getBaseUrl(), Method.DELETE, endpoint,header);
	}
	
	public Response createPutRequest(String endpoint,String body)
	{
		return ApiUtil.createRequest(config.getBaseUrl(), Method.PUT, endpoint,header,body);
	}
	
	public Response createPatchRequest(String endpoint,String body)
	{
		return ApiUtil.createRequest(config.getBaseUrl(), Method.PUT, endpoint,header,body);
	}
}
