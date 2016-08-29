# Selenium Framework
Keyword Driven Framework using Selenium + Java + TestNG.
Reporting feature using Extent Reports.
Taking Screenshots on Failed test cases and also upon specifying on Test Step. 

This a a demonstration of how one can create an Advanced Keyword Driven Framework using Selenium and Java+TestNg. 

#Components

1. Driver class - Main class to execute project as a Java Application

2. TestSuites/FirstTestSuites.xls - Test Case file with three columns

    - Keyword (Action to be performed)
    - Locator (Object Locator - Please use xpath locator)
    - Input Data - Test Data
    
3. TestMethods class - A keyword library that contains all the methods to be executed against respective keyword. I have added 4 methods only as of now for the demo purpose. You can add more method if you want to add more keywords.

4. KeywordExecutor Class - This class will take Keyword as an argument and execute respective Testmethod. Please add an entry of new keyword as and when you add a new method.leyword in TestMethod.class

5. Utility - This package contans all the required Utility Class Files.

6. Report Generator - This class will be used to read data at each step and generate report accordingly.  

    
To use this framework, please edit FirstSuite.xls file, provide URL in first step and it will launch that website in your chrome bowser. 

Thanks,
QaSquare
