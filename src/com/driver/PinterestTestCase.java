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

public class PinterestTestCase extends BaseClass{
	/**
	 * Main Driver method that will drive the execution
	 * 
	 * @param args
	 */
	
	String testSuiteFile = System.getProperty("user.dir") + "/TestSuites/FirstTestSuite.xls";
	KeywordExecutor executor = new KeywordExecutor();
	String testSheetName = this.getClass().getSimpleName();
	ExtentTest test;
	String stepExecutionResult[];
	
	@BeforeClass()
	public void beforeTestMethod(){
		 test = GenerateReport.reporter.startTest(testSheetName+"_TestCase");
	}
	
	@Test(dataProvider = "driverMethodData")
	public void driverMethod(String keyword, String locator, String inputData, String purpose) {
		
		stepExecutionResult = executor.execute(driver, keyword, locator, inputData).split("::");
		System.out.println(stepExecutionResult[0] +" - "+ stepExecutionResult[1]);
		if(stepExecutionResult[0].toUpperCase().contains("PASS")){
			test.log(LogStatus.PASS, keyword +" - "+ purpose, stepExecutionResult[1]); 
		}
		else if(stepExecutionResult[0].toUpperCase().contains("FAIL")){
			test.log(LogStatus.FAIL, keyword+" - "+ purpose, stepExecutionResult[1]);
		}
	}
	
	@DataProvider
	public Object[][] driverMethodData() {
		Object testData[][] = ReadExcel.ExcelReader(testSuiteFile, testSheetName);
		for (Object[] objects : testData) {
			for (Object object : objects) {
				System.out.println(object);
			}
		}
		return testData;
	}
	
	@AfterClass
	public void closeTest(){
		GenerateReport.reporter.endTest(test);
		GenerateReport.reporter.flush();
		
	}
	
	
	

}