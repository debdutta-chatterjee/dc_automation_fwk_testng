package com.automationfwk.api.endpoints;

public class BookstoreEndpoints 
{
	public static String booksEndpoint =  "/BookStore/v1/Books";
	
	public static String getBookByIsbnEndpoint(String isbn)
	{
		return "/BookStore/v1/Book?ISBN="+isbn;
	}
	
	public static String putAddBookByIsbnEndpoint(String isbn)
	{
		return "/BookStore/v1/Books/"+isbn;
	}
	
	

}
