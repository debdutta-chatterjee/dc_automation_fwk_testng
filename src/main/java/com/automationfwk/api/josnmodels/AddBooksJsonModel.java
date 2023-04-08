package com.automationfwk.api.josnmodels;

import java.util.ArrayList;

public class AddBooksJsonModel 
{
	private String userId;
	private ArrayList<Isbn> collectionOfIsbns;
	private String isbn;
	
	public String getIsbn() 
	{
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getUserId() 
	{
		return userId;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}
	public ArrayList<Isbn> getCollectionOfIsbns() 
	{
		return collectionOfIsbns;
	}
	public void setCollectionOfIsbns(ArrayList<Isbn> collectionOfIsbns) 
	{
		this.collectionOfIsbns = collectionOfIsbns;
	}
}
