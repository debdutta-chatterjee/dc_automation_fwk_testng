package com.automationfwk.authentication;

import com.automationfwk.api.josnmodels.Token;
import com.automationfwk.api.josnmodels.User;
import com.automationfwk.util.ApiUtil;
import java.util.HashMap;
import java.util.Map;

import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class TokenAuthenticator 
{
	
	private static Token token;
	private static final Map<String,Token> tokenManager = new HashMap<>();

	public static synchronized Token getToken(String baseUrl, String tokenUrl, String username, String password) {
		try {
			if (token == null && tokenManager.get(username)==null)
				token = generateToken(baseUrl, tokenUrl, username, password);
			tokenManager.put(username, token);
			return token;
		} catch (Exception e) {
			return null;
		}
	}

	private static synchronized Token generateToken(String baseUrl,String tokenUrl,String username, String password) throws Exception
	{
		Response response=null;
		int trial=0;
		JSONObject request = new JSONObject();
		request.put("userName", username);
		request.put("password", password);
		String req = ApiUtil.createRequestStringBody(request);
		
		try {
			trial++;
			response= ApiUtil.createRequest(baseUrl, Method.POST, tokenUrl,req);
			if(response.getStatusCode()!=200) throw new Exception("Token generation failed at trial"+trial);
		}catch(Exception e) {
			if(trial>5) throw new Exception("Token generation failed after maximum trials");
		}
		return ApiUtil.deserialize(response, Token.class);
	}

}
