package com.utility;

import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.ExtentReports;

public class GenerateReport {
	public static ExtentReports reporter;

	public static void generateReport() {
		reporter = new ExtentReports(System.getProperty("user.dir") + "/Reports/DataDrivenReport.html", false);
		
	}
	
	@AfterSuite
	public void closeReport(){
		reporter.close();
	}

}
