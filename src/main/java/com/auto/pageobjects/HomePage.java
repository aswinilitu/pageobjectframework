package com.auto.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auto.core.BasePage;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css=".login")
	private WebElement btnSignIn;	
	public void clickOnSignIn(){
		btnSignIn.click();
	}
	
	@FindBy(css="#contact-link>a")
	private WebElement btnContactUs;
	public void clickOnContactUs(){
		btnContactUs.click();
	}

}
