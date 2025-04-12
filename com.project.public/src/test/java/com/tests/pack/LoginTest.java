package com.tests.pack;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.base.pack.BaseClass;
import com.page.repos.LoginPage;

public class LoginTest extends BaseClass {
	
		
	@Test
	public void testLogin() throws InterruptedException {
		setUp("chrome");
		LoginPage lp = new LoginPage(getDriver());
		driver.get("https://waypals.com/wpl/#LOGIN");
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.username));
		lp.enterUsername("mohit@waypals.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.password));
		lp.enterPassword("waypals@1234");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.clickLogin));
		lp.clickLoginBtn();
		Thread.sleep(3000);
		driver.quit();
	}
}
