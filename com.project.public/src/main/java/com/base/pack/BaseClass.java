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

import com.util.pack.TimeOuts;

public class BaseClass {
	
	protected Properties prop;
	public WebDriver driver;
	static String browser1 = "chrome"; 
	static String browser2 = "firefox";
	static String browser3 = "edge";
	static TimeOuts time = new TimeOuts();
	
	
	
	public BaseClass() {
		try {
			FileInputStream fis = new FileInputStream("D:\\projectForGit\\com.project.public\\src\\main\\java\\config.properties");
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
		
		if(browser.equalsIgnoreCase(browser1)) {
			ChromeOptions opts = new ChromeOptions();
			opts.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(opts);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time.page_load_time));
		} else if(browser.equalsIgnoreCase(browser2)) {
			FirefoxOptions opts = new FirefoxOptions();
			opts.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(opts);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time.page_load_time));
		}else if (browser.equalsIgnoreCase(browser3)){
			EdgeOptions opts = new EdgeOptions();
			opts.setAcceptInsecureCerts(true);
			driver = new EdgeDriver(opts);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time.page_load_time));
		}
		else {
			System.out.println("No browser found");
		}
	}
	public WebDriver getDriver() {
		return driver;
	}
}
