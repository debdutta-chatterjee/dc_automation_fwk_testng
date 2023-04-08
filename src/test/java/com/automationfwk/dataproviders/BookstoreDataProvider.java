package com.automationfwk.dataproviders;

import org.testng.annotations.DataProvider;

public class BookstoreDataProvider 
{

	@DataProvider(name = "getBooksToSearch", parallel = false)
    public Object[] getBooksToSearch()
	{
        return new String[] {"Git Pocket Guide","Designing Evolvable Web APIs with ASP.NET", "Speaking JavaScript"};
    }
}
