package com.auto.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auto.core.BaseTest;
import com.auto.pageobjects.AuthonticationPage;
import com.auto.pageobjects.HomePage;
import com.auto.pageobjects.MyAccountPage;

public class SignInTest extends BaseTest{
	private HomePage homePage;
	private AuthonticationPage authPage;
	private MyAccountPage myAccount;
	
	
	@DataProvider(name="credential")
	public String[][] getCredential(){
		return new String[][] {{"aswini.li2@gmail.com","1qaz!QAZ"},{"aswini","baliarsingh"}};
	}
	
	@Test(dataProvider="credential")
	public void signIn(String uname,String pwd){
		//logger.info("STEP-1: Open url.");
		driver.get("http://automationpractice.com");
		homePage=new HomePage(driver);
		//logger.info("STEP-2: Click on sign in button.");
		homePage.clickOnSignIn();
		authPage=new AuthonticationPage(driver);
		//logger.info("STEP-3: Enter all credentials.");
		authPage.enterEmail(uname);
		authPage.enterPassword(pwd);
		//logger.info("STEP-4: Click on login button.");
		authPage.clickOnSignIn();
		myAccount=new MyAccountPage(driver);
		//logger.info("STEP-5: Verify login message.");
		Assert.assertEquals(myAccount.getMyAccountWelcomeText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
		
	}
	

}
