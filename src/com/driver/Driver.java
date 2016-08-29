package com.driver;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.utility.GenerateReport;
import com.utility.ReadExcel;

public class Driver {

	public static void main(String[] args) {

		String moduleName, runData;
		GenerateReport.generateReport();

		XmlSuite myXmlSuite = new XmlSuite();
		myXmlSuite.setName("My Dynamic TestSuite");

		XmlTest myTest = new XmlTest(myXmlSuite);
		myTest.setName("My Test");
		myTest.addParameter("browser", "firefox");
		List<XmlClass> myClasses = new ArrayList<XmlClass>();
		String testSuiteName = System.getProperty("user.dir") + "/Controller.xls";

		Object[][] testData = ReadExcel.ExcelReader(testSuiteName, "Sheet1");
		for (Object[] objects : testData) {
			moduleName = (String) objects[0];
			runData = (String) objects[1];
			if (runData.equals("Y")) {
				myClasses.add(new XmlClass("com.driver." + moduleName));
			}
		}

		myTest.setXmlClasses(myClasses);
		List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		mySuites.add(myXmlSuite);

		System.out.println(myXmlSuite.toXml());

		TestNG testNg = new TestNG();
		testNg.setXmlSuites(mySuites);
		testNg.run();

	}

}
