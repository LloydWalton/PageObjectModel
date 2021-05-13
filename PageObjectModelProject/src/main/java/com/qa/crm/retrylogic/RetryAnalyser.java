package com.qa.crm.retrylogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.qa.crm.testbase.TestBase;

public class RetryAnalyser extends TestBase implements IRetryAnalyzer  {
	
	int counter=0;
	int retryLimit=Integer.parseInt(prop.getProperty("RetryLimit"));
	
	public boolean retry(ITestResult result)
	{
		if(counter<retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}
	

}
