package com.ta.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
public class listeners implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test cases are failed and details are:" +result.getName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test cases are skipped and details are:" +result.getName());
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test cases started and details are:" +result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test cases are passed and details are:" +result.getName());
	}
	
	 
	

}
