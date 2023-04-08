package com.test.uitests;

import org.apache.hc.core5.http.HttpStatus;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationfwk.api.actions.BookstoreApiActions;
import com.automationfwk.api.endpoints.BookstoreEndpoints;
import com.automationfwk.api.josnmodels.BookIsbnList;
import com.automationfwk.util.ApiUtil;
import com.test.base.ApiBaseTest;
import com.automationfwk.api.josnmodels.AddBooksJsonModel;

public class BookStoreApiTest extends ApiBaseTest 
{
	@Test
	public void userCanAddBookToProfile()
	{
		BookstoreApiActions api= new BookstoreApiActions(getDriver(), getConfig());
		
		AddBooksJsonModel responseBookList = api.generateAddListToBooksData();
		String requestBody = ApiUtil.createRequestStringBody(responseBookList);
		Response response = getDriver().createPostRequest(BookstoreEndpoints.booksEndpoint, requestBody);
		
		Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_CREATED);
		
		BookIsbnList isbnList = ApiUtil.deserialize(response, BookIsbnList.class);
		Assert.assertTrue(isbnList.getBooks().get(0).getIsbn().contains
				(responseBookList.getCollectionOfIsbns().get(0).getIsbn()));
		
	}
	
	@Test
	public void userCanAddBookToProfile2()
	{
		BookstoreApiActions api= new BookstoreApiActions(getDriver(), getConfig());
		
		AddBooksJsonModel responseBookList = api.generateAddListToBooksData();
		String requestBody = ApiUtil.createRequestStringBody(responseBookList);
		Response response = getDriver().createPostRequest(BookstoreEndpoints.booksEndpoint, requestBody);
		
		Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_CREATED);
		
		BookIsbnList isbnList = ApiUtil.deserialize(response, BookIsbnList.class);
		Assert.assertTrue(isbnList.getBooks().get(0).getIsbn().contains
				(responseBookList.getCollectionOfIsbns().get(0).getIsbn()));
		
	}
	
	@Test
	public void userCanAddBookToProfile3()
	{
		BookstoreApiActions api= new BookstoreApiActions(getDriver(), getConfig());
		
		AddBooksJsonModel responseBookList = api.generateAddListToBooksData();
		String requestBody = ApiUtil.createRequestStringBody(responseBookList);
		Response response = getDriver().createPostRequest(BookstoreEndpoints.booksEndpoint, requestBody);
		
		Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_CREATED);
		
		BookIsbnList isbnList = ApiUtil.deserialize(response, BookIsbnList.class);
		Assert.assertTrue(isbnList.getBooks().get(0).getIsbn().contains
				(responseBookList.getCollectionOfIsbns().get(0).getIsbn()));
		
	}

}
