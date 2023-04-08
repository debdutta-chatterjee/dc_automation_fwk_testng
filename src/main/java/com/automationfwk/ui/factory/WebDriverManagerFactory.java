package com.automationfwk.ui.factory;

import com.automationfwk.constants.WebDriverType;
import com.automationfwk.drivers.*;

public class WebDriverManagerFactory 
{
	public static WebDriverManager getManager(WebDriverType driverType){
        switch (driverType){
            case CHROME -> {
                return new ChromeDriverManager();
            }
            case FIREFOX -> {
                return new FirefoxDriverManager();
            }
            default -> throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}
