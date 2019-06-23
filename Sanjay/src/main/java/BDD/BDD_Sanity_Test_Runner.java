package BDD;

import java.io.File;

import cucumber.api.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions( strict = true ,
		
		features = "classpath:C:\\Users\\abhinai.kummithi\\git\\Dev_local\\ccubeautomationscript\\src\\BDD\\BDD_POC.feature" ,
		plugin =  {"pretty:STDOUT","html:C:\\Users\\abhinai.kummithi\\git\\Dev_local\\ccubeautomationscript\\reports\\cucumber-pretty",
//				  "json:C:\\Users\\abhinai.kummithi\\git\\Dev_local\\ccubeautomationscript\\reports\\cucumber-json",
					"html:target/cucumber-html-report", "junit:target/cucumber-results.xml" , 
					"com.cucumber.listener.ExtentCucumberFormatter:C:\\Users\\abhinai.kummithi\\git\\Dev_local\\ccubeautomationscript\\reports\\cucumber-extent\\report.html"},
					
				glue={"src\\BDD_POC\\BDD_POC_StepDef.java"}

		,monochrome = true
		,dryRun = true
		
		)
public class BDD_Sanity_Test_Runner /* extends AbstractTestNGCucumberTests */
	 {
	
	@org.testng.annotations.AfterClass
	public static void testSetUp () {
		
		/*
		 * Reporter.loadXMLConfig(new File("src\\BDD_POC\\extent-config.xml"));
		 * Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		 * Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		 * Reporter.setTestRunnerOutput("Cucumber JUnit Test Runner ");
		 */
		
		
	}
	
}
