package containerBCapp.EngineRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { 
"rerun:target/FailedScenarios.txt", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

tags = "@Login1",

features = {"FeatureFiles"},  
glue = {"containerBCappStepDefinition", "containerBCappHooks"}, dryRun = false

		)

public class A_RunnerClass extends AbstractTestNGCucumberTests {

}