package containerBCappHooks;

import containerBCapp.Baseclass.CommonUtilities;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import containerBCapp.ExcelRead.ExcelRead;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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




//            public static void main(String[] args) {
//
//
//                // Extract the date text from the element
//                String dateText = "20/04/2023";
//                // Define the expected date format using a regular expression
//                String expectedDateFormat = "\\d{2}/\\d{2}/\\d{4}"; // For example, MM/DD/YYYY
//
//                // Create a pattern and matcher for regex matching
//                Pattern pattern = Pattern.compile(expectedDateFormat);
//                Matcher matcher = pattern.matcher(dateText);
//
//                // Check if the date matches the expected format
//                if (matcher.matches()) {
//                    System.out.println("Date format is valid: " + dateText);
//                } else {
//                    System.out.println("Date format is not valid: " + dateText);
//                }


//            }

//    public static void main(String[] args) {
//        boolean status = true;
//        Assert.assertFalse(status, "answer is true");;
//    }



    @AfterAll
    public static void afterAll() {
//		service.stop();
//		if(sa != null) {
//			sa.assertAll();
//		}
    }

}
