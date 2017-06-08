package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(className = "login")
	WebElement signIn;

	@FindBy(id="email")
	WebElement loginEmail;
	
	@FindBy(id="passwd")
	WebElement loginPassword;
	
	@FindBy(css="#SubmitLogin")
	WebElement submitButton;
	
	@FindBy(css=".alert.alert-danger>ol>li")
	WebElement authenticationFailure;
	
	
	/**
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String email, String password){
		signIn.click();
		loginEmail.sendKeys(email);
		loginPassword.sendKeys(password);
		submitButton.click();
	}
	
	public String getInvalidLoginText(){
		return authenticationFailure.getText();
	}
}
