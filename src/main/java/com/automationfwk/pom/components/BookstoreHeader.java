package com.automationfwk.pom.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationfwk.config.josnmodels.EnvironmentConfigJsonModel;
import com.automationfwk.pom.base.BasePage;

public class BookstoreHeader extends BasePage
{

	public BookstoreHeader(WebDriver driver,EnvironmentConfigJsonModel config) 
	{
		super(driver,config);
	}
	
	private By pageHeader(String pagename)
	{
		return By.xpath("//div[@class='main-header'][text()='"+pagename+"']");
	}
	
	public String getHeaderText(String menu)
	{
		return wait.until(d -> d.findElement(this.pageHeader(menu))).getText();
	}
	
	@FindBy(xpath="//button[text()='Log out']")
	private WebElement logOutBtn;
	
	@FindBy(css="label#userName-value")
	private WebElement userNameLbl;
	
	public String getLoggedInUserName()
	{
		wait.until(d -> userNameLbl.isDisplayed());
		return userNameLbl.getText();
	}
	
	public void logOutUser()
	{
		wait.until(d -> logOutBtn.isDisplayed());
		logOutBtn.click();
	}
}
