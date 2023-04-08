package com.automationfwk.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationfwk.config.josnmodels.EnvironmentConfigJsonModel;

public class BasePage 
{
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	EnvironmentConfigJsonModel config;
	
	protected BasePage(WebDriver driver,EnvironmentConfigJsonModel config)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo(String navUrl)
	{
		String baseUrl=config.getBaseUrl();
		driver.navigate().to(baseUrl + navUrl);		
	}

}
