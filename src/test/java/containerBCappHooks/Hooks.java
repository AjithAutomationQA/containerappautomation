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
	public static  void xxx() throws Throwable {
		lauchTheApp();
	}

	@After()
	public void screenShot(Scenario scenario) throws Throwable {


		//		TakesScreenshot ts = (TakesScreenshot) IOsdriver;
		//		String screenshot = ts.getScreenshotAs(OutputType.BASE64); 
		//		screenshot = screenshot.replaceAll("[^A-Za-z0-9+/]", ""); 
		//		byte[] ss = Base64.getDecoder().decode(screenshot);
		//		scenario.attach(ss, "image/png", "Refer");

		//		 File screenshotBytes = IOsdriver.getScreenshotAs(OutputType.FILE);
		//	
		//		 byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(screenshotBytes));
		//		 
		//		String base64EncodedScreenshot =  new String(encoded, StandardCharsets.US_ASCII);
		//		scenario.attach(base64EncodedScreenshot, "image/png", "");


		//		final String Screenshot = IOsdriver.getScreenshotAs(OutputType.BASE64);
		//		scenario.attach(Screenshot,"image/png","BASE64");


		byte[] screenshotBytes = IOsdriver.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotBytes, "image/png", "");
//		sa.assertAll();

		//		   TakesScreenshot screenShot=(TakesScreenshot)IOsdriver;
		//	        String base64file=screenShot.getScreenshotAs(OutputType.BASE64);
		//	        scenario.attach(base64file, "image/png", "");

		//	final byte[] screenshot = IOsdriver.getScreenshotAs(OutputType.BYTES);
		//		scenario.attach(screenshot, "image/png", "");

		// try {
		// final String screenshot = IOsdriver.getScreenshotAs(OutputType.BASE64);
		//   String base64Screenshot = Base64.encodeBase64String(screenshot);
		//	      scenario.attach(screenshot, "image/png", "Screenshot");

		//		      byte[] screenshot = ((TakesScreenshot) IOsdriver).getScreenshotAs(OutputType.BYTES);
		//              String base64Screenshot = Base64.encodeBase64String(screenshot);
		//              scenario.attach(base64Screenshot, "image/png", "image/png");
		//              
		//              
		//              
		//		    } catch (Exception e) {
		//		      e.printStackTrace();
		//		    }

	}

	@AfterAll
	public static void afterAll(){
		service.stop();
		if(sa != null) {
			sa.assertAll();
		}
	}

}
