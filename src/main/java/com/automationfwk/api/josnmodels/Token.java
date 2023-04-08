package com.automationfwk.api.josnmodels;

import java.util.Date;

public class Token 
{
	private String token;
	private Date expires;
	private String status;
	private String result;
	   
	public String getToken() 
    {
		return token;
	}
	public void setToken(String token) 
	{
		this.token = token;
	}
	public Date getExpires() 
	{
		return expires;
	}
	public void setExpires(Date expires) 
	{
		this.expires = expires;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}
	public String getResult() 
	{
		return result;
	}
	public void setResult(String result) 
	{
		this.result = result;
	}
}
