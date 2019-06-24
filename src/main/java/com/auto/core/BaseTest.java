package com.auto.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {
	public WebDriver driver = null;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\MyWrokSpace\\SeleniumHome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		driver.manage().deleteAllCookies();
		driver.close();
		
	}
	
	@AfterSuite
	public void cleanUp(){
		driver.quit();
	}

}
