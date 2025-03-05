package com.main.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer  implements IRetryAnalyzer{
	
	int count=0;
	int trLimit=1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count < trLimit) {
			count++;
			return true;
		}
		return false;
	}

}
