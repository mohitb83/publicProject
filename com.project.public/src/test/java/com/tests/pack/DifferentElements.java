package com.tests.pack;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
		
		// Capturing all values of dropdowns and then printing the same
		// Dropdown 1. Country
		// Dropdown 2. Colors
		// Dropdown 3. Animals
		List<WebElement> countryy = driver.findElements(tp.countyrDdown);
		ArrayList<String> coutryArray = new ArrayList<>();
		for(WebElement count: countryy) {
			coutryArray.add(count.getText());
		}
		// Printing dropdown values
		System.out.println("Country Names are: "+coutryArray);
		
		List<WebElement> sortedList = driver.findElements(tp.colorsDdown);
		ArrayList<String> values = new ArrayList<>();
		for(WebElement opts: sortedList) {
			values.add(opts.getText());
		}
		WebElement elem = driver.findElement(tp.animalsDdown);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView", elem);
		System.out.println(" ");
		
		// Printing dropdown values
		System.out.println("Dropdown values: "+values);
		// values.forEach(System.out::println);
		List<WebElement> sorted = driver.findElements(By.xpath("//*[@id=\"colors\"]"));
		ArrayList<String> animals = new ArrayList<>();
		for(WebElement jeev: sorted) {
			animals.add(jeev.getText());
		}
		System.out.println(" ");
		// Printing dropdown values
		System.out.println("Animal names are: "+ animals);
		// Selction of dropdown values with the help of select class SelectByValue method
		wait.until(ExpectedConditions.visibilityOfElementLocated(tp.animalsDdown)).click();
		tp.selectAnimals(prop.getProperty("animal"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tp.colorsDdown)).click();
		tp.selectAnimals(prop.getProperty("color"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tp.datePicker1));
		tp.addDate1(prop.getProperty("date1"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tp.datePicker2));
		tp.addDate2(prop.getProperty("date2"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tp.dateStart));
		tp.addDateStart(prop.getProperty("dateStart"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tp.dateEnd));
		tp.addDateEnd(prop.getProperty("dateEnd"));
		Thread.sleep(2000);
		//Color and Animals to be selected
		// Fetch values from dropdowns and print
		tp.clickSubmit();	
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
