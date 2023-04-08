package com.automationfwk.drivers;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager
{
	protected WebDriver driver;
	
	protected abstract WebDriver createDriver();
	
    public void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver(){
        if(driver == null){
        	createDriver();
        }
        return driver;
    }
}
