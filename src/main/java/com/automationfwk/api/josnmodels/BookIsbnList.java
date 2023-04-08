package com.automationfwk.api.josnmodels;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;


public class BookIsbnList 
{	
	@JsonProperty("books") 
	private ArrayList<BookIsbn> books;

	public ArrayList<BookIsbn> getBooks() 
	{
		return books;
	}

	public void setBooks(ArrayList<BookIsbn> books) 
	{
		this.books = books;
	}
}
