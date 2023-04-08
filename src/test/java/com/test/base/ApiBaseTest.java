package com.test.base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.automationfwk.config.josnmodels.EnvironmentConfigJsonModel;
import com.automationfwk.drivers.WebServiceDriverManager;
import com.automationfwk.ui.factory.WebServiceDriverManagerFactory;
import com.automationfwk.util.ConfigLoader;
import com.google.common.util.concurrent.Uninterruptibles;

import groovy.time.Duration;

public class ApiBaseTest 
{
	private final ThreadLocal<WebServiceDriverManager> webServiceDriver = new ThreadLocal<>();
	private EnvironmentConfigJsonModel config;
	
	public EnvironmentConfigJsonModel getConfig() {
		return config;
	}

	private void setDriver(WebServiceDriverManager driver)
	{
        this.webServiceDriver.set(driver);
    }

    protected WebServiceDriverManager getDriver()
    {
        return this.webServiceDriver.get();
    }
	
	@BeforeMethod
	public synchronized void startDriver() throws Exception
	{
		config = ConfigLoader.getInstance();
		setDriver(WebServiceDriverManagerFactory.getManager(config.getAuthType(),config));
		 System.out.println("CURRENT THREAD START: " + Thread.currentThread().getId() + ", " +
	                "DRIVER = " + getDriver());
		 Uninterruptibles.sleepUninterruptibly(java.time.Duration.ofSeconds(2));
	}
	
	
	@AfterMethod
	public synchronized void quitDriver()
	{
		System.out.println("CURRENT THREAD EXIT: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " + getDriver());
	}
}
