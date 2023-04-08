package com.automationfwk.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationfwk.base.BasePage;
import com.automationfwk.config.josnmodels.EnvironmentConfigJsonModel;
import com.automationfwk.pom.components.BookstoreGrid;
import com.automationfwk.pom.components.BookstoreHeader;
import com.automationfwk.pom.components.BookstoreNavigation;

public class BookstorePage extends BasePage
{
	protected BookstorePage(WebDriver driver,EnvironmentConfigJsonModel config) 
	{
		super(driver,config);
		header = new BookstoreHeader(driver,config);
		grid = new BookstoreGrid(driver,config);
		navigation = new BookstoreNavigation(driver,config);
	}
	
	private String navUrl ="/books";
	private BookstoreHeader header;
	public String getNavUrl() {
		return navUrl;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	private BookstoreGrid grid;
	private BookstoreNavigation navigation;
	
	@FindBy(css="input#searchBox")
	private WebElement searchTxtBox;
	
	@FindBy(css="div.input-group-append")
	private WebElement searchBtn;

	public BookstorePage navigateTo()
	{
		super.navigateTo(navUrl);
		return this;
	}
	
	public BookstorePage setBookNameToSearch(String bookName)
	{
		wait.until(d -> searchTxtBox.isDisplayed());
		searchTxtBox.clear();
		searchTxtBox.sendKeys(bookName);
		return this;
	}
	
	public BookstorePage searchBook(String bookName)
	{
		return this.setBookNameToSearch(bookName)
			.searchBook();
	}
	
	public BookstorePage searchBook()
	{
		searchBtn.click();
		return this;
	}
	
	public BookstoreHeader getHeader() {
		return header;
	}

	public String getGridData(int row, int col) {
		return grid.getColumnData(row, col);
	}

	public BookstoreNavigation getNavigation() {
		return navigation;
	}
}
