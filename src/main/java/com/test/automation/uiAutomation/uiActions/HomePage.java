package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
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
	 * This method is required
	 * to initialize the web elements
	 * else we'll get the NullPointerException
	 */
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String email, String password){
		signIn.click();
		log.info("clicked on sign in and object is :- "+signIn.toString());
		loginEmail.sendKeys(email);
		log.info("entered email address is :- "+email + " and object is :-" +loginEmail.toString());
		loginPassword.sendKeys(password);
		log.info("entered password is :- "+password + " and object is :- " +loginPassword.toString());
		submitButton.click();
		log.info("clicked on submit button and object is :-" + submitButton.toString());
	}
	
	public String getInvalidLoginText(){
		log.info("error message is :- " + authenticationFailure.getText());
		return authenticationFailure.getText();
	}
}
