package com.ae.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.ae.qa.context.WebDriverContext;
import com.ae.qa.report.ExtentReporter;
import com.ae.qa.util.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ReportListeners extends BaseTest implements ITestListener{

	ExtentReports extent=ExtentReporter.extentReportGenerator();
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
			
	@Override
	public void onTestStart(ITestResult result) {
		 test=extent.createTest(result.getClass().getName()+"-"+result.getMethod().getMethodName());
		 
		 //To set the created test to ExtentTest thread local
		 extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().pass(result.getClass().getName()+"-"+result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		extentTest.get().addScreenCaptureFromPath(getScreenshotpath(result.getTestClass().getName()+"-"+result.getMethod().getMethodName(),WebDriverContext.getDriver()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().skip(result.getClass().getName()+"-"+result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();	
	}
}
