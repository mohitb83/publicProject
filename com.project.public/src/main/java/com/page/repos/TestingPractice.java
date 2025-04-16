package com.page.repos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestingPractice {
	
	private WebDriver driver;
	
	public TestingPractice(WebDriver driver) {
		this.driver = driver;
	} 
	
	public By name = By.id("name");
	public By email = By.id("email");
	public By phone = By.id("phone");
	public By address = By.id("textarea");
	public By radio1 = By.id("male");
	public By radio2 = By.id("female");
	public By check1 = By.id("monday");
	public By check2 = By.id("tuesday");
	public By check3 = By.id("wednesday");
	public By check4 = By.id("thursday");
	public By check5 = By.id("friday");
	public By countyrDdown = By.id("country");
	public By selectCountry = By.id("country");
	public By colorsDdown = By.id("colors");
	public By animalsDdown = By.id("animals");
	public By datePicker1 = By.id("datepicker");
	public By datePicker2 = By.id("txtDate");
	public By dateStart = By.id("start-date");
	public By dateEnd = By.id("end-date");
	// public By countryValue = By.cssSelector("[value='india']");
	public By submit = By.cssSelector("button.submit-btn");

	public void enterName(String Name) {
		WebElement elem = driver.findElement(name);
		elem.sendKeys(Name);
	}
	public void enterEmail(String Email) {
		WebElement elem = driver.findElement(email);
		elem.sendKeys(Email);
	}
	public void enterPhone(String Phone) {
		WebElement elem = driver.findElement(phone);
		elem.sendKeys(Phone);
	}
	public void enterAddress(String Address) {
		WebElement elem = driver.findElement(address);
		elem.sendKeys(Address);
	}
	
	public void selectRadio1() {
		WebElement elem = driver.findElement(radio1);
		elem.click();
	}
	public void clickCheck1() {
		WebElement elem = driver.findElement(check1);
		elem.click();
	}
	public void clickCheck2() {
		WebElement elem = driver.findElement(check2);
		elem.click();
	}
	public void clickCheck3() {
		WebElement elem = driver.findElement(check3);
		elem.click();
	}
	public void clickCheck4() {
		WebElement elem = driver.findElement(check4);
		elem.click();
	}
	public void clickCheck5() {
		WebElement elem = driver.findElement(check5);
		elem.click();
	}
	
	public void selectCountry(String myCountry) {
		Select select = new Select(driver.findElement(selectCountry));
		select.selectByValue(myCountry);
	}
	
	public void selectColor(String color) {
		Select select = new Select(driver.findElement(selectCountry));
		select.selectByValue(color);
	}
	
	public void selectAnimals(String animal) {
		Select select = new Select(driver.findElement(selectCountry));
		select.selectByValue(animal);
	}
	
	public void addDate1(String date1) {
		WebElement elem = driver.findElement(datePicker1);
		elem.sendKeys(date1);
	}
	
	public void addDate2(String date2) {
		WebElement elem = driver.findElement(datePicker2);
		elem.sendKeys(date2);
	}
	
	public void addDateStart(String date3) {
		WebElement elem = driver.findElement(dateStart);
		elem.sendKeys(date3);
	}
	
	public void addDateEnd(String date4) {
		WebElement elem = driver.findElement(dateEnd);
		elem.sendKeys(date4);
	}
	
	public void clickSubmit() {
		WebElement elem = driver.findElement(submit);
		elem.click();
	}
}
