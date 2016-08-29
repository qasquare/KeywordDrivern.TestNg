package com.driver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.operation.KeywordExecutor;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.BaseClass;
import com.utility.GenerateReport;
import com.utility.ReadExcel;

public class SeleniumTestCase extends BaseClass {
	
	/**
	 * Main Driver method that will drive the execution
	 * 
	 * @param args
	 */
	
	String testSuiteFile = System.getProperty("user.dir") + "/TestSuites/FirstTestSuite.xls";
	KeywordExecutor executor = new KeywordExecutor();
	String testSheetName = this.getClass().getSimpleName();
ExtentTest test;
	
	@BeforeClass()
	public void beforeTestMethod(){
		 test = GenerateReport.reporter.startTest(testSheetName+"_TestCase");
	}
	
	@Test(dataProvider = "driverMethodData")
	public void driverMethod(String keyword, String locator, String inputData) {
   
		executor.execute(driver, keyword, locator, inputData);
		test.log(LogStatus.PASS, keyword,"This testcase Pass");

	}
	
	@DataProvider
	public Object[][] driverMethodData() {
		Object testData[][] = ReadExcel.ExcelReader(testSuiteFile, testSheetName);
		return testData;
	}
	
	@AfterClass
	public void closeTest(){
		GenerateReport.reporter.endTest(test);
		GenerateReport.reporter.flush();
		
	}

}
