package com.automationfwk.api.actions;

import com.automationfwk.base.BaseApi;
import com.automationfwk.config.josnmodels.EnvironmentConfigJsonModel;
import com.automationfwk.drivers.WebServiceDriverManager;
import com.automationfwk.util.ApiUtil;
import com.automationfwk.api.endpoints.BookstoreEndpoints;
import com.automationfwk.api.josnmodels.AddBooksJsonModel;
import com.automationfwk.api.josnmodels.BooksJsonModel;
import com.automationfwk.api.josnmodels.Isbn;
import java.util.ArrayList;

public class BookstoreApiActions extends BaseApi
{	
	public BookstoreApiActions(WebServiceDriverManager driver, EnvironmentConfigJsonModel config)
	{
		super(driver, config);
	}
		
	public AddBooksJsonModel generateAddListToBooksData()
	{
		BooksJsonModel bookList = ApiUtil.deserialize(driver.createGetRequest(BookstoreEndpoints.booksEndpoint),BooksJsonModel.class);
		ArrayList<Isbn> lstIsbn= new ArrayList<Isbn>();
		Isbn isbn1= new Isbn();
		isbn1.setIsbn(bookList.getBooks().get(0).getIsbn());
		
		Isbn isbn2= new Isbn();
		isbn2.setIsbn(bookList.getBooks().get(1).getIsbn());
		
		lstIsbn.add(isbn1);
		lstIsbn.add(isbn2);
		
		AddBooksJsonModel requestBody =new AddBooksJsonModel();
		requestBody.setUserId(driver.getUserId());
		requestBody.setCollectionOfIsbns(lstIsbn);
		
		return requestBody;
	}
}
