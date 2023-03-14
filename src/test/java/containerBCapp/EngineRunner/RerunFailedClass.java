package containerBCapp.EngineRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/FailedScenarios.txt"},


features = {"@target/FailedScenarios.txt"},  
glue = {"containerBCappStepDefinition", "containerBCappHooks"}

)

public class RerunFailedClass extends AbstractTestNGCucumberTests{

}
