package com.ae.qa.listeners;

import org.apache.log4j.pattern.LogEvent;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ae.qa.util.LogUtil;

/**
 * The listener interface for receiving log events. The class that is interested
 * in processing a log event implements this interface, and the object created
 * with that class is registered with a component using the component's
 * <code>addLogListener<code> method. When the log event occurs, that object's
 * appropriate method is invoked.
 *
 * @see LogEvent
 */

public class LogListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		LogUtil.info(result.getMethod().getMethodName() + " Started");
		LogUtil.info(result.getMethod().getDescription());
	}
	public void onTestSuccess(ITestResult result) {
		LogUtil.info(result.getMethod().getMethodName() + " Passed");				
	}
	public void onTestFailure(ITestResult result) {
		LogUtil.info("Failed because of - "+ result.getThrowable());		
	}
	public void onTestSkipped(ITestResult result) {
		LogUtil.info("Skipped because of - "+ result.getThrowable());		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub		
	}
	public void onStart(ITestContext context) {
		LogUtil.info("=========== onStart :-" + context.getName() + "===============");
		
	}
	public void onFinish(ITestContext context) {
		LogUtil.info("=========== onFinish :-" + context.getName() + "===============");
		
	}
}
