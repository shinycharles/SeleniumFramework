package com.ta.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ta.salesforce.testcases.BaseClass;

@Listeners(com.ta.listeners.listeners.class)
public class TestNG_Listeners extends BaseClass{
	
	@Test
	public void SalesforcepageWebsite()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.salesforce.com/");
		System.out.println("I am at salesforce login page!");
		driver.quit();
	}
	
	@Test
	public void LoginPage() throws InterruptedException
	{
		
		
		driver.get("https://www.salesforce.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		SaleUtil.loginToWebSite(username, password);
		WebDriverWait wait=new WebDriverWait (driver,5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='dropdown-toggle disabled']"))));
		driver.findElement(By.xpath("//a[@class='dropdown-toggle disabled']")).click();
		
			
		WebDriverWait wait1=new WebDriverWait (driver,5);
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));
			
			
			driver.findElement(By.id("username")).click();
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("shiny@ati.com");
			
			Thread.sleep(1000);
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).click();
			driver.findElement(By.id("password")).sendKeys("apple123");
			
			//Thread.sleep(1000);
			//driver.findElement(By.id("rememberUn")).click();
			 
			
			Thread.sleep(1000);
			driver.findElement(By.id("Login")).submit();
			System.out.println("We are Logged in!");
			System.out.println("I am at Home page!");
			driver.close();
			
	}

	
}
