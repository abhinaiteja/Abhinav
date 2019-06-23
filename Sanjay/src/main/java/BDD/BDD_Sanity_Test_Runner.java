package BDD;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(CustomRunner.class)
@CucumberOptions(features = "BDD/BDD_POC.feature", glue = {
		"classpath:BDD" }, strict = true,

		monochrome = true, dryRun = true

)
public class BDD_Sanity_Test_Runner /* extends AbstractTestNGCucumberTests */
{

}