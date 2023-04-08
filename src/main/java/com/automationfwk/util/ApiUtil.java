package com.automationfwk.util;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.json.simple.JSONObject;

public class ApiUtil 
{
	static ObjectMapper mapper = new ObjectMapper();
	
	
	
	public static <T> T serialize(String path,Class<T> classType) 
			throws StreamReadException, DatabindException, IOException 
	{
		return mapper.readValue(new File(path), classType);
	}
	
	public static String serializeToString(Collections objCollection) 
			throws JsonProcessingException 
	{
		ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
       return  mapper.writeValueAsString(objCollection);
	}
	
	public static JSONObject getJsonObjet(String key, Collection<?> objCollection) 
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, objCollection);
		
		return jsonObject;
	}
	
	public static <T> T deserialize(Response response,Class<T> classType)
	{
		return response.as(classType);
	}
	
	//with body (POST/PUT/PATCH)
	public static Response createRequest(String baseUri,Method method,String endpoint,Map<String,Object> reqHeaders,String body) 
	{
		return sendRequest(
				createBaseRequest(baseUri)
				.headers(reqHeaders).body(body), method,endpoint
				);				
	}
	
	
	//without body (GET/DELETE/HEADER/OPTION)
	public static Response createRequest(String baseUri,Method method,String endpoint,Map<String,Object> reqHeaders) 
	{
		return sendRequest(
				createBaseRequest(baseUri).headers(reqHeaders)
				, method,endpoint
				);			
	}
	
	//without header
	public static Response createRequest(String baseUri,Method method,String endpoint,String body) 
	{
		return sendRequest(
				createBaseRequest(baseUri).body(body)
				, method,endpoint
				);			
	}
		
	private static RequestSpecification createBaseRequest(String baseUri)
	{
		return RestAssured.given()
				.log().all()
				.baseUri(baseUri)
				.header("content-type","application/json");
	}
	
	private static Response sendRequest(RequestSpecification requestSpecs,Method method,String endpoint)
	{
		Response response=requestSpecs.request(method,endpoint);
		response.prettyPrint();
		return response;		
	}
	
	public static String createRequestStringBody(Object object)
	{
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			return ow.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			return null;
		}
	}
}
