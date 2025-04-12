package com.tests.pack;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.pack.BaseClass;
import com.page.repos.TestingPractice;

public class DifferentElements extends BaseClass{
	
	TestingPractice tp;
	
	@BeforeTest
	public void launchBrowser() {
		setUp("chrome");
	}
	
	@Test
	public void fill_N_SubmitForm() throws InterruptedException{
		tp = new TestingPractice(getDriver());
		driver.get("https://testautomationpractice.blogspot.com/");
		// https://rahulshettyacademy.com/AutomationPractice/
		wait.until(ExpectedConditions.visibilityOfElementLocated(tp.name));
		tp.enterName(prop.getProperty("name"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tp.email));
		tp.enterEmail(prop.getProperty("email"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tp.phone));
		tp.enterPhone(prop.getProperty("phone"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tp.address));
		tp.enterAddress(prop.getProperty("address"));
		tp.selectRadio1();
		tp.clickCheck1();
		tp.clickCheck2();
		tp.clickCheck3();
		tp.clickCheck4();
		tp.clickCheck5();
		tp.selectCountry(prop.getProperty("country"));
		Thread.sleep(2000);
		//Color and Animals to be selected
		// Fetch values from dropdowns and print
		tp.clickSubmit();	
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
