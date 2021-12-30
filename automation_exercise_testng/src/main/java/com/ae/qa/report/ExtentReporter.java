package com.ae.qa.report;

import com.ae.qa.context.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	static ExtentSparkReporter reporter;
	static ExtentReports extentReports;
	
	public static ExtentReports extentReportGenerator()
	{
		reporter=new ExtentSparkReporter(Constants.report_directory);
		reporter.config().setReportName("Automation Exercise Results");
		reporter.config().setDocumentTitle("Web Test Results");
		
		extentReports=new ExtentReports();
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo(Constants.role,Constants.author);
		
		return extentReports;
	}
}