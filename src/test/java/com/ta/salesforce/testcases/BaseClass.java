package com.ta.salesforce.testcases;

import java.util.logging.Logger;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.ta.utilities.SalesForceUtilities;

public class BaseClass{
	public String baseURL="https://www.salesforce.com";
	public String username="shiny@ati.com";
	public String password="apple123";
	public  WebDriver driver;
	public static SalesForceUtilities SaleUtil=new  SalesForceUtilities();
	public static ExtentReports reports;
	public static ExtentTest logger;
	String sPath=System.getProperty("user.dir")+"ExtentReport/samplereportBrowser.html";
	
	//@Parameters("browser")
	
	@BeforeClass
	public void setup() throws InterruptedException
	{
		    reports=new ExtentReports(sPath);
			driver= SaleUtil.launchBrowser("ch");
			driver.get("https://www.salesforce.com/");
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Browser is launched!");
		
		
	}
	
	@AfterClass
	public void teardown() throws InterruptedException
	{
		SaleUtil.driver.quit();
		Thread.sleep(1000);
		System.out.println("Browser is Closed!");
		reports.flush();
	}
	
}
