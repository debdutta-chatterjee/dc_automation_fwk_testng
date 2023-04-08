package com.automationfwk.api.endpoints;

public class BookstoreAccountEndpoints 
{
	public static String authorizedEndpoint =  "/Account/v1/Authorized";
	
	public static String generateTokenEndpoint =  "/Account/v1/GenerateToken";
	
	public static String addUserEndpoint =  "/Account/v1/User";
	
	public static String addUserEndpoint(String userid) {
		return "/Account/v1/User/"+userid;
	}
	
}
