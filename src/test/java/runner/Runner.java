package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features= {"src/test/java/features/Validation.feature"},
	glue= {"stepDefinitions","hooks"}
   )

public class Runner extends AbstractTestNGCucumberTests{

}
