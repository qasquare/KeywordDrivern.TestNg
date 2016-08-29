package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public static WebDriver driver;
	
	@BeforeSuite
	public void launchDriver(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/BrowserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterSuite
	public void closeBrowser(){
		driver.quit();
	}
	

}
