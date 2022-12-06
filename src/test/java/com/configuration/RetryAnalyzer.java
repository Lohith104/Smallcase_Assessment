package com.configuration;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int failed=0;
	int count =3;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if (failed<count) {
			failed++;
			return true;
		}
		return false;
	}

}
