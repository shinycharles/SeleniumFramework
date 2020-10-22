package com.ta.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ta.salesforce.pageobjects.loginPage;

public class TC_Login extends BaseClass{
	
	loginPage logpg;
	
	@BeforeTest
	public void triggerDependency()
	{
		//driver.get(baseURL);
		logpg= new loginPage(driver);
		
	}
	
	@Test
	public void LoginToWebsite() throws Exception
	{
		Thread.sleep(3000);
		logpg.LoginToWebsite();
		System.out.println("Login Success!"); 
	}

	
}
