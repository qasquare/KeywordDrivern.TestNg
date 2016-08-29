package com.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestMethods {
	/**
	 * Method to CLICK on an Object
	 * 
	 * @param driver
	 * @param locator
	 */
	public String click(WebDriver driver, String locator) {
		
		String result;
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			if (element != null) {
				element.click();
				result = "Pass :: Successfully clicked";
			} else {
				System.out.println("Element not available");
				result = "Fail :: Element not available";
			}
		} catch (NoSuchElementException e) {
			result = "Failed :: Element not available - " + e;
		}
		System.out.println("Click Methods result is " + result);
		return result;
	}

	/**
	 * Method to launch AUT Site
	 * 
	 * @param driver
	 * @param URL
	 */
	public String openUrl(WebDriver driver, String URL) {
		driver.get(URL);
		return "Pass :: Successfully Launched URL " + URL;
	}

	/**
	 * Method to enter some data inside textbox. text area
	 * 
	 * @param driver
	 * @param locator
	 * @param inputData
	 * @return
	 */
	public String enterText(WebDriver driver, String locator, String inputData) {
		
		try{
			WebElement element = driver.findElement(By.xpath(locator));	
		if (element != null) {
			element.sendKeys(inputData);
			return "Pass :: Successfullly entered " + inputData + " text";
		} else {
			System.out.println("Element not available");
			return "Failed :: Element not available";
			
			
		}
		}catch (NoSuchElementException e){
			return "Failed::"+ e;
		}
	}

	/**
	 * Method to Verify if text is matching with expected text message
	 * 
	 * @param driver
	 * @param locator
	 * @param textToVerify
	 * @return
	 */
	public String verifyText(WebDriver driver, String locator, String textToVerify) {

		WebElement element = driver.findElement(By.xpath(locator));
		if (element != null) {
			if (textToVerify.equalsIgnoreCase(element.getText())) {
				System.out.println("Text is matching");
				return "Passed :: Text is matching";
			} else {
				System.out.println("Text is not matching");
				return "Failed :: Text is not matching";

			}
		} else {
			System.out.println("Element not available");
			return "Failed :: Element not available";
		}
	}

}
