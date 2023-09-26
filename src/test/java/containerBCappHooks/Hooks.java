package containerBCappHooks;

import containerBCapp.Baseclass.CommonUtilities;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import containerBCapp.ExcelRead.ExcelRead;

public class Hooks extends CommonUtilities {


    @BeforeAll
    public static void xxx() throws Throwable {
        lauchTheApp();
    }

    @After()
    public void screenShot(Scenario scenario) throws Throwable {

        byte[] screenshotBytes = IOsdriver.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotBytes, "image/png", "");
        killAndRelaunch();

    }

    @AfterAll
    public static void afterAll() {
//		service.stop();
//		if(sa != null) {
//			sa.assertAll();
//		}
    }

}
