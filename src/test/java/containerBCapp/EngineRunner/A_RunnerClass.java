package containerBCapp.EngineRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
"rerun:target/FailedScenarios.txt"},

tags = "@test",

features = {"FeatureFiles"},  
glue = {"containerBCappStepDefinition", "containerBCappHooks"}, dryRun = false

		)

public class A_RunnerClass extends AbstractTestNGCucumberTests {


}






