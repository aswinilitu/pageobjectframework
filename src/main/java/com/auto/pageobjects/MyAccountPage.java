package com.auto.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auto.core.BasePage;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath=".//*[@id='center_column']/p")
	private WebElement myAccountWelcomeText;
	public String getMyAccountWelcomeText(){
		return myAccountWelcomeText.getText();
	}

}
