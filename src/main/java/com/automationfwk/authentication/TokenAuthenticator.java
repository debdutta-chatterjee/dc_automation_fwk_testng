package com.automationfwk.authentication;

import com.automationfwk.api.josnmodels.Token;
import com.automationfwk.api.josnmodels.User;
import com.automationfwk.util.ApiUtil;

import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class TokenAuthenticator 
{

	public static Token getToken(String baseUrl,String tokenUrl,String username, String password) throws Exception
	{
		Response response=null;
		int trial=0;
		JSONObject request = new JSONObject();
		request.put("userName", username);
		request.put("password", password);
		
		try {
			trial++;
			response= ApiUtil.createRequest(baseUrl, Method.POST, tokenUrl,request);
			if(response.getStatusCode()!=200) throw new Exception("Token generation failed at trial"+trial);
		}catch(Exception e) {
			if(trial>5) throw new Exception("Token generation failed after maximum trials");
		}
		return ApiUtil.deserialize(response, Token.class);
	}

}
