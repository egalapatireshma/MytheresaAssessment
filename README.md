# Selenium-Java-Page Object Model with BDD Framework

A Maven framework with BDD and page object model to build Selenium tests written Java. Implemented basic HTML/JSON reports as well as integrated cucumber reports to view the test results.

## Prerequisites

Download and install Java, Eclipse IDE. 
Setup Maven in your machine.
Make sure Eclipse marketplace has "Cucumber Eclipse Plugin" and "Natural" installed.
Copy the repo into your local machine.

### Features Implemented

##### POM.xml file configurations
	Added all the required JUnit, cucumber and Selenium dependencies to the POM.xml to support the BDD annotations, JUnit and webdriver commands.
	
##### Different Browser configurations (like Chrome, Safari etc) added to DriverFactory.
	Under DriverFactory created a generic method to support testing on different browsers if required in future. Currently the tests are performed on chromeDriver. Chromedriver.exe is already placed in Drivers folder.
	In case if we wanted to test on different browser, we can download the respective "exe" file and place it under Driver folder. Make sure to pass the browser configuration in the config.properties file.

##### Maintenance of Feature files and step definitions to achieve BDD framework.
	To achieve BDD framework created separate packages for Feature files and their respective Steps definitions. To link the Features to the Steps definitions, created a TestRunner class configured with path to Feature files folder. 
	
##### Page Object Model with page factory for identifying locators.
	All the files are maintained at page level. We have different folder structures - Step definitions, Test, Pages.
		Step Definitions - Classes under this package deals with implementation of methods specific to the feature files.
		Test - Classes under this package deals with validations and assertions of the functionalities to be tested.
		Pages - Classes under this package has all the locators needed on the specific page.

##### Taking screenshot on failure.
     When there is a failure in any specific step, screenshots will be automatically taken and stored under target/screenshots folder. Along with this the screenshot will also be attached to the respective HTML and cucumber reports.
     
##### Run tests locally
	 Go to stepDefinitions folder. Right click the TestRunner file and select "Run as JUnit test" to start the test.


##### Parallel test execution support
     The project is configured to run the tests in parallel. Added maven-compiler and maven-surefire plugins to support Parallel execution at feature file level. The number of features that will be executed at the same time is configurable in POM.xml or can be deactivated if required. In order to perform parallel execution, follow the below steps. Browsers will be launched based on the number of feature files and thread count.
      -> Open Terminal -> Navigate to the project folder using "cd <Project_path>" -> Enter "mvn verify".

##### Centralized Project Config
     All the global configurations are maintained in the properties file (resources/config/config.properties) and can be adjusted. In case if we want to access the URL based on the environment, just update the environment accordingly in the file. It gives you the possibility of handling global project behaviour in one place without messing with other project or setup specific code. Furthermore all properties can be overridden via system properties.
      
##### Assertions and waits to handle the web elements
	Testing web applications that are asynchroniously loading parts of the page can be hard to test in Selenium. So, FluentWait times has been added to handle the availability of web elements and to perform necessary assertions and actions on the elements.
	 
##### Test Execution Reports
	Inbuilt Cucumber reports has been added using the cucumber.properties file by setting the "cucumber.publish.enabled" to true. Apart from that TestRunner is configured to generate basic HTML, JSON and XML reports under "Target" folder.
	 
##### Sample Reports On Success And Failure:

![alt text](https://github.com/egalapatireshma/ZooplusAssessment/blob/main/target/SampleReports/Screenshot%202022-05-04%20at%204.59.35%20PM.png)

![alt text](https://github.com/egalapatireshma/ZooplusAssessment/blob/main/target/SampleReports/Screenshot%202022-05-04%20at%204.59.02%20PM.png)

![alt text](https://github.com/egalapatireshma/ZooplusAssessment/blob/main/target/SampleReports/Screenshot%202022-05-04%20at%204.59.11%20PM.png)
