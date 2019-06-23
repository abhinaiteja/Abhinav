package BDD;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(CustomRunner.class)
@CucumberOptions(features = "Demo.feature", glue = { "classpath:BDD" },
//strict = true,

		monochrome = true
//		dryRun = true

)
public class Test_Runner {

}