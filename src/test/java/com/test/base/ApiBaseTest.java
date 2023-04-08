package com.test.base;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.automationfwk.config.josnmodels.EnvironmentConfigJsonModel;
import com.automationfwk.drivers.WebServiceDriverManager;
import com.automationfwk.ui.factory.WebServiceDriverManagerFactory;
import com.automationfwk.util.ConfigLoader;

public class ApiBaseTest 
{
	private final ThreadLocal<WebServiceDriverManager> webServiceDriver = new ThreadLocal<>();
	EnvironmentConfigJsonModel config = ConfigLoader.getInstance();
	
	private void setDriver(WebServiceDriverManager driver)
	{
        this.webServiceDriver.set(driver);
    }

    protected WebServiceDriverManager getDriver()
    {
        return this.webServiceDriver.get();
    }
	
	@BeforeTest
	public synchronized void startDriver() throws Exception
	{
		setDriver(WebServiceDriverManagerFactory.getManager(config.getAuthType(),config));
		 System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
	                "DRIVER = " + getDriver());
	}
	
	
	@AfterTest
	public synchronized void quitDriver(ITestResult result)
	{
		System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " + getDriver());
	}
}
