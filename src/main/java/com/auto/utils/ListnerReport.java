package com.auto.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.auto.core.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ListnerReport extends BaseTest implements ITestListener {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext context) {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/testReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		context.setAttribute("WebDriver", this.driver);
	}
	
	public void onTestStart(ITestResult context) {
		logger = extent.createTest(context.getName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult context) {
		// TODO Auto-generated method stub
	}

	public void onTestFailure(ITestResult context) {
		logger.fail(context.getName() + " test case failed.");
		Object testClass = context.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
		try {
			logger.addScreenCaptureFromPath(WebUtil.getScreenShortPath(webDriver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult context) {
		logger.skip(context.getName() + " test case failed.");
	}

	

	public void onTestSuccess(ITestResult context) {
		logger.pass(context.getName() + " test case failed.");
	}

}
