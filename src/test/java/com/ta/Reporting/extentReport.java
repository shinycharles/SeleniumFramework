package com.ta.Reporting;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
//import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mongodb.MapReduceCommand.OutputType;
import com.relevantcodes.extentreports.LogStatus;
import com.ta.salesforce.testcases.BaseClass;

public class extentReport extends BaseClass{
	private static final org.openqa.selenium.OutputType<File> OutputType = null;
	static int count=0;
	@Test(dataProvider = "loginUserDataDetails")
	public void logingIntoBrowserTWithTestData(String sUserName, String sPassword, String sXpath) throws Exception{
		count++;
		logger = reports.startTest("logingIntoBrowserWithTestData_"+count);
		SaleUtil.loginToWebSite(sUserName,sPassword);
		logger.log(LogStatus.INFO, "Login button clicked");
		//Thread.sleep(2000);
		SaleUtil.explicitWaitFun(driver.findElement(By.xpath(sXpath.trim())));
		AssertJUnit.assertEquals(driver.findElement(By.xpath(sXpath.trim())).isDisplayed(), true);
		//logger.log(LogStatus.PASS, "Test case is passed");
		
		// taking screenshot using selenium - 
		TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
		File source = ts.getScreenshotAs(OutputType .FILE);//Takes the screenshot and saving it to surce object
		//source which we saved is not physically saved. but it is there in the object
		String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_"+"logingIntoBrowserWithTestData_"+count+".png";
		File dest = new File(sPathOFScreenshot);
		FileUtils.copyFile(source, dest);
		logger.log(LogStatus.INFO, "Test case is passed");
		logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOFScreenshot));
		reports.endTest(logger);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
	
	@DataProvider(name="loginUserDataDetails")
	public Object[][] getDataForLogin() throws Exception{
		
		return new Object[][] {{"shiny@ati.com","apple123","//a[contains(text(),'Login')]"}};
		
	}
}