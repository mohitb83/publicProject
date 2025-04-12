package com.page.repos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
	
	public By username = By.xpath("//input[@class='input_textarea']");
	public By password = By.xpath("/html/body/div/div[2]/div/div/div/div[3]/input");
	public By clickLogin = By.xpath("/html/body/div/div[2]/div/div/div/div[4]/div/button");
	
	public void enterUsername(String userN) {
		WebElement element = driver.findElement(username);
		element.sendKeys(userN);
	}
	
	public void enterPassword(String passW) {
		WebElement element = driver.findElement(password);
		element.sendKeys(passW);
	}
	
	public void clickLoginBtn() {
		driver.findElement(clickLogin).click();
	}
}
