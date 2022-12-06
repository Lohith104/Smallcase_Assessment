package com.configuration;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter{
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("test started");
		super.onTestStart(result);
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println("test success");
		super.onTestSuccess(tr);
	}
	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println("test failed");
		super.onTestFailure(tr);
	}
	@Override
	public void onTestSkipped(ITestResult tr) {
		System.out.println("test skipped");
		super.onTestSkipped(tr);
	}

}
