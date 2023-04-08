package com.automationfwk.authentication;

import java.util.List;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.automationfwk.util.CookieUtils;

import io.restassured.http.Cookies;

public class CookieAuthenticator 
{
	public void injectCookiesToBrowser(Cookies cookies,WebDriver driver){
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        for(Cookie cookie: seleniumCookies){
            System.out.println(cookie.toString());
            driver.manage().addCookie(cookie);
        }
    }

}
