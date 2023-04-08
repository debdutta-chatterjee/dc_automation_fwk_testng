package com.automationfwk.pom.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationfwk.base.BasePage;
import com.automationfwk.config.josnmodels.EnvironmentConfigJsonModel;

public class BookstoreNavigation extends BasePage
{

	public BookstoreNavigation(WebDriver driver,EnvironmentConfigJsonModel config) 
	{
		super(driver,config);
	}
	
	private By navigationMenu(String menu)
	{
		return By.xpath("//ul[@class='menu-list']//span[text()='"+menu+"']");
	}
	
	public void navigateToPage(String menu)
	{
		wait.until(d -> d.findElement(this.navigationMenu(menu))).click();
	}
	
}
