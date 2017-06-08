package com.test.automation.uiAutomation.homepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.uiActions.HomePage;


public class TC001_VerifyLoginWithInvalidCredentials {
	
	WebDriver driver;
	HomePage homepage;
	
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}

	@Test
	public void verifyLoginWithInvalidCredentials(){
		homepage = new HomePage(driver);
		homepage.loginToApplication("test@gmail.com", "password");
		Assert.assertEquals(homepage.getInvalidLoginText(), "Authentication failed.");
	}
	
	@AfterTest
	public void end(){
		driver.close();
	}

}
