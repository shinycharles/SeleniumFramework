package com.ta.utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceUtilities {
	public static WebDriver driver=null;

	public WebDriver launchBrowser( String sBrowserName) {
		  
		 
		 switch (sBrowserName)
	 {
		case "ch": 
			 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
			default:
				break;
				
		}
		 
          return driver;
}

public static void ufClickElement(WebElement ele)
{
	//WebElement ele=new WebElement();
	ele.click();
}

public static void ufClearElement(WebElement ele)
{
	ele.clear();
}
public static void ufSendkeys(WebElement ele, String text)
{
	ele.sendKeys(text);
}
public static void explicitWaitFun(WebElement ele,int iTime)
{
WebDriverWait wait=new WebDriverWait (driver,iTime);
wait.until(ExpectedConditions.visibilityOf(ele));
}
public static void explicitWaitFun1(WebElement ele,int iTime)
{
WebDriverWait wait1=new WebDriverWait (driver,iTime);
wait1.until(ExpectedConditions.visibilityOf(ele));
}
public static void QuitBrowser() throws Exception {
	driver.quit();
}

public static void EnterPassword() throws Exception {
	driver.get("https://www.salesforce.com/");
	Thread.sleep(1000);
	
	//driver.manage().window().maximize();
	
WebDriverWait wait=new WebDriverWait (driver,5);
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Login')]"))));
driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

	
WebDriverWait wait1=new WebDriverWait (driver,5);
wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));
	
	
	driver.findElement(By.id("username")).click();
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys("shiny@ati.com");
	
	Thread.sleep(1000);
	driver.findElement(By.id("password")).clear();
	//driver.findElement(By.id("password")).click();
	//driver.findElement(By.id("password")).sendKeys("apple123");
	
	Thread.sleep(1000);
	driver.findElement(By.id("Login")).click();
	
	Thread.sleep(1000);
	driver.findElement(By.id("error")).isDisplayed();
	System.out.println(driver.findElement(By.id("error")).getText());
}

public static void LoginToWebsite() throws Exception {

driver.get("https://www.salesforce.com/");
Thread.sleep(1000);

driver.manage().window().maximize();

WebDriverWait wait=new WebDriverWait (driver,5);
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Login')]"))));
driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();


WebDriverWait wait1=new WebDriverWait (driver,5);
wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));


driver.findElement(By.id("username")).click();
driver.findElement(By.id("username")).clear();
driver.findElement(By.id("username")).sendKeys("shiny@ati.com");

Thread.sleep(1000);
driver.findElement(By.id("password")).clear();
driver.findElement(By.id("password")).click();
driver.findElement(By.id("password")).sendKeys("apple123");
 

Thread.sleep(1000);
driver.findElement(By.id("Login")).submit();

Thread.sleep(3000);
WebElement Home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
Home.click();


 
/*Robot rob= new Robot();
rob.keyPress(KeyEvent.VK_ESCAPE);
rob.keyRelease(KeyEvent.VK_ESCAPE);
Thread.sleep(1000);*/

}
public static void CheckRemember() throws Exception {
driver.get("https://www.salesforce.com/");
Thread.sleep(1000);

//driver.manage().window().maximize();

WebDriverWait wait=new WebDriverWait (driver,5);
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Login')]"))));
driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();


WebDriverWait wait1=new WebDriverWait (driver,5);
wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));


driver.findElement(By.id("username")).click();
driver.findElement(By.id("username")).clear();
driver.findElement(By.id("username")).sendKeys("shiny@ati.com");

Thread.sleep(1000);
driver.findElement(By.id("password")).clear();
driver.findElement(By.id("password")).click();
driver.findElement(By.id("password")).sendKeys("apple123");

Thread.sleep(1000);
driver.findElement(By.id("rememberUn")).click();
 

Thread.sleep(1000);
driver.findElement(By.id("Login")).submit();

}
public static void ForgotPassword() throws Exception {
driver.get("https://www.salesforce.com/");
Thread.sleep(1000);

//driver.manage().window().maximize();

WebDriverWait wait=new WebDriverWait (driver,5);
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Login')]"))));
driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

Thread.sleep(1000);
WebElement Forgot=driver.findElement(By.id("forgot_password_link"));
Forgot.click();

Thread.sleep(1000);
WebElement user=driver.findElement(By.id("un"));
driver.findElement(By.id("un")).sendKeys("shiny@ati.com");
user.click();

Thread.sleep(1000);
WebElement cont=driver.findElement(By.id("continue"));
driver.findElement(By.id("continue")).submit();

Thread.sleep(1000);
WebElement ret=driver.findElement(By.xpath("//a[contains(text(),'Return to Login')]"));
driver.findElement(By.xpath("//a[contains(text(),'Return to Login')]")).click();
}
public static void WrongUserPassword() throws Exception {
driver.get("https://www.salesforce.com/");
Thread.sleep(2000);

//driver.manage().window().maximize();

WebDriverWait wait=new WebDriverWait (driver,5);
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Login')]"))));
driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

WebDriverWait wait1=new WebDriverWait (driver,5);
wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));


driver.findElement(By.id("username")).click();
driver.findElement(By.id("username")).clear();
driver.findElement(By.id("username")).sendKeys("123");

Thread.sleep(3000);
driver.findElement(By.id("password")).clear();
driver.findElement(By.id("password")).click();
driver.findElement(By.id("password")).sendKeys("22131");

Thread.sleep(3000);
driver.findElement(By.id("Login")).click();

}

public void explicitWaitFun(WebElement txtlogin) {
	// TODO Auto-generated method stub
	
}

public void explicitWaitFun1(WebElement Username) {
	// TODO Auto-generated method stub
	
}



public void loginToWebSite(String sUserName, String sPassword) {
	// TODO Auto-generated method stub
	
}

public void ufClickElement(String username) {
	// TODO Auto-generated method stub
	
}

public void ufClearElement(String username) {
	// TODO Auto-generated method stub
	
}

public void ufSendkeys(String username, String text) {
	// TODO Auto-generated method stub
	
}


}

