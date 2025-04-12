package com.base.pack;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.pack.Utilities;

public class BaseClass {
	
	protected Properties prop;
	protected WebDriver driver;
	protected WebDriverWait wait ;

	public BaseClass() {
		try {
			FileInputStream fis = new FileInputStream(Utilities.propFilePath);
			prop = new Properties();
			prop.load(fis);
			System.out.println("Property file is loaded");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Property file is not loaded");
		}
	}
	
	public void setUp(String browser) {
		
		if(browser.equalsIgnoreCase(prop.getProperty("browser1"))) {
			ChromeOptions opts = new ChromeOptions();
			opts.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(opts);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.page_load_time));
			wait  = new WebDriverWait(driver, Duration.ofSeconds(20));
			System.out.println("Chrome browser is launched");
		} else if(browser.equalsIgnoreCase(prop.getProperty("browser2"))) {
			FirefoxOptions opts = new FirefoxOptions();
			opts.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(opts);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.page_load_time));
			wait  = new WebDriverWait(driver, Duration.ofSeconds(20));
			System.out.println("Firefox browser is launched");
		}else if (browser.equalsIgnoreCase(prop.getProperty("browser3"))){
			EdgeOptions opts = new EdgeOptions();
			opts.setAcceptInsecureCerts(true);
			driver = new EdgeDriver(opts);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.page_load_time));
			wait  = new WebDriverWait(driver, Duration.ofSeconds(20));
			System.out.println("Edge browser is launched");
		}
		else {
			System.out.println("No browser found");
		}
	}
	public WebDriver getDriver() {
		return driver;
	}
}
