package com.tests.pack;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.pack.BaseClass;
import com.page.repos.LoginPage;

public class LoginTest extends BaseClass {
	
	// Inheriting LoginPage class to get elements of page class
	LoginPage lp;
	
	@BeforeTest
	public void launchBrowser() {
		//Calling setUp method from Base Class to launch browser
		setUp("chrome");
	}
		
	@Test
	public void testLogin() throws InterruptedException {
		// Declaring Login Page class object to call the elements 
		lp = new LoginPage(getDriver());
		// Passing the URL of the application under test
		driver.get("https://waypals.com/wpl/#LOGIN");
		// Implementing explicit wait by calling WebDriverWait from the BaseClass itself 
		// and waiting for the element to be located
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.username));
		// Entering username value to the respective field
		lp.enterUsername("mohit@waypals.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.password));
		// Entering password value to the respective field
		lp.enterPassword("waypals@1234");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.clickLogin));
		// Clicking on Login button
		lp.clickLoginBtn();
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown() {
		// Closing the browser and WebDriver session by calling quit method
		driver.quit();
	}
}
