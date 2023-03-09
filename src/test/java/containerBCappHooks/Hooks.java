package containerBCappHooks;

import org.openqa.selenium.OutputType;
import containerBCapp.ExcelRead.ExcelRead;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends ExcelRead {

	@After()
	public void screenShot(Scenario scenario) throws Throwable {

	final byte[] screenshot = IOsdriver.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "");
		
		

	}

}
