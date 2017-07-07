package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(css="#email_create")
	WebElement createEmail;
	
	@FindBy(id="SubmitCreate")
	WebElement submitCreate;
	
	@FindBy(css="#id_gender1")
	WebElement mrRadioBtn;
	
	@FindBy(css="#id_gender2")
	WebElement mrsRadioBtn;
	
	@FindBy(id="customer_firstname")
	WebElement firstName;
	
	@FindBy(id="customer_lastname")
	WebElement lastName;
	
	@FindBy(css="#passwd")
	WebElement password;
	
	@FindBy(id="days")
	WebElement dobDays;
	
	@FindBy(id="months")
	WebElement dobMonth;
	
	@FindBy(id="years")
	WebElement dobYear;
	
	@FindBy(id="newsletter")
	WebElement newsletter;
	
	@FindBy(id="optin")
	WebElement offers;
	
	@FindBy(id="firstname")
	WebElement addrFirstName;
	
	@FindBy(id="lastname")
	WebElement addrLastName;
	
	@FindBy(id="company")
	WebElement addrCompany;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="address2")
	WebElement address2;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement zip;
	
	@FindBy(id="id_country")
	WebElement country;
	
	@FindBy(id="other")
	WebElement additionalInfo;
	
	@FindBy(id="phone")
	WebElement homePhone;
	
	@FindBy(id="phone_mobile")
	WebElement mobilePhone;
	
	@FindBy(id="alias")
	WebElement addrAlias;
	
	@FindBy(id="submitAccount")
	WebElement registerUser;
	
	@FindBy(css=".logout")
	WebElement logout;
	
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
	
	public void registerUser(){
		signIn.click();
		log.info("clicking on sign in button and object is:- " + signIn.toString());
		
		createEmail.sendKeys("ram1@gmail.com");
		log.info("providing signup email and object is:- " + createEmail.toString());
		
		submitCreate.click();
		log.info("clicking on create account button and object is:- "+ submitCreate.toString());
		
		mrRadioBtn.click();
		log.info("selecting the Mr. title and object is:- "+ mrRadioBtn.toString());
		
		firstName.sendKeys("Ram");
		log.info("providing first name and object is:- " + firstName.toString());
		
		lastName.sendKeys("Sharma");
		log.info("providing last name and object is:- " + lastName.toString());
		
		password.sendKeys("password");
		log.info("providing the password and object is:- " + password.toString());
		
		Select days = new Select(dobDays);
		days.selectByValue("2");
		log.info("selecting the days of dob and object is:- " + dobDays.toString());
		
		Select month = new Select(dobMonth);
		month.selectByValue("8");
		log.info("selecting the month of dob and object is:- " + dobMonth.toString());
		
		Select year = new Select(dobYear);
		year.selectByValue("1988");
		log.info("selecting the year of dob and object is:- " + dobYear.toString());
		
		//addrFirstName.sendKeys("Suyash");
		//addrLastName.sendKeys("Nande");
		
		addrCompany.sendKeys("TCS");
		log.info("providing company name and object is:- " + addrCompany.toString());
		
		address1.sendKeys("9547 D UT Drive");
		log.info("providing the address and object is:- " + address1.toString());
		
		city.sendKeys("Charlotte");
		log.info("providing the city and object is:- " + city.toString());
		
		Select stateAddr = new Select(state);
		stateAddr.selectByVisibleText("North Carolina");
		log.info("selecting the state and object is:- " + state.toString());
		
		zip.sendKeys("28262");
		log.info("providing the zip code and object is:- " + zip.toString());
		
		Select countryAddr = new Select(country);
		countryAddr.selectByVisibleText("United States");
		log.info("selecting the country and object is:- " + country.toString());
		
		mobilePhone.sendKeys("9803650362");
		log.info("providing the mobile number and object is:- " + mobilePhone.toString());
		
		addrAlias.sendKeys("Home Address");
		log.info("providing the address alias and object is:- " + addrAlias);
		
		registerUser.click();
		log.info("clicking on register user button and object is: " + registerUser.toString());
	}
	
	public Boolean assertSuccessfulLogin(){
		return logout.isDisplayed();
	}
}
