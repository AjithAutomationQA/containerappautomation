package containerBCapp.EngineRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

tags = "@Smoke",

features = {"FeatureFiles"},  
glue = {"containerBCappStepDefinition", "containerBCappHooks"}
)

public class RunnerClass extends AbstractTestNGCucumberTests {

	
}






