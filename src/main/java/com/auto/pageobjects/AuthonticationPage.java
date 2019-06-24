package com.auto.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auto.core.BasePage;

public class AuthonticationPage extends BasePage{

	public AuthonticationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="#email")
	private WebElement emailtxt;
	public void enterEmail(String email){
		emailtxt.clear();
		emailtxt.sendKeys(email);
	}
	
	
	@FindBy(css="#passwd")
	private WebElement passwdtxt;
	public void enterPassword(String passwd){
		passwdtxt.clear();
		passwdtxt.sendKeys(passwd);
	}
	
	
	@FindBy(css="#SubmitLogin")
	private WebElement signInbtn;
	public void clickOnSignIn(){
		signInbtn.click();
	}

}
