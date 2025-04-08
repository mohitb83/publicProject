package com.tests.pack;

import org.testng.annotations.Test;

import com.base.pack.BaseClass;

public class SampleTest extends BaseClass {
	
	public SampleTest() {
		super();
	}
	
	@Test
	public void sampleTest() throws InterruptedException {
	setUp("edge");
	Thread.sleep(1000);
	driver.get(prop.getProperty("testUrl"));
	Thread.sleep(3000);
	System.out.println("Sample test run is passed");
	driver.quit();
	}
}
